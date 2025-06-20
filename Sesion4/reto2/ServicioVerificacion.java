package Sesion4.reto2;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ServicioVerificacion {
    private static final Random random = new Random();

    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2, 3);
            boolean resultado = random.nextInt(100) < 80; 
            System.out.println("Pista disponible: " + resultado);
            return resultado;
        });
    }

    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2, 3);
            boolean resultado = random.nextInt(100) < 85; 
            System.out.println("Clima favorable: " + resultado);
            return resultado;
        });
    }

    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2, 3);
            boolean resultado = random.nextInt(100) < 90; 
            System.out.println(" Tráfico aéreo despejado: " + resultado);
            return resultado;
        });
    }

    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2, 3);
            boolean resultado = random.nextInt(100) < 95; 
            System.out.println("Personal disponible: " + resultado);
            return resultado;
        });
    }

    private static void esperar(int min, int max) {
        try {
            int segundos = min + random.nextInt(max - min + 1);
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error en la simulación de latencia");
        }
    }
}

