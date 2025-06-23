package Sesion4.reto1;

import java.util.concurrent.*;
public class MovilidadApp {

    public static void main(String[] args) {
        System.out.println("Iniciando simulación de viaje...\n");

        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        rutaFuture
            .thenCombine(tarifaFuture, (ruta, tarifa) -> {
                return "Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa;
            })
            .exceptionally(ex -> {
                return "Error al procesar la solicitud: " + ex.getMessage();
            })
            .thenAccept(System.out::println);
        dormir(5);
        System.out.println("\nFin del procesamiento asincrónico.");
    }

    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculando ruta...");
            dormir(2 + (int)(Math.random() * 2)); 
            return "Centro -> Norte";
        });
    }

    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Estimando tarifa...");
            dormir(1 + (int)(Math.random() * 2)); 
            return 75.50;
        });
    }

    private static void dormir(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
