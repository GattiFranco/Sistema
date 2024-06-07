package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú Principal");
            System.out.println("1. Gestión de Usuarios");
            System.out.println("   - Crear, editar, eliminar y consultar usuarios.");
            System.out.println("2. Gestión de Solicitudes de Turno");
            System.out.println("   - Crear, editar, eliminar y consultar solicitudes de turno.");
            System.out.println("3. Gestión de Pagos");
            System.out.println("   - Registrar, actualizar y consultar pagos.");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestionarUsuarios(scanner);
                    break;
                case 2:
                    gestionarSolicitudesTurno(scanner);
                    break;
                case 3:
                    gestionarPagos(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    public static void gestionarUsuarios(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Gestión de Usuarios");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Editar Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Consultar Usuarios");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para crear usuario
                    System.out.println("Creando Usuario...");
                    break;
                case 2:
                    // Lógica para editar usuario
                    System.out.println("Editando Usuario...");
                    break;
                case 3:
                    // Lógica para eliminar usuario
                    System.out.println("Eliminando Usuario...");
                    break;
                case 4:
                    // Lógica para consultar usuarios
                    System.out.println("Consultando Usuarios...");
                    break;
                case 5:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    public static void gestionarSolicitudesTurno(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Gestión de Solicitudes de Turno");
            System.out.println("1. Crear Solicitud de Turno");
            System.out.println("2. Editar Solicitud de Turno");
            System.out.println("3. Eliminar Solicitud de Turno");
            System.out.println("4. Consultar Solicitudes de Turno");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para crear solicitud de turno
                    System.out.println("Creando Solicitud de Turno...");
                    break;
                case 2:
                    // Lógica para editar solicitud de turno
                    System.out.println("Editando Solicitud de Turno...");
                    break;
                case 3:
                    // Lógica para eliminar solicitud de turno
                    System.out.println("Eliminando Solicitud de Turno...");
                    break;
                case 4:
                    // Lógica para consultar solicitudes de turno
                    System.out.println("Consultando Solicitudes de Turno...");
                    break;
                case 5:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    public static void gestionarPagos(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Gestión de Pagos");
            System.out.println("1. Registrar Pago");
            System.out.println("2. Actualizar Pago");
            System.out.println("3. Consultar Pagos");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> // Lógica para registrar pago
                    System.out.println("Registrando Pago...");
                case 2 -> // Lógica para actualizar pago
                    System.out.println("Actualizando Pago...");
                case 3 -> // Lógica para consultar pagos
                    System.out.println("Consultando Pagos...");
                case 4 -> System.out.println("Volviendo al Menú Principal...");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }
}