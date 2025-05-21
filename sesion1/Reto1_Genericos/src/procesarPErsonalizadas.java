public static void procesarPErsonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
    System.out.println("💰 Procesando órdenes personalizadas...");
    for (Object obj : lista) {
        if (obj instanceof OrdenPersonalizada) {
            OrdenPersonalizada op = (OrdenPersonalizada) obj;
            System.out.println("✅ Orden " + op.getCodigo() + " ajustada con costo adicional de $" + costoAdicional);
        }
    }
    System.out.println();
}
