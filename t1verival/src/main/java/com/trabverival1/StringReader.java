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
        //Verifica se pode ser aceito
        assert verificaTamCaractere();
        
        StringBuilder soma = new StringBuilder();

        char[] ca = sA.toCharArray();
        char[] cb = sB.toCharArray();
        char[] cc = new char[ca.length + cb.length];

        for (int i = 0; i < cc.length-1; i++) {

            for (int j = 0; j < cc.length-1; j++) {
                cc[i] = '0';
            }
        //Verifica se o caractere se encaixa na condição
        assert verificaCaractereValido(i);
        
        //TODO SOMA DAS DUAS STRINGS
        }

        return soma.toString();
    }

    public boolean verificaCaractereValido(int i){
        if ((stringA.charAt(i) > 9 && stringA.charAt(i)<0) || 
        (stringB.charAt(i) > 9 && stringB.charAt(i)<0)) {
            return false;
        }
        return true;
    }

    public boolean verificaTamCaractere(){
    //Verifica se o caractere esta dentro dos lmites aceitos pelo integer
        if (stringA.length()==10 || stringB.length()==10) {
            String comp = "2147483647";
            if(stringA.length() == 10){
            for (int i = 0; i < stringA.length()-1; i++) {
                if (stringA.length()> comp.charAt(i)) {
                    return false;
                }
            }
        } else if (stringA.length() == 10){
            for (int i = 0; i < stringB.length()-1; i++) {
                if (stringB.charAt(i) > comp.charAt(i)) {
                    return false;
                }
            }
        }
    }
        return true;
    }
    public int soma(int a, int b){
        int result = a+b;
        return result;
    }
}