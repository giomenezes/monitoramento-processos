package exe.gigi.maquina;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.mysql.cj.LicenseConfiguration;

import java.util.ArrayList;
import java.util.List;

public class CapturaProcesso {

    private static Looca looca = new Looca();

    public static List<Processo> getProcessos(){
        return looca.getGrupoDeProcessos().getProcessos();
    }

    public static Integer getTotalProcessos(){

        return looca.getGrupoDeProcessos().getTotalProcessos();
    }

    public static Integer getTotalThreads(){

        return looca.getGrupoDeProcessos().getTotalThreads();
    }
}
