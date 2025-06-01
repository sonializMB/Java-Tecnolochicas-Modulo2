import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...\n");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(() -> salaCirugia.usar("Dra. Sánchez"));
        executor.submit(() -> salaCirugia.usar("Dr. Gómez"));
        executor.submit(() -> salaCirugia.usar("Enfermero Juan"));
        executor.submit(() -> salaCirugia.usar("Enfermera Sonia"));
        executor.submit(() -> salaCirugia.usar("Dra. Rivera"));
        executor.submit(() -> salaCirugia.usar("Dra. Ortega"));

        executor.shutdown();
    }
}
