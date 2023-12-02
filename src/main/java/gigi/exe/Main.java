package gigi.exe;

import gigi.exe.maquina.Servidor;
import gigi.exe.menu.Menu;
import gigi.exe.rotina.Agendador;
import gigi.exe.rotina.SalvarProcessos;

public class Main {
    public static void main(String[] args) {
        Menu.escolherServidor();

        Agendador.executarTarefa(new SalvarProcessos(), 0, 3000);

        Menu.exibirMenu();
    }
}