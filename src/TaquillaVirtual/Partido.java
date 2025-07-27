package TaquillaVirtual;

public class Partido {
    private String equipolocal;
    private String equipoVisitante;
    private String fecha;

    public Partido(String equipolocal, String equipoVisitante, String fecha) {
        this.equipolocal = equipolocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
    }

    public String getEquipoLocal() {
        return equipolocal;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }
}
