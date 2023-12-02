package gigi.exe.menu;

import gigi.exe.maquina.Servidor;

public class Menu {
    private static Servidor s = null;
    public static void exibirMenu() {
        do {
            s = Output.escolherServidor();
        } while (s == null);

        do {
            Output.exibirMenuInicial(s);
            switch (Input.solicitarOpcaoInt()) {
                case 1 -> Output.mostrarProcessos();
                case 2 -> Output.getTotalProcessos(s);
                case 3 -> Output.getTotalThreads(s);
                case 0 -> Output.exibirMensagemSair();
                default -> Output.opcaoInvalida();
            }
        } while(true);
    }
}
