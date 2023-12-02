package exe.gigi.menu;

import java.util.Scanner;

public class Input {
    private static Scanner leitorString = new Scanner(System.in);
    private static Scanner leitorInt = new Scanner(System.in);

    public static Integer solicitarOpcaoInt() {
        return leitorInt.nextInt();
    }

    public static String solicitarOpcaoString() {
        return leitorString.nextLine();
    }
}
