package Sesion4.reto1;

import java.util.concurrent.*;
import java.util.Random;

public class MovilidadApp {

    private static final Random random = new Random();

    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Buscando la mejor ruta...");
                TimeUnit.SECONDS.sleep(2 + random.nextInt(2)); 
                return "Ruta: Parque Central -> Estación Sur";
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al calcular ruta", e);
            }
        });
    }

    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Calculando tarifa estimada...");
                TimeUnit.SECONDS.sleep(1 + random.nextInt(2)); 
                if (random.nextInt(10) < 1) {
                    throw new RuntimeException("Demanda muy alta, no se pudo calcular la tarifa.");
                }
                return 92.75;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al estimar tarifa", e);
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("Solicitud de viaje recibida...\n");

        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        rutaFuture
            .thenCombine(tarifaFuture, (ruta, tarifa) -> {
                return ruta + " | Tarifa estimada: $" + tarifa;
            })
            .exceptionally(ex -> "Error en el proceso del viaje: " + ex.getMessage())
            .thenAccept(System.out::println);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.err.println("Interrumpido.");
        }
    }
}
