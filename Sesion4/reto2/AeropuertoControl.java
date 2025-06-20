package Sesion4.reto2;

import java.util.concurrent.CompletableFuture;

public class AeropuertoControl {

    public CompletableFuture<Void> procesarAterrizaje() {
        System.out.println("Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pista = ServicioVerificacion.verificarPista();
        CompletableFuture<Boolean> clima = ServicioVerificacion.verificarClima();
        CompletableFuture<Boolean> trafico = ServicioVerificacion.verificarTraficoAereo();
        CompletableFuture<Boolean> personal = ServicioVerificacion.verificarPersonalTierra();

        return CompletableFuture.allOf(pista, clima, trafico, personal)
                .thenApply(v -> pista.join() && clima.join() && trafico.join() && personal.join())
                .thenAccept(condicionesOptimas -> {
                    if (condicionesOptimas) {
                        System.out.println("\nAterrizaje autorizado: todas las condiciones óptimas.");
                    } else {
                        System.out.println("\nAterrizaje denegado: condiciones no óptimas.");
                    }
                })
                .exceptionally(ex -> {
                    System.out.println("\nError durante el proceso de verificación: " + ex.getMessage());
                    return null;
                });
    }
}

