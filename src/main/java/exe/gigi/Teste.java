package exe.gigi;

import exe.gigi.maquina.CapturaProcesso;
import exe.gigi.menu.Output;

public class Teste {

    public static void main(String[] args) {

//        List<CapturaProcesso> capturaProcessos = ProcessoDao.listar(Output.escolherServidor());

//        System.out.println(capturaProcessos);

        CapturaProcesso p = new CapturaProcesso();

        Output.mostrarProcessos();

    }
}
