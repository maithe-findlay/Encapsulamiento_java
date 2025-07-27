package MonitorMascota;

public class Monitor {
    // atributos privados
    private String nombre;
    private String codigoEstudiante;
    private String eventoAsignado;
    private double horasAcumuladas;

    //constructor
    public Monitor(String nombre, String codigoEstudiante, String eventoAsingnado) {
        this.nombre = nombre;
        this.codigoEstudiante = codigoEstudiante;
        this.eventoAsignado = eventoAsingnado;
        this.horasAcumuladas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getHorasAcumuladas() {
        return horasAcumuladas;
    }

    public String getEventoAsingnado() {
        return eventoAsignado;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }
    //método para registrar las horas
    public void registrarHoras(double horas){
        this.horasAcumuladas += horas;
    }

    //método para verificar el estado
    public String verificarEstado(){
        if (horasAcumuladas >= 8 ){
            return "Horas completadas";
        } else {
            return "tiene horas pendiente";
        }
    }
    // metodo to String, lo usamos para mostrar un resumen del monitor
    @Override
    public String toString(){
     return "Nombre:" + nombre +
             "\nEvento:" + eventoAsignado +
             "\nHoras acumuladas:" + horasAcumuladas +
                "\nEstado:" + verificarEstado() + "\n";

    }
}
