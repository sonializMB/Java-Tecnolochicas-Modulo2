import java.util.concurrent.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    // (2-3 segundos)
    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("🚦 Calculando ruta...");
                // Simular entre 2s y 3s
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 3001));
                return "Centro -> Norte";
            } catch (InterruptedException e) {
                throw new IllegalStateException("Error al calcular ruta", e);
            }
        });
    }

    // (1-2 segundos)
    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("💰 Estimando tarifa...");
                // Simular entre 1s y 2s
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2001));
                return 75.50;
            } catch (InterruptedException e) {
                throw new IllegalStateException("Error al estimar tarifa", e);
            }
        });
    }

    public static void main(String[] args) {
        // Lanzar ambas tareas de forma asincrónica y paralela
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        // Combinarlas cuando ambas estén listas
        CompletableFuture<String> resultadoFinal = rutaFuture
                .thenCombine(tarifaFuture, (ruta, tarifa) ->
                        "✅ 🚗 Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa
                )
                .exceptionally(ex -> "❌ Error al procesar solicitud: " + ex.getMessage());
        System.out.println(resultadoFinal.join());
    }
}
