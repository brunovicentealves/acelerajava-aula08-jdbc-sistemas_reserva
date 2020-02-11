package domain;

public class Viajante {
    private int idViajante;
    private String nomeViajante;
    private String documento_viajante;
    private String dataNascimento;

    public int getIdViajante() {
        return idViajante;
    }

    public void setIdViajante(int idViajante) {
        this.idViajante = idViajante;
    }

    public String getNomeViajante() {
        return nomeViajante;
    }

    public void setNomeViajante(String nomeViajante) {
        this.nomeViajante = nomeViajante;
    }

    public String getDocumento_viajante() {
        return documento_viajante;
    }

    public void setDocumento_viajante(String documento_viajante) {
        this.documento_viajante = documento_viajante;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
