package util;

import java.util.Scanner;

public class LeitoraDados {
    private Scanner scanner;

    public LeitoraDados() {
        scanner = new Scanner(System.in);
    }

    public String lerTexto() {
        return scanner.nextLine();
    }

    public int lerInt() {
        int valor = scanner.nextInt();
        limparBuffer();
        return valor;
    }

    public double lerDouble() {
        double valor = scanner.nextDouble();
        limparBuffer();
        return valor;
    }

    public char lerChar() {
        char valor = scanner.next().charAt(0);
        limparBuffer();
        return valor;
    }

    public void limparBuffer() {
        scanner.nextLine();
    }

    public void fecharLeitor() {
        scanner.close();
    }
}
