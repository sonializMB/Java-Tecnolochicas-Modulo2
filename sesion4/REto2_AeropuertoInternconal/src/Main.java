import java.util.concurrent.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static final ExecutorService executor = Executors.newFixedThreadPool(4);

    // Verifica si la pista está disponible (80% de probabilidad de éxito)
    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                boolean disponible = ThreadLocalRandom.current().nextInt(100) < 80;
                System.out.println("🛣️ Pista disponible: " + disponible);
                return disponible;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al verificar pista");
            }
        }, executor);
    }

    // Verifica si el clima es favorable (85% de probabilidad)
    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2500);
                boolean favorable = ThreadLocalRandom.current().nextInt(100) < 85;
                System.out.println("🌦️ Clima favorable: " + favorable);
                return favorable;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al verificar clima");
            }
        }, executor);
    }

    // Verifica el tráfico aéreo (90% de probabilidad)
    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2200);
                boolean despejado = ThreadLocalRandom.current().nextInt(100) < 90;
                System.out.println("🚦 Tráfico aéreo despejado: " + despejado);
                return despejado;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al verificar tráfico aéreo");
            }
        }, executor);
    }

    // Verifica disponibilidad de personal en tierra (95% de probabilidad)
    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                boolean disponible = ThreadLocalRandom.current().nextInt(100) < 95;
                System.out.println("👷‍♂️ Personal disponible: " + disponible);
                return disponible;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al verificar personal de tierra");
            }
        }, executor);
    }

    public static void main(String[] args) {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        // Lanzar todas las tareas en paralelo
        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        // Combinar todos los resultados cuando todas las tareas finalicen
        CompletableFuture<Void> allChecks = CompletableFuture.allOf(pista, clima, trafico, personal);

        // Evaluar si todas son verdaderas
        CompletableFuture<Boolean> aterrizajePermitido = allChecks.thenApply(v -> {
            try {
                return pista.get() && clima.get() && trafico.get() && personal.get();
            } catch (Exception e) {
                throw new RuntimeException("Error al combinar resultados");
            }
        });

        // Mostrar resultado final con manejo de errores
        aterrizajePermitido
                .thenAccept(permitido -> {
                    if (permitido) {
                        System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                    } else {
                        System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
                    }
                })
                .exceptionally(ex -> {
                    System.out.println("\n❌ Error en el sistema de control: " + ex.getMessage());
                    return null;
                })
                .join(); 

        executor.shutdown();
    }
}
