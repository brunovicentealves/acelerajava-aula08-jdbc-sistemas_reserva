package domain;

public class Guia {
    private int idGuia;
    private String nomeGuia;
    private String documentoGuia;
    private String dataNascimento;
    private String credencial;
    private int idModalidade;
    private int idTipoPasseio;

    public int getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(int idGuia) {
        this.idGuia = idGuia;
    }

    public String getNomeGuia() {
        return nomeGuia;
    }

    public void setNomeGuia(String nomeGuia) {
        this.nomeGuia = nomeGuia;
    }

    public String getDocumentoGuia() {
        return documentoGuia;
    }

    public void setDocumentoGuia(String documentoGuia) {
        this.documentoGuia = documentoGuia;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public int getIdModalidade() {
        return idModalidade;
    }

    public void setIdModalidade(int idModalidade) {
        this.idModalidade = idModalidade;
    }

    public int getIdTipoPasseio() {
        return idTipoPasseio;
    }

    public void setIdTipoPasseio(int idTipoPasseio) {
        this.idTipoPasseio = idTipoPasseio;
    }
}
