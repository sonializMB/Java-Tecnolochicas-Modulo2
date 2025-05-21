public class OrdenPersonalizada extends OrdenProduccion {
    private String cliente;

    public OrdenPersonalizada(String codigo, int cantidad){
        super(codigo,cantidad);
    }
    @Override // metodo de la clase  ORDENPRODUCCION para mostar informacion
    public void mostrarResumen() {
        System.out.println("🛠️ OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad+" - Cliente: " +cliente);
    }
    public void aplicarCostoAdicional(int costo) {
        System.out.println("✅ Orden " + codigo + " ajustada con costo adicional de $" + costo);
    }
}
