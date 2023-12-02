package exe.gigi.rotina;

import java.util.Timer;
import java.util.TimerTask;

public class Agendador {
    private static Timer agendador = new Timer();

    public static void executarTarefa(TimerTask tarefa, int delay, int periodo) {
        agendador.schedule(tarefa, delay, periodo);
    }

    public static void pararTarefa() {
        agendador.cancel();
    }
}
