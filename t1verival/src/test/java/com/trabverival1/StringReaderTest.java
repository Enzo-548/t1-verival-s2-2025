package com.trabverival1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StringReaderTest {

    @Test
    public void testSomaBasica() {
        StringReader reader = new StringReader("123", "456");
        assertEquals("579", reader.sumStrings(reader.stringA, reader.stringB), "A soma de 123 + 456 deve ser 579");
    }

//Resultados esperados: Assertion Error: Alguma das strings possui caracteres invalidos
    @Test
    public void testStringVazia() {
        StringReader reader = new StringReader("-1", "45");
        assertFalse(reader.verificaCaractereValido(), "Nao deve passar o teste, devida a string negativa");
    }
//Resultados esperados: Assertion Error: Alguma das strings possui caracteres invalidos
    @Test
    public void testVerificaCaractereValido() {
        StringReader reader = new StringReader("12a", "34");
        assertFalse(reader.verificaCaractereValido(), "Caracterere inválido na StringA;");
    }
}

