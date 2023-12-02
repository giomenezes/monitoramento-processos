package gigi.exe;

import com.github.britooo.looca.api.group.processos.Processo;
import gigi.exe.dao.ProcessoDao;
import gigi.exe.maquina.CapturaProcesso;
import gigi.exe.menu.Output;

import java.util.List;

public class Teste {

    public static void main(String[] args) {

//        List<CapturaProcesso> capturaProcessos = ProcessoDao.listar(Output.escolherServidor());

//        System.out.println(capturaProcessos);

        CapturaProcesso p = new CapturaProcesso();

        Output.mostrarProcessos();

    }
}
