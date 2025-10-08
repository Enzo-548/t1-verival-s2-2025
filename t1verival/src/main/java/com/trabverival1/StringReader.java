package com.trabverival1;

public class StringReader{
    public String stringA;
    public String stringB;

    public StringReader(String stringA, String stringB){
        this.stringA = stringA;
        this.stringB = stringB;
    }

    public String sumStrings(String a, String b){
        //verifica se o caractere é valido
        assert verificaCaractereValido() : "Alguma das strings possui caracteres invalidos";
    
        // Formata de forma que elimina os zeros a esquerda
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
                // Converter o caractere '0'-'9' em número inteiro
                digitA = Character.getNumericValue(a.charAt(i));
                i--; // andar para a esquerda
            }

            if (j >= 0) {
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

    //verifica se o caractere e valido para a soma
    public boolean verificaCaractereValido(){
        if ((stringA == null || stringA.isEmpty()) || (stringB==null || stringB.isEmpty())) {
            return false;
        }
        int i = stringA.length();
        int j = stringB.length();
        while (true) {
        if (i>0) {
            i--;
        }
        if(j>0){
            j--;
        }
            
        if ((stringA.charAt(i) < 48 || stringA.charAt(i) > 57) ||
            (stringB.charAt(j) < 48 || stringB.charAt(j) > 57)) {
            return false;
        }else if (i == 0 && j == 0) {
            break;
        }
    }
        return true;
    }

   
}