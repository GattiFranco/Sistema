package Main;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Conexion conexion = Conexion.getInstancia();
        Connection conn = conexion.getConexion();

        if (conn != null) {
            try (Scanner scanner = new Scanner(System.in)) {
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
                            gestionarUsuarios(scanner, conn);
                            break;
                        case 2:
                            gestionarSolicitudesTurno(scanner, conn);
                            break;
                        case 3:
                            gestionarPagos(scanner, conn);
                            break;
                        case 4:
                            System.out.println("Saliendo del sistema...");
                            break;
                        default:
                            System.out.println("Opción inválida. Intente nuevamente.");
                    }
                } while (opcion != 4);
            }
            conexion.desconectar();
        } else {
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }
    }

    public static void gestionarUsuarios(Scanner scanner, Connection conn) {
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
                    crearUsuario(scanner, conn);
                    break;
                case 2:
                    editarUsuario(scanner, conn);
                    break;
                case 3:
                    eliminarUsuario(scanner, conn);
                    break;
                case 4:
                    consultarUsuarios(conn);
                    break;
                case 5:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    public static void crearUsuario(Scanner scanner, Connection conn) {
        try {
            System.out.print("Ingrese nombre de usuario: ");
            String nombreUsuario = scanner.next();
            System.out.print("Ingrese contraseña: ");
            String contraseña = scanner.next();

            String sql = "INSERT INTO Usuario (nombreusuario, contraseña) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombreUsuario);
            statement.setString(2, contraseña);
            statement.executeUpdate();
            System.out.println("Usuario creado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
        }
    }

    public static void editarUsuario(Scanner scanner, Connection conn) {
        try {
            System.out.print("Ingrese ID del usuario a editar: ");
            int id = scanner.nextInt();
            System.out.print("Ingrese nuevo nombre de usuario: ");
            String nombreUsuario = scanner.next();
            System.out.print("Ingrese nueva contraseña: ");
            String contraseña = scanner.next();

            String sql = "UPDATE Usuario SET nombreusuario = ?, contraseña = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombreUsuario);
            statement.setString(2, contraseña);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Usuario actualizado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    public static void eliminarUsuario(Scanner scanner, Connection conn) {
        try {
            System.out.print("Ingrese ID del usuario a eliminar: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM Usuario WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Usuario eliminado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    public static void consultarUsuarios(Connection conn) {
        try {
            String sql = "SELECT * FROM Usuario";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombreUsuario = resultSet.getString("nombreusuario");
                String contraseña = resultSet.getString("contraseña");
                System.out.println("ID: " + id + ", Nombre de Usuario: " + nombreUsuario + ", Contraseña: " + contraseña);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar usuarios: " + e.getMessage());
        }
    }

    public static void gestionarSolicitudesTurno(Scanner scanner, Connection conn) {
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
                    crearSolicitudTurno(scanner, conn);
                    break;
                case 2:
                    editarSolicitudTurno(scanner, conn);
                    break;
                case 3:
                    eliminarSolicitudTurno(scanner, conn);
                    break;
                case 4:
                    consultarSolicitudesTurno(conn);
                    break;
                case 5:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    public static void crearSolicitudTurno(Scanner scanner, Connection conn) {
        try {
            System.out.print("Ingrese número de turno: ");
            int numeroTurno = scanner.nextInt();
            System.out.print("Ingrese nombre: ");
            String nombre = scanner.next();
            System.out.print("Ingrese apellido: ");
            String apellido = scanner.next();
            System.out.print("Ingrese email: ");
            String email = scanner.next();
            System.out.print("Ingrese teléfono: ");
            String telefono = scanner.next();
            System.out.print("Ingrese fecha (YYYY-MM-DD): ");
            String fecha = scanner.next();
            System.out.print("Ingrese hora (HH:MM:SS): ");
            String hora = scanner.next();
            System.out.print("Ingrese estado: ");
            String estado = scanner.next();
            System.out.print("Ingrese ID de usuario: ");
            int usuarioId = scanner.nextInt();

            String sql = "INSERT INTO SolicitudTurno (numeroturno, nombre, apellido, email, telefono, fecha, hora, estado, usuarioid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, numeroTurno);
            statement.setString(2, nombre);
            statement.setString(3, apellido);
            statement.setString(4, email);
            statement.setString(5, telefono);
            statement.setString(6, fecha);
            statement.setString(7, hora);
            statement.setString(8, estado);
            statement.setInt(9, usuarioId);
            statement.executeUpdate();
            System.out.println("Solicitud de turno creada exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al crear solicitud de turno: " + e.getMessage());
        }
    }

    public static void editarSolicitudTurno(Scanner scanner, Connection conn) {
        try {
            System.out.print("Ingrese ID de la solicitud de turno a editar: ");
            int id = scanner.nextInt();
            System.out.print("Ingrese nuevo número de turno: ");
            int numeroTurno = scanner.nextInt();
            System.out.print("Ingrese nuevo nombre: ");
            String nombre = scanner.next();
            System.out.print("Ingrese nuevo apellido: ");
            String apellido = scanner.next();
            System.out.print("Ingrese nuevo email: ");
            String email = scanner.next();
            System.out.print("Ingrese nuevo teléfono: ");
            String telefono = scanner.next();
            System.out.print("Ingrese nueva fecha (YYYY-MM-DD): ");
            String fecha = scanner.next();
            System.out.print("Ingrese nueva hora (HH:MM:SS): ");
            String hora = scanner.next();
            System.out.print("Ingrese nuevo estado: ");
            String estado = scanner.next();
            System.out.print("Ingrese nuevo ID de usuario: ");
            int usuarioId = scanner.nextInt();

            String sql = "UPDATE SolicitudTurno SET numeroturno = ?, nombre = ?, apellido = ?, email = ?, telefono = ?, fecha = ?, hora = ?, estado = ?, usuarioid = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, numeroTurno);
            statement.setString(2, nombre);
            statement.setString(3, apellido);
            statement.setString(4, email);
            statement.setString(5, telefono);
            statement.setString(6, fecha);
            statement.setString(7, hora);
            statement.setString(8, estado);
            statement.setInt(9, usuarioId);
            statement.setInt(10, id);
            statement.executeUpdate();
            System.out.println("Solicitud de turno actualizada exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar solicitud de turno: " + e.getMessage());
        }
    }

    public static void eliminarSolicitudTurno(Scanner scanner, Connection conn) {
        try {
            System.out.print("Ingrese ID de la solicitud de turno a eliminar: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM SolicitudTurno WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Solicitud de turno eliminada exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar solicitud de turno: " + e.getMessage());
        }
    }

    public static void consultarSolicitudesTurno(Connection conn) {
        try {
            String sql = "SELECT * FROM SolicitudTurno";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int numeroTurno = resultSet.getInt("numeroturno");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("email");
                String telefono = resultSet.getString("telefono");
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");
                String estado = resultSet.getString("estado");
                int usuarioId = resultSet.getInt("usuarioid");
                System.out.println("ID: " + id + ", Número de Turno: " + numeroTurno + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Email: " + email + ", Teléfono: " + telefono + ", Fecha: " + fecha + ", Hora: " + hora + ", Estado: " + estado + ", ID Usuario: " + usuarioId);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar solicitudes de turno: " + e.getMessage());
        }
    }

    public static void gestionarPagos(Scanner scanner, Connection conn) {
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
                case 1:
                    registrarPago(scanner, conn);
                    break;
                case 2:
                    actualizarPago(scanner, conn);
                    break;
                case 3:
                    consultarPagos(conn);
                    break;
                case 4:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    public static void registrarPago(Scanner scanner, Connection conn) {
        try {
            System.out.print("Ingrese monto: ");
            double monto = scanner.nextDouble();
            System.out.print("Ingrese fecha (YYYY-MM-DD): ");
            String fecha = scanner.next();
            System.out.print("Ingrese ID de usuario: ");
            int usuarioId = scanner.nextInt();

            String sql = "INSERT INTO Pago (monto, fecha, usuarioid) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(1, monto);
            statement.setString(2, fecha);
            statement.setInt(3, usuarioId);
            statement.executeUpdate();
            System.out.println("Pago registrado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al registrar pago: " + e.getMessage());
        }
    }

    public static void actualizarPago(Scanner scanner, Connection conn) {
        try {
            System.out.print("Ingrese ID del pago a actualizar: ");
            int id = scanner.nextInt();
            System.out.print("Ingrese nuevo monto: ");
            double monto = scanner.nextDouble();
            System.out.print("Ingrese nueva fecha (YYYY-MM-DD): ");
            String fecha = scanner.next();
            System.out.print("Ingrese nuevo ID de usuario: ");
            int usuarioId = scanner.nextInt();

            String sql = "UPDATE Pago SET monto = ?, fecha = ?, usuarioid = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(1, monto);
            statement.setString(2, fecha);
            statement.setInt(3, usuarioId);
            statement.setInt(4, id);
            statement.executeUpdate();
            System.out.println("Pago actualizado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar pago: " + e.getMessage());
        }
    }

    public static void consultarPagos(Connection conn) {
        try {
            String sql = "SELECT * FROM Pago";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double monto = resultSet.getDouble("monto");
                String fecha = resultSet.getString("fecha");
                int usuarioId = resultSet.getInt("usuarioid");
                System.out.println("ID: " + id + ", Monto: " + monto + ", Fecha: " + fecha + ", ID Usuario: " + usuarioId);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar pagos: " + e.getMessage());
        }
    }
}
