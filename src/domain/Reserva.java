package domain;

public class Reserva {
    private int idReserva;
    private int idViajante;
    private int idCidade;
    private int idGuia;
    private String dataHorario;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdViajante() {
        return idViajante;
    }

    public void setIdViajante(int idViajante) {
        this.idViajante = idViajante;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public int getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(int idGuia) {
        this.idGuia = idGuia;
    }

    public String getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(String dataHorario) {
        this.dataHorario = dataHorario;
    }
}
