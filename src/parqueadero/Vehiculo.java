package parqueadero;

import java.time.LocalDateTime;

public class Vehiculo {

    private String placa, modelo;
    private Conductor conductor;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalidaPrevista;

    public Vehiculo(String placa, String modelo, Conductor conductor) {
        this.placa = placa;
        this.modelo = modelo;
        this.conductor = conductor;
        this.horaEntrada = LocalDateTime.now(); // Establecer la hora de entrada como el momento actual
    }

    // Método para establecer la hora de salida prevista
    public void setHoraSalidaPrevista(LocalDateTime horaSalidaPrevista) {
        this.horaSalidaPrevista = horaSalidaPrevista;
    }

    // Getters para placa, modelo, conductor, hora de entrada y hora de salida prevista
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSalidaPrevista() {
        return horaSalidaPrevista;
    }
}