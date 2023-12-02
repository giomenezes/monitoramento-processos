package gigi.exe.maquina;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.mysql.cj.LicenseConfiguration;

import java.util.ArrayList;
import java.util.List;

public class CapturaProcesso {

    private Looca looca = new Looca();

    public List<Processo> getProcessos(){
        return looca.getGrupoDeProcessos().getProcessos();
    }

    public Integer getTotalProcessos(){

        return looca.getGrupoDeProcessos().getTotalProcessos();
    }

    public Integer getTotalThreads(){

        return looca.getGrupoDeProcessos().getTotalThreads();
    }
}
