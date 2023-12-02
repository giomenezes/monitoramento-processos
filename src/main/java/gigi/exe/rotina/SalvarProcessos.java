package gigi.exe.rotina;

import gigi.exe.dao.ProcessoDao;

import java.util.TimerTask;

public class SalvarProcessos extends TimerTask {
    @Override
    public void run() {
        ProcessoDao.inserirProcesso();
    }
}
