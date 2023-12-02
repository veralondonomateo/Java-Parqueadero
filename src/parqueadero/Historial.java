package parqueadero;
import java.time.LocalDateTime;
import java.util.Queue;
import java.util.LinkedList;

public class Historial {
    private class NodoVehiculo {
        private String placa;
        private String tipo;
        private LocalDateTime horaEntrada;
        private LocalDateTime horaSalidaPrevista;
        private NodoVehiculo siguiente;

        public NodoVehiculo(String placa, String tipo, LocalDateTime horaEntrada, LocalDateTime horaSalidaPrevista) {
            this.placa = placa;
            this.tipo = tipo;
            this.horaEntrada = horaEntrada;
            this.horaSalidaPrevista = horaSalidaPrevista;
            this.siguiente = null;
        }

        // Getters y Setters
        public String getPlaca() {
            return placa;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public LocalDateTime getHoraEntrada() {
            return horaEntrada;
        }

        public void setHoraEntrada(LocalDateTime horaEntrada) {
            this.horaEntrada = horaEntrada;
        }

        public LocalDateTime getHoraSalidaPrevista() {
            return horaSalidaPrevista;
        }

        public void setHoraSalidaPrevista(LocalDateTime horaSalidaPrevista) {
            this.horaSalidaPrevista = horaSalidaPrevista;
        }

        public NodoVehiculo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoVehiculo siguiente) {
            this.siguiente = siguiente;
        }
    }

    private NodoVehiculo cabeza;
    private Queue<NodoVehiculo> colaEspera;       // Getters y Setters





    public Historial() {
        this.cabeza = null;
        this.colaEspera = new LinkedList<>();
    }

    public void agregarVehiculo(String placa, String tipo, LocalDateTime horaEntrada, LocalDateTime horaSalidaPrevista) {
        NodoVehiculo nuevoNodo = new NodoVehiculo(placa, tipo, horaEntrada, horaSalidaPrevista);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoVehiculo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }

    public void eliminarVehiculo(String placa) {
        if (cabeza != null) {
            if (cabeza.placa.equals(placa)) {
                cabeza = cabeza.siguiente;
            } else {
                NodoVehiculo temp = cabeza;
                while (temp.siguiente != null && !temp.siguiente.placa.equals(placa)) {
                    temp = temp.siguiente;
                }
                if (temp.siguiente != null) {
                    temp.siguiente = temp.siguiente.siguiente;
                }
            }
        }
    }

    public void mostrarVehiculos() {
        NodoVehiculo temp = cabeza;
        while (temp != null) {
            System.out.println("Placa: " + temp.placa + ", Tipo: " + temp.tipo +
                    ", Hora de entrada: " + temp.horaEntrada +
                    ", Hora de salida prevista: " + temp.horaSalidaPrevista);
            temp = temp.siguiente;
        }
    }

    // Métodos para trabajar con la cola
    public void agregarVehiculoCola(String placa, String tipo, LocalDateTime horaEntrada, LocalDateTime horaSalidaPrevista) {
        NodoVehiculo nuevoNodo = new NodoVehiculo(placa, tipo, horaEntrada, horaSalidaPrevista);
        colaEspera.offer(nuevoNodo);
    }

    public void eliminarVehiculoCola(String placa) {

    }

    public void mostrarVehiculosCola() {
        Queue<NodoVehiculo> colaCopia = new LinkedList<>(colaEspera);

        System.out.println("Vehículos en la cola de espera:");
        while (!colaCopia.isEmpty()) {
            NodoVehiculo vehiculo = colaCopia.poll();
            System.out.println("Placa: " + vehiculo.placa +
                    ", Tipo: " + vehiculo.tipo +
                    ", Hora de entrada: " + vehiculo.horaEntrada +
                    ", Hora de salida prevista: " + vehiculo.horaSalidaPrevista);
        }}}

