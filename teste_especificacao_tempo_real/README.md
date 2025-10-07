Trabalho T1: Teste Baseado em Especificação Temporal
Este repositório contém a implementação de um teste automatizado que valida um requisito de tempo real, como parte do Trabalho T1 de Verificação e Validação de Software.

O Sistema sob Teste (SUT) é um servidor de chat em tempo real, baseado no exemplo oficial fornecido pelo pacote gorilla/websocket, que serve como uma base prática para a nossa análise de teste.

1. O Teste Baseado em Especificação
O foco deste trabalho é a aplicação do Teste Baseado em Especificação. Em vez de testar a lógica interna do código (teste de caixa-branca), nós tratamos o servidor como uma caixa-preta e validamos seu comportamento contra um requisito externo bem definido.

A Especificação Testada
O nosso teste valida a seguinte especificação não-funcional de Qualidade de Serviço (QoS):

Uma mensagem enviada por um cliente deve ser retransmitida e recebida pelos outros clientes em um prazo máximo de 100 milissegundos.

O arquivo qos_test.go foi projetado para verificar, de forma automática e objetiva, se o servidor está em conformidade com esta especificação.

2. Arquitetura do Teste (As Siglas do Projeto)
Para estruturar o teste, usamos uma arquitetura com os seguintes papéis, inspirada em frameworks formais de teste:

IUT (Implementation Under Test):

O que é: O código do Servidor de Chat (main.go, hub.go, etc.).

Função: É o "alvo" do nosso teste, o sistema que estamos validando.

TC (Test Component):

O que é: Os clientes WebSocket simulados que o script de teste cria.

Função: São os "atores" que interagem com o IUT (enviam e recebem mensagens).

MTC (Main Test Component):

O que é: O arquivo test/qos_test.go.

Função: É o "maestro" que gerencia todo o processo: inicia o IUT, coordena os TCs, mede o tempo de resposta e dá o veredito final (se o sistema passou ou falhou no teste).

3. Como Executar
Pré-requisitos:

Go (versão 1.18 ou superior) instalado.

Siga os passos abaixo no terminal, a partir da pasta raiz do projeto (chat/).

Passo 1: Preparar o Ambiente

Estes comandos preparam o projeto e baixam as dependências. Você só precisa rodá-los uma vez.

# Inicia o módulo Go
go mod init chat

# Baixa a biblioteca websocket
go get github.com/gorilla/websocket
Passo 2: Executar o Teste

Este comando executa o nosso MTC (qos_test.go), que fará todo o trabalho de iniciar o servidor, testar e apresentar o resultado.

# O comando -v (verbose) mostra detalhes da execução
go test -v ./test/...
A saída no terminal informará se o servidor cumpriu (SUCESSO) ou violou (FALHA) a 