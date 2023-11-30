# Java-Parqueadero
#La tarea principal era añadir a el proyecto de unos compañeros los metodos de estructuras de datos listas enlazadas, pilas y colas 
Me gustaria para mas claridad de este proyecto poner un poquito de como se implementaron estos proceso dentro del proyecto inicial.
La implementación se hizo as:

Listas Enlazadas (Historial de Vehículos):
Se implementó una lista enlazada dentro de la clase Historial para almacenar los vehículos que ingresaban al parqueadero.
Cada nodo de la lista contiene información como la placa del vehículo, su tipo, hora de entrada y hora de salida prevista.
Se agregaron métodos para agregar vehículos a esta lista, eliminarlos y mostrar la información de los vehículos registrados.
java


public class Historial {
    private class NodoVehiculo {
        private String placa;
        private String tipo;
        private LocalDateTime horaEntrada;
        private LocalDateTime horaSalidaPrevista;
        private NodoVehiculo siguiente;

        // ... métodos de getters y setters ...
    }

    private NodoVehiculo cabeza;

    // Métodos para manipular la lista enlazada
    public void agregarVehiculo(String placa, String tipo, LocalDateTime horaEntrada, LocalDateTime horaSalidaPrevista) {
        // Lógica para agregar un vehículo a la lista enlazada
    }

    // Otros métodos para manipular la lista enlazada de vehículos
    // ...
}
Pilas (Gestión de Espacios Disponibles):
Se utilizó una pila para gestionar los espacios disponibles en la clase Sede del parqueadero.
Cuando se creaba una sede, se llenaba la pila con números que representaban los espacios disponibles.
Al asignar un vehículo a un espacio, se retiraba el número de puesto de la pila y se asignaba al vehículo.
java
Copy code
public class Sede {
    private Stack<Integer> espaciosDisponibles;

    public Sede(String nombre, String ciudad) {
        // Llenado de la pila con los números de espacios disponibles
        this.espaciosDisponibles = new Stack<>();
        // Resto del código...
    }

    // Otros métodos de la clase Sede
    // ...
}
Colas (Gestión de Espera de Vehículos):
Se empleó una cola para mantener un registro de espera en la clase Espacio cuando el espacio estaba ocupado.
Si un espacio estaba ocupado, el vehículo que intentaba ingresar se agregaba a esta cola de espera.
java
Copy code
public class Espacio {
    private Queue<Vehiculo> colaEspera;

    public Espacio() {
        this.colaEspera = new LinkedList<>();
        // Resto del código...
    }

    // Métodos para asignar y quitar un puesto y trabajar con la cola de espera
    // ...
}


CAMBIOS
Clase Conductor:
Cambios:
  Se agregaron getters para obtener los atributos nombre, licencia e id.
Clase Vehiculo:
Cambios:
  Se añadieron los atributos horaEntrada y horaSalidaPrevista.
  Se modificó el constructor para asignar la horaEntrada al crear un vehículo.
  Se agregaron getters para obtener la horaEntrada y horaSalidaPrevista.
Clase Espacio:
Cambios:
  Se añadió la cola colaEspera para gestionar vehículos en espera.
  Se actualizó el método AsignarPuesto para asignar la horaSalidaPrevista al estacionar un vehículo y liberar el espacio correspondiente.
  Se realizaron cambios en otros métodos para trabajar con la cola de espera.
Clase Historial:
Cambios:
  Se implementó una cola colaEspera para mantener un registro adicional.
  Se agregaron métodos para trabajar con esta cola, como agregarVehiculoCola, eliminarVehiculoCola, mostrarVehiculosCola.
Clase Sede:
Cambios:
  Se actualizó AsignarEspacio para reflejar la lógica actualizada de registro de hora de salida prevista al asignar un espacio.
Clase Main:
Cambios:
  Se implementaron cambios en la lógica de asignación de espacio para reflejar la nueva información de hora de salida prevista.
