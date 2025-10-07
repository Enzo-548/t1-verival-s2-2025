package tests

import (
	"context"
	"fmt"
	"net/url"
	"os/exec"
	"sync"
	"testing"
	"time"

	"github.com/gorilla/websocket"
)

const (
	serverAddr      = "localhost:8080"
	qosLimit        = 100 * time.Millisecond // Nosso requisito de tempo real (LET = 100ms)
	serverReadyTime = 2 * time.Second        // Tempo para o servidor iniciar
	testTimeout     = 5 * time.Second        // Timeout geral para o teste não travar
)

func runServerInBackground(ctx context.Context, t *testing.T) {
	chatServerPath := "../"

	cmd := exec.CommandContext(ctx, "go", "run", ".")
	cmd.Dir = chatServerPath

	output, err := cmd.CombinedOutput()
	if err != nil {
		// Ignoramos o erro de "signal: killed" que acontece quando encerramos o processo de propósito.
		if ctx.Err() == nil {
			t.Logf("Saída do servidor: %s", string(output))
			t.Fatalf("Falha ao executar o servidor de chat: %v", err)
		}
	}
}

// TestChatQoS é o nosso caso de teste principal, atuando como o MTC.
// Ele valida o contrato temporal (QoS) do servidor de chat.
func TestChatQoS(t *testing.T) {
	ctx, cancel := context.WithTimeout(context.Background(), testTimeout)
	defer cancel()

	// 1. MTC inicia o IUT (servidor) em background
	go runServerInBackground(ctx, t)
	t.Log("MTC: Servidor (IUT) iniciado em background...")
	time.Sleep(serverReadyTime) // Damos um tempo para o servidor subir completamente

	// 2. MTC prepara os TCs (clientes) para se conectarem ao IUT
	u := url.URL{Scheme: "ws", Host: serverAddr, Path: "/ws"}

	// Conecta o Cliente 1 (remetente)
	client1, _, err := websocket.DefaultDialer.Dial(u.String(), nil)
	if err != nil {
		t.Fatalf("MTC: Falha ao conectar cliente 1 (TC1): %v", err)
	}
	defer client1.Close()
	t.Log("MTC: Cliente 1 (TC1) conectado.")

	// Conecta o Cliente 2 (receptor)
	client2, _, err := websocket.DefaultDialer.Dial(u.String(), nil)
	if err != nil {
		t.Fatalf("MTC: Falha ao conectar cliente 2 (TC2): %v", err)
	}
	defer client2.Close()
	t.Log("MTC: Cliente 2 (TC2) conectado.")

	var wg sync.WaitGroup
	wg.Add(1)

	var receiveTime time.Time
	messageToSend := fmt.Sprintf("Mensagem de teste @ %d", time.Now().UnixNano())

	// 3. MTC instrui o Cliente 2 (TC2) a escutar por uma mensagem.
	// Isso corresponde ao estado de espera por um evento `?message` no rt-TTCN.
	go func() {
		defer wg.Done()
		for {
			_, message, err := client2.ReadMessage()
			if err != nil {
				return
			}

			if string(message) == messageToSend {
				receiveTime = time.Now()
				return
			}
		}
	}()

	// 4. MTC instrui o Cliente 1 (TC1) a enviar a mensagem e registra o tempo de início.
	// Este é o evento que dispara a contagem de tempo para o LET.
	sendTime := time.Now()
	if err := client1.WriteMessage(websocket.TextMessage, []byte(messageToSend)); err != nil {
		t.Fatalf("MTC: TC1 falhou ao enviar mensagem: %v", err)
	}
	t.Logf("MTC: TC1 enviou a mensagem: '%s'", messageToSend)

	// 5. MTC aguarda a confirmação de que o Cliente 2 recebeu a mensagem.
	wg.Wait()

	// 6. MTC calcula o atraso e aplica o veredito, validando o LET.
	if receiveTime.IsZero() {
		t.Fatal("Veredito: FALHA. TC2 não recebeu a mensagem esperada.")
	}

	delay := receiveTime.Sub(sendTime)
	t.Logf("MTC: Tempo de propagação da mensagem (atraso): %v", delay)

	if delay > qosLimit {
		t.Errorf("Veredito: FALHA. Violação de QoS! O atraso de %v excedeu o limite de %v (LET).", delay, qosLimit)
	} else {
		t.Logf("Veredito: SUCESSO. O sistema cumpriu o contrato temporal de QoS (LET de %v).", qosLimit)
	}
}
