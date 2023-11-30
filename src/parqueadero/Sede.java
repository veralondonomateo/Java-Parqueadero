package parqueadero;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.Stack;

public class Sede {
    private String ciudad, nombre;
    private Espacio[] espaciosEnParqueadero;
    private Historial historial = new Historial(); // Creación de la instancia de Historial
    private Scanner sc = new Scanner(System.in);
    private Stack<Integer> espaciosDisponibles;

    public Sede(String nombre, String ciudad) {
        this.ciudad = ciudad;
        this.nombre = nombre;
        System.out.print("Parqueadero: ¿Cuántos puestos tendrá en su sede? ");
        int puestos = Integer.parseInt(sc.nextLine());
        this.espaciosEnParqueadero = new Espacio[puestos];
        this.espaciosDisponibles = new Stack<>();
        System.out.println("Parqueadero: Ha creado el parqueadero correctamente.");
        for (int i = puestos - 1; i >= 0; i--) {
            espaciosEnParqueadero[i] = new Espacio();
            espaciosDisponibles.push(i);
        }
    }

    public void CambiarInformacion() {
        System.out.println("\t| INFO ACTUAL |");
        System.out.println("Nombre del parqueadero: " + this.nombre);
        System.out.println("Ciudad donde se ubica: " + this.ciudad);
        System.out.print("\nNuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nueva ciudad: ");
        String ciudad = sc.nextLine();
        this.nombre = nombre;
        this.ciudad = ciudad;
        System.out.println("Parqueadero: Se han cambiado los datos correctamente.");
    }

    public void VerParqueadero() {
        System.out.println("Parqueadero: Los espacios con X están ocupados.");
        for (int i = 0; i < this.espaciosEnParqueadero.length; i++) {
            if (this.espaciosEnParqueadero[i].getDisponibilidad()) {
                System.out.print(i + ".[ ] -> ");
            } else {
                System.out.print(i + ".[ X ] -> ");
            }
        }
        System.out.print("NULL\n");
    }

    public void AsignarEspacio(Vehiculo vehiculoOcupando, int puesto) {
        if (puesto >= 0 && puesto < espaciosEnParqueadero.length && vehiculoOcupando != null) {
            if (espaciosEnParqueadero[puesto].AsignarPuesto(vehiculoOcupando)) {
                historial.agregarVehiculoCola(vehiculoOcupando.getPlaca(), vehiculoOcupando.getModelo(),
                        LocalDateTime.now(), vehiculoOcupando.getHoraSalidaPrevista()); // Modifica el uso de horaEntrada
                System.out.println("Vehículo asignado al puesto: " + puesto);
            }
        } else {
            System.out.println("El puesto no es válido.");
        }
    }

    public void QuitarEspacio(int puesto) {
        if (puesto >= 0 && puesto < espaciosEnParqueadero.length) {
            Vehiculo vehiculoActual = espaciosEnParqueadero[puesto].getVehiculoOcupando();
            if (espaciosEnParqueadero[puesto].QuitarPuesto()) {
                historial.eliminarVehiculoCola(vehiculoActual.getPlaca()); // Elimina vehículo de la cola utilizando la finalidad de primero en entrar primero en salir
                System.out.println("Espacio liberado: " + puesto);
            }
        } else {
            System.out.println("El puesto no es válido.");
        }
    }

    public Historial getHistorial() {
        return historial;
    }
}