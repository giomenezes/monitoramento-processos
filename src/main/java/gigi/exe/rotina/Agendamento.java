package gigi.exe.rotina;

import java.util.Timer;
import java.util.TimerTask;

public class Agendamento {
    private static Timer agendamento = new Timer();

    public static void executarAgendamento(TimerTask tarefa) {
        agendamento.schedule(tarefa, 1000, 1000);
    }
}
