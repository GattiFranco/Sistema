
public class Pago {

    private int id;
    private int numeroComprobante;
    private String tipoDeuda;
    private String periodo;
    private String vencimiento;
    private double importe;
    private String fechaPago;
    private String estado;

    // Constructor
    public Pago(int id, int numeroComprobante, String tipoDeuda, String periodo, String vencimiento, double importe, String fechaPago, String estado) {
        this.id = id;
        this.numeroComprobante = numeroComprobante;
        this.tipoDeuda = tipoDeuda;
        this.periodo = periodo;
        this.vencimiento = vencimiento;
        this.importe = importe;
        this.fechaPago = fechaPago;
        this.estado = estado;
    }

}
