package exe.gigi.maquina;

public class Servidor {
    private Integer idServidor;
    private String nome;
    private String codigo;
    private String descricao;
    private String localizacao;
    private Integer status;

    public Servidor() {}

    public Integer getIdServidor() {
        return idServidor;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setIdServidor(Integer idServidor) {
        this.idServidor = idServidor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
