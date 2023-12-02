package exe.gigi;

import exe.gigi.rotina.SalvarProcessos;
import exe.gigi.menu.Menu;
import exe.gigi.rotina.Agendador;

public class Main {
    public static void main(String[] args) {
        Menu.escolherServidor();

        Agendador.executarTarefa(new SalvarProcessos(), 0, 3000);

        Menu.exibirMenu();
    }
}