package banco.util;

public class RegistroCPF {

    private String cpf;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
