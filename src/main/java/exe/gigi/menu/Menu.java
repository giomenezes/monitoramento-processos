package exe.gigi.menu;

import exe.gigi.dao.ProcessoDao;
import exe.gigi.dao.ServidorDao;
import exe.gigi.maquina.Servidor;

public class Menu {
    private static Servidor s = null;
    public static void exibirMenu() {

        while(s != null) {
            Output.limparConsole();
            Output.exibirMenuInicial(s);
            switch (Input.solicitarOpcaoInt()) {
                case 1 -> Output.mostrarProcessos();
                case 2 -> Output.getTotalProcessos(s);
                case 3 -> Output.getTotalThreads(s);
                case 0 -> Output.exibirMensagemSair();
                default -> Output.opcaoInvalida();
            }
        }
    }

    public static void escolherServidor(){

        do {
            Output.limparConsole();
            s = Output.escolherServidor();
        } while (s == null);

        ProcessoDao.setServidor(s);
    }
}
