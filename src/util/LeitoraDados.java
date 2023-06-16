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
        return scanner.nextInt();
    }

    public double lerDouble() {
        return scanner.nextDouble();
    }

    public char lerChar() {
        return scanner.next().charAt(0);
    }

    public void fecharLeitor() {
        scanner.close();
    }
}
