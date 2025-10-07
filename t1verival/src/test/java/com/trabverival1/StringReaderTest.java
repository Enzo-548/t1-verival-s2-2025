package com.trabverival1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StringReaderTest {

    @Test
    public void testSomaBasica() {
        StringReader reader = new StringReader("123", "456");
        assertEquals("579", reader.sum, "A soma de 123 + 456 deve ser 579");
    }

    @Test
    public void testStringVazia() {
        StringReader reader = new StringReader("", "45");
        assertEquals("45", reader.sum, "String vazia deve retornar o outro valor");
    }

    @Test
    public void testVerificaCaractereValido() {
        StringReader reader = new StringReader("120", "34");
        assertTrue(reader.verificaCaractereValido(0,reader.stringB), "Caracteres numéricos na stringB devem ser válidos");
    }
}

