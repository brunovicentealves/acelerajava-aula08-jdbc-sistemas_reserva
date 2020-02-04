package domain;

public class TipoPasseio {
     private Integer idTipoPasseio;
     private String nomePasseio;
     private String descricaoPasseio;

    public void setIdTipoPasseio(Integer idTipoPasseio) {
        this.idTipoPasseio = idTipoPasseio;
    }

    public void setNomePasseio(String nomePasseio) {
        this.nomePasseio = nomePasseio;
    }


    public void setDescricaoPasseio(String descricaoPasseio) {
        this.descricaoPasseio = descricaoPasseio;


    }


    public Integer getIdTipoPasseio() {
        return idTipoPasseio;
    }

    public String getNomePasseio() {
        return nomePasseio;
    }

    public String getDescricaoPasseio() {
        return descricaoPasseio;
    }
}
