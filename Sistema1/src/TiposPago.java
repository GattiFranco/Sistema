public class TiposPago {
    private int id;
    private String descripcion;
    private double importe;
    private int pagosid;

    // Constructor
    public TiposPago(int id, String descripcion, double importe, int pagosid) {
        this.id = id;
        this.descripcion = descripcion;
        this.importe = importe;
        this.pagosid = pagosid;
    }


}