package Sesion2.reto2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional) {
        System.out.println(profesional + " intentando acceder a " + nombre + "...");
        lock.lock(); 
        try {
            System.out.println(profesional + " ha ingresado a " + nombre);
            Thread.sleep(1000); 
            System.out.println(profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            System.out.println(profesional + " fue interrumpido.");
        } finally {
            lock.unlock(); 
        }
    }
}

public class SimulacionHospital {
    public static void main(String[] args) {
        System.out.println("Iniciando acceso a la Sala de cirugía...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        // Crear tareas médicas
        Runnable medico1 = () -> salaCirugia.usar("Dra. Sánchez");
        Runnable medico2 = () -> salaCirugia.usar("Dr. Gómez");
        Runnable medico3 = () -> salaCirugia.usar("Enf. Martínez");
        Runnable medico4 = () -> salaCirugia.usar("Dra. Rivera");
        Runnable medico5 = () -> salaCirugia.usar("Dr. Torres");

        // Ejecutar en un pool de hilos
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(medico1);
        executor.execute(medico2);
        executor.execute(medico3);
        executor.execute(medico4);
        executor.execute(medico5);

        executor.shutdown();
    }
}
