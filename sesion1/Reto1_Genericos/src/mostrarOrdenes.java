
public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
    System.out.println("📋 Órdenes registradas:");
    for (OrdenProduccion orden : lista) {
        orden.mostrarResumen();
    }
    System.out.println();
}
