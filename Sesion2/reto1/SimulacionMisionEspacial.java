package Sesion2.reto1;

import java.util.concurrent.*;

class SistemaNavegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1500); 
        return "Navegación: trayectoria corregida con éxito.";
    }
}

class SistemaSoporteVital implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1200);
        return "Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}

class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Control térmico: temperatura estable (22°C).";
    }
}

class SistemaComunicaciones implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(800);
        return "Comunicaciones: enlace con estación terrestre establecido.";
    }
}

public class SimulacionMisionEspacial {
    public static void main(String[] args) {
        System.out.println("Simulación de misión espacial iniciada...");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<String> futuroNav = executor.submit(new SistemaNavegacion());
        Future<String> futuroSoporte = executor.submit(new SistemaSoporteVital());
        Future<String> futuroTermico = executor.submit(new SistemaControlTermico());
        Future<String> futuroCom = executor.submit(new SistemaComunicaciones());

        try {
            System.out.println(futuroCom.get());
            System.out.println(futuroSoporte.get());
            System.out.println(futuroTermico.get());
            System.out.println(futuroNav.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error durante la ejecución: " + e.getMessage());
        } finally {
            executor.shutdown(); 
        }

        System.out.println("Todos los sistemas reportan estado operativo.");
    }
}

