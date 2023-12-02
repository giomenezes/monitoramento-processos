package gigi.exe.menu;

import java.util.Scanner;

public class Input {
    private static Scanner leitorString = new Scanner(System.in);
    private static Scanner leitorInt = new Scanner(System.in);

    public static Integer solicitarOpcaoInt() {
        System.out.println("Selecione uma opção:");
        return leitorInt.nextInt();
    }

    public static String solicitarOpcaoString() {
        System.out.println("Selecione uma opção:");
        return leitorString.nextLine();
    }
}
