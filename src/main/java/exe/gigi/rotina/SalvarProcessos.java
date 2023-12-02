package exe.gigi.rotina;

import exe.gigi.dao.ProcessoDao;

import java.util.TimerTask;

public class SalvarProcessos extends TimerTask {
    @Override
    public void run() {
        ProcessoDao.inserirProcesso();
    }
}
