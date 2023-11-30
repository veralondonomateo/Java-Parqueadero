package parqueadero;

import java.util.Scanner;

public class Main{

    static Conductor DatosConductor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t| DATOS DEL CONDUCTOR |");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Licencia: ");
        String licencia = sc.nextLine();
        System.out.print("Identificacion: ");
        String id = sc.nextLine();
        return new Conductor(nombre, licencia, id);
    }

    static Vehiculo DatosVehiculo(Conductor conductor) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t| DATOS DEL VEHICULO |");
        System.out.print("Placa: ");
        String placa = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        return new Vehiculo(placa, modelo, conductor);
    }

    public static void main(String[] args) {
        System.out.println("\t***************");
        System.out.println("\t* PARQUEADERO *");
        System.out.println("\t***************");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre de su parqueadero: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la ciudad donde estará ubicado: ");
        String ciudad = sc.nextLine();
        Sede parqueadero = new Sede(nombre, ciudad);
        int puesto;
        int opcion = -1;
        do {
            System.out.println("\n1. Ver Parqueadero.");
            System.out.println("2. Asignar Un Espacio.");
            System.out.println("3. Liberar Un Espacio.");
            System.out.println("4. Ver Registros.");
            System.out.println("5. Cambiar Información.");
            System.out.println("0. Salir.");
            System.out.print("Ingrese la operación que desea realizar...");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    parqueadero.VerParqueadero();
                    break;
                case 2:
                    Vehiculo nuevoVehiculo = DatosVehiculo(DatosConductor());
                    System.out.print("Ingrese el número del puesto donde desea ubicarlo...");
                    puesto = Integer.parseInt(sc.nextLine());
                    parqueadero.AsignarEspacio(nuevoVehiculo, puesto);
                    break;
                case 3:
                    System.out.print("Ingrese el número del puesto donde desea liberar...");
                    puesto = Integer.parseInt(sc.nextLine());
                    parqueadero.QuitarEspacio(puesto);
                    break;
                case 4:
                    parqueadero.getHistorial().mostrarVehiculos();
                    break;
                case 5:
                    parqueadero.CambiarInformacion();
                    break;
            }
        } while (opcion != 0);
    }
}
