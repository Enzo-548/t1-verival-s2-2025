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

    public String sumStrings(String a, String b){
        //verifica se o caractere é valido
        assert verificaTamCaractere();
        
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;

        // Remover zeros à esquerda
        a = a.replaceFirst("^0+(?!$)", "");
        b = b.replaceFirst("^0+(?!$)", "");

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Soma dígito a dígito, como no papel
        while (i >= 0 || j >= 0 || carry > 0) {
            int digitA = 0;
            int digitB = 0;

            if (i >= 0) {
                //verifica se o caractere é valido
                assert verificaCaractereValido(i);

                // Converter o caractere '0'-'9' em número inteiro
                digitA = Character.getNumericValue(a.charAt(i));
                i--; // andar para a esquerda
            }

            if (j >= 0) {
                //verifica se o caractere é valido
                assert verificaCaractereValido(j);

                digitB = Character.getNumericValue(b.charAt(j));
                j--;
            }

            int sum = digitA + digitB + carry;

            // Atualiza o transporte e o dígito atual
            carry = sum / 10;     // divisão inteira
            int current = sum % 10; // resto da divisão (último dígito)

            sb.append(current);
        }

        // O resultado foi montado de trás para frente
        return sb.reverse().toString();
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
}