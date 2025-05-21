import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Lista de órdenes en masa
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));

        // Lista de órdenes personalizadas
        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteSonia"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteLiz"));

        // Lista de prototipos
        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));

        // Mostrar todas las órdenes
        mostrarOrdenes(ordenesMasa);
        mostrarOrdenes(ordenesPersonalizadas);
        mostrarOrdenes(ordenesPrototipo);

        // Procesar las ordenes personalizadas
        procesarPErsonalizadas(new ArrayList<OrdenProduccion>(ordenesPersonalizadas), 200);

        // Resumen
        System.out.println("📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + ordenesMasa.size());
        System.out.println("🛠️ Personalizadas: " + ordenesPersonalizadas.size());
        System.out.println("🧪 Prototipos: " + ordenesPrototipo.size());
    }
}
