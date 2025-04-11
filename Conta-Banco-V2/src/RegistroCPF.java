public class RegistroCPF {

    //esta classe recebe o cpf do usuario e verifica se ele é valido
    //se o cpf for valido, ele retorna true, se não, retorna false
    //o cpf é valido se ele tiver 11 digitos e se os dois ultimos digitos forem validos
    //os dois ultimos digitos são validos por meio de um algoritmo de verificação
    //o algoritmo de verificação é o mesmo usado pelo CPF brasileiro



    public String cpf;
    
    public boolean cpfverific(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Character.getNumericValue(cpf.charAt(i));
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += digits[i] * (10 - i);
        }

        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }

        if (digits[9] != digito1) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += digits[i] * (11 - i);
        }

        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) {
            digito2 = 0;
        }

        return digits[10] == digito2;
    }

   
}