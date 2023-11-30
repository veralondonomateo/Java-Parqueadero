package parqueadero;

public class Conductor {

    private String nombre, licencia, id;

    public Conductor(String nombre, String licencia, String id) {
        this.nombre = nombre;
        this.licencia = licencia;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    public String getId() {
        return id;
    }
}
