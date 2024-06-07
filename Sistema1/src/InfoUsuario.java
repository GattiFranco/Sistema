public class InfoUsuario {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String estado;
    private String fechaEstado;
    private int usuarioid;

    // Constructor
    public InfoUsuario(int id, String nombre, String apellido, String email, String telefono, String estado, String fechaEstado, int usuarioid) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.fechaEstado = fechaEstado;
        this.usuarioid = usuarioid;
    }


}