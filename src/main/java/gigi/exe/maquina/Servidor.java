package gigi.exe.maquina;

public class Servidor {
    private static Integer idServidor;
    private static String nome;
    private static String codigo;
    private static String descricao;
    private static String localizacao;
    private static Integer status;

    public Servidor() {}

    public static Integer getIdServidor() {
        return idServidor;
    }

    public static String getNome() {
        return nome;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static String getDescricao() {
        return descricao;
    }

    public static String getLocalizacao() {
        return localizacao;
    }

    public static Integer getStatus() {
        return status;
    }

    public static void setIdServidor(Integer idServidor) {
        Servidor.idServidor = idServidor;
    }

    public static void setNome(String nome) {
        Servidor.nome = nome;
    }

    public static void setCodigo(String codigo) {
        Servidor.codigo = codigo;
    }

    public static void setDescricao(String descricao) {
        Servidor.descricao = descricao;
    }

    public static void setLocalizacao(String localizacao) {
        Servidor.localizacao = localizacao;
    }

    public static void setStatus(Integer status) {
        Servidor.status = status;
    }

    @Override
    public String toString() {
        return """
               
        +------------------------------------------------------+
          Servidor: %s            
        +------------------------------------------------------+
          Nome: %s                     
          Descrição: %s
          Localização: %s
          Status: %d
        +------------------------------------------------------+
        """.formatted(codigo, nome, descricao, localizacao, status);
    }
}
