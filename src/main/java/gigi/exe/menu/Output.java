package gigi.exe.menu;

import com.github.britooo.looca.api.group.processos.Processo;
import gigi.exe.dao.ProcessoDao;
import gigi.exe.dao.ServidorDao;
import gigi.exe.maquina.CapturaProcesso;
import gigi.exe.maquina.Servidor;
import gigi.exe.utils.Conversor;

import java.util.List;
import java.util.Objects;

public class Output {
    public static void limparConsole() {
        System.out.print("\033[H\033[2J");
    }

    public static Servidor escolherServidor() {
        List<Servidor> servidores = ServidorDao.listar();
        System.out.println("Lista de servidores: \n" + servidores);

        String codigoServidor = Input.solicitarOpcaoString();
        for (Servidor servidorDaVez : servidores) {
            if (Servidor.getCodigo().equalsIgnoreCase(codigoServidor)){
                return servidorDaVez;
            }
        }

        System.out.println("Código inválido!");
        return null;
    }

    public static void exibirMenuInicial(Servidor s) {
        System.out.println(
                """
                +------------------------------------------------------+
                |  Grey Cloud Transactions                             |
                +------------------------------------------------------+
                | 1) Verificar processsos                              |
                | 2) Verificar total de processos                      |
                | 3) Verificar total de threads                        |
                |                                                      |
                | 0) Sair                                              |
                +------------------------------------------------------+""");

        if (s != null) {
            System.out.println(s);
        }
    }
    public static void exibirMensagemSair () { System.out.println("Saindo... ");
        System.exit(0);}

    public static void opcaoInvalida () { System.out.println("Opção inválida"); }

    public static void mostrarProcessos(){
        Output.limparConsole();

        for (Processo processoAtual : CapturaProcesso.getProcessos()) {

            System.out.printf("""
                                        
                            +------------------------------------------------------+
                              Processo: %d
                              Nome: %s
                            +------------------------------------------------------+
                              Uso de CPU: %f
                              Uso de memória: %f
                                        
                              Bytes utilizados: %f
                              Swap utilizada: %f
                            +------------------------------------------------------+
                            %n""", processoAtual.getPid(), processoAtual.getNome(), processoAtual.getUsoCpu(),
            processoAtual.getUsoMemoria(), Conversor.converterGB(processoAtual.getBytesUtilizados()), Conversor.converterGB(processoAtual.getMemoriaVirtualUtilizada()));
        }
    }

    public static List<CapturaProcesso> verificarProcessos() {
        List<CapturaProcesso> capturaProcessos = ProcessoDao.listar();

        if (capturaProcessos.isEmpty()) {
            System.out.println("A lista de processos está vazia!");
            return null;
        } else {
            return capturaProcessos;
        }
    }

    public static void getTotalProcessos() {
        Output.limparConsole();

        if (!Objects.requireNonNull(verificarProcessos()).isEmpty()) {
            Integer totalProcessos = CapturaProcesso.getTotalProcessos();
            System.out.println("Total de processos: " + totalProcessos);
        } else {
            System.out.println("A lista de processos está vazia!");
        }
    }

    public static void getTotalThreads() {
        Output.limparConsole();

        if (!Objects.requireNonNull(verificarProcessos()).isEmpty()) {
            Integer totalThreads = CapturaProcesso.getTotalThreads();
            System.out.println("Total de threads: " + totalThreads);
        } else {
            System.out.println("A lista de capturaProcessos está vazia!");
        }
    }
}
