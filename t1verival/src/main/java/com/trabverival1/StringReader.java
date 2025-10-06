package com.trabverival1;

public class StringReader{
    public String stringA;
    public String stringB;
    public String sum;

    public StringReader(String stringA, String stringB){
        this.stringA = stringA;
        this.stringB = stringB;
        sum = sumStrings(stringA, stringB);
    }

    public String sumStrings(String sA, String sB){
        int soma = 0;
        
        //Verifica se pode virar char
        assert verificaTamCaractere();
        
        char[] ca = sA.toCharArray();
        char[] cb = sB.toCharArray();
        
        for (int i = 0; i < ca.length-1; i++) {
        //Verifica se o caractere se encaixa na condição
        assert verificaCaractereValido(i);
        
        soma = ca[i] + soma;

        }

        for (int i = 0; i < cb.length-1; i++) {
        //Verifica se o caractere se encaixa na condição
        assert verificaCaractereValido(i);
        
        soma = cb[i] + soma;

        }

        String cc = ""+soma;

        return cc;
    }

    public boolean verificaCaractereValido(int i){
        if ((stringA.charAt(i) > 9 && stringA.charAt(i)<0) || 
        (stringB.charAt(i) > 9 && stringB.charAt(i)<0)) {
            return false;
        }
        return true;
    }

    public boolean verificaTamCaractere(){
        if (stringA.length() > 1 || stringB.length() > 1) {
            return false;
        }
        return true;
    }
}