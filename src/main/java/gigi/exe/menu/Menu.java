package gigi.exe.menu;

import gigi.exe.maquina.Servidor;

public class Menu {
    private static Servidor s = null;
    public static void exibirMenu() {

        do {
            Output.exibirMenuInicial(s);
            switch (Input.solicitarOpcaoInt()) {
                case 1 -> Output.mostrarProcessos();
                case 2 -> Output.getTotalProcessos();
                case 3 -> Output.getTotalThreads();
                case 0 -> Output.exibirMensagemSair();
                default -> Output.opcaoInvalida();
            }
        } while(true);
    }

    public static void escolherServidor(){

        do {
            s = Output.escolherServidor();
        } while (s == null);
    }
}
