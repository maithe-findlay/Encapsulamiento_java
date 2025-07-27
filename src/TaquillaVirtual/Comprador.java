package TaquillaVirtual;

public class Comprador {
private String nombre;
private String documento;

    public Comprador(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }
}
