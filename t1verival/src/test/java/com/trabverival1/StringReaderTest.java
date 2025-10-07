package com.trabverival1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StringReaderTest {
@Test
public void testStringAVazia() {
    StringReader reader = new StringReader("", "123");
    assertEquals("123", reader.sumStrings(reader.stringA, reader.stringB));
}

@Test
public void testStringBVazia() {
    StringReader reader = new StringReader("456", "");
    assertEquals("456", reader.sumStrings(reader.stringA, reader.stringB));
}
//
    @Test
public void testStringANula() {
    StringReader reader = new StringReader(null, "123");
    assertFalse(reader.verificaCaractereValido());
}
    @Test
public void testSomaBasicaComUmDigito() {
    StringReader reader = new StringReader("1", "1");
    assertEquals("2", reader.sumStrings(reader.stringA, reader.stringB));
}
    @Test
    public void testSomaBasicaComTermosDeMesmoTamanhoEmStringAComCaractereInvalido() {
        StringReader reader = new StringReader("12a", "456");
        assertFalse(reader.verificaCaractereValido(), "A string a possui um caractere invalido");
    }

    @Test
    public void testSomaBasicaComTermosDeMesmoTamanhoEmStringBComCaractereInvalido() {
        StringReader reader = new StringReader("12*", "456");
        assertFalse(reader.verificaCaractereValido(), "A string a possui um caractere invalido");
    }

    @Test
    public void testSomaBasicaComTermosDeMesmoTamanho() {
        StringReader reader = new StringReader("123", "456");
        assertEquals("579", reader.sumStrings(reader.stringA, reader.stringB), "A soma de 123 + 456 deve ser 579");
    }

    @Test
    public void testSomaBasicaComTermosDeTamanhoDiferenteEmStringA() {
        StringReader reader = new StringReader("1230", "456");
        assertEquals("1686", reader.sumStrings(reader.stringA, reader.stringB), "A soma de 123 + 456 deve ser 579");
    }

    @Test
    public void testSomaBasicaComTermosDeTamanhoDiferenteEmStringB() {
        StringReader reader = new StringReader("123", "4560");
        assertEquals("4683", reader.sumStrings(reader.stringA, reader.stringB), "A soma de 123 + 456 deve ser 579");
    }

    @Test
    public void testSomaBasicaComCarry() {
        StringReader reader = new StringReader("553", "457");
        assertEquals("1010", reader.sumStrings(reader.stringA, reader.stringB), "A soma de 123 + 456 deve ser 579");
    }

//Resultados esperados: Assertion Error: Alguma das strings possui caracteres invalidos
    @Test
    public void testStringVaziaNaStringA() {
        StringReader reader = new StringReader("", "1");
        assertFalse(reader.verificaCaractereValido(), "Nao deve passar o teste, devida a string negativa");
    }
    @Test
    public void testStringVaziaComEspacoNaStringA() {
        StringReader reader = new StringReader(" ", "1");
        assertFalse(reader.verificaCaractereValido(), "Nao deve passar o teste, devida a string negativa");
    }
    @Test
    public void testStringVaziaNaStringB() {
        StringReader reader = new StringReader("1", "");
        assertFalse(reader.verificaCaractereValido(), "Nao deve passar o teste, devida a string negativa");
    }
    @Test
    public void testStringVaziaComEspacoNaStringB() {
        StringReader reader = new StringReader("1", " ");
        assertFalse(reader.verificaCaractereValido(), "Nao deve passar o teste, devida a string negativa");
    }
    @Test
    public void testCaractereInvalidoNasDuasStrings() {
        StringReader reader = new StringReader("null", "");
        assertFalse(reader.verificaCaractereValido(), "Nao deve passar o teste, devida a string negativa");
    }
//Resultados esperados: Assertion Error: Alguma das strings possui caracteres invalidos
//#####    
@Test
    public void testVerificaCaractereValidoParaStringAComCharMaiorQue56() {
        StringReader reader = new StringReader("12a", "34");
        assertFalse(reader.verificaCaractereValido(), "Caracterere inválido na StringA;");
    }
    public void testVerificaCaractereValidoParaStringAComCharMenorQue48() {
        StringReader reader = new StringReader("12*", "34");
        assertFalse(reader.verificaCaractereValido(), "Caracterere inválido na StringA;");
    }
    @Test
    public void testVerificaCaractereValidoParaStringBComCharMaiorQue56() {
        StringReader reader = new StringReader("12", "34a");
        assertFalse(reader.verificaCaractereValido(), "Caracterere inválido na StringA;");
    }

    @Test
    public void testVerificaCaractereValidoParaStringBComCharMenorQue48() {
        StringReader reader = new StringReader("12", "34*");
        assertFalse(reader.verificaCaractereValido(), "Caracterere inválido na StringA;");
    }
}

