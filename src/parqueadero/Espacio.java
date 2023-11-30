package parqueadero;

import java.util.LinkedList;
import java.util.Queue;
//Asignamos la cola de espera es decir utilizamos queue donde el primero en entrar es el primero en salir
//Lo utilizamos con la finalidad de establecer una lista de espera para los usuarios que llegan cuando
//No tenemos espacio dentro de el parqueadero
public class Espacio {

    private Vehiculo vehiculoOcupando;
    private boolean disponibilidad = true;
    private Queue<Vehiculo> colaEspera; // Cola para mantener registro de espera

    public Espacio() {
        this.colaEspera = new LinkedList<>(); // Inicialización de la cola de espera
    }

    public boolean AsignarPuesto(Vehiculo vehiculo) {
        if (this.vehiculoOcupando == null) {
            this.vehiculoOcupando = vehiculo;
            this.disponibilidad = false;
            return true;
        } else {
            // Si el espacio está ocupado, agregar el vehículo a la cola de espera
            this.colaEspera.offer(vehiculo);
            return false;
        }
    }

    public boolean QuitarPuesto() {
        if (this.vehiculoOcupando != null) {
            this.vehiculoOcupando = null;
            this.disponibilidad = true;

            // Si hay vehículos esperando, asignar el siguiente de la cola al espacio
            if (!colaEspera.isEmpty()) {
                this.vehiculoOcupando = colaEspera.poll();
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public Vehiculo getVehiculoOcupando() {
        return vehiculoOcupando;
    }
}
