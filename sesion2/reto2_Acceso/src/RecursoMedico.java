import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private String nombre;
    private ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional) {
        System.out.println("🔄 " + profesional + " intenta acceder a " + nombre + "...");

        lock.lock();
        try {
            System.out.println("👩‍⚕️ " + profesional + " ha ingresado a " + nombre);
            Thread.sleep(1000); // Simula el tiempo de uso del recurso
            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            System.out.println("⚠️ " + profesional + " fue interrumpido.");
        } finally {
            lock.unlock();
        }
    }
}
