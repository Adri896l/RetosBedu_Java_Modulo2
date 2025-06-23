package Sesion4.reto2;

import java.util.concurrent.*;

public class AeropuertoControl {

    public static void main(String[] args) {
        System.out.println("Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pista = VerificadorServicio.verificarPista();
        CompletableFuture<Boolean> clima = VerificadorServicio.verificarClima();
        CompletableFuture<Boolean> trafico = VerificadorServicio.verificarTraficoAereo();
        CompletableFuture<Boolean> personal = VerificadorServicio.verificarPersonalTierra();

        CompletableFuture.allOf(pista, clima, trafico, personal)
            .thenRun(() -> {
                try {
                    boolean condicionesOk = pista.get() && clima.get() && trafico.get() && personal.get();

                    if (condicionesOk) {
                        System.out.println("\nAterrizaje autorizado: todas las condiciones óptimas.");
                    } else {
                        System.out.println("\nAterrizaje denegado: condiciones no óptimas.");
                    }

                } catch (Exception e) {
                    System.out.println("\nError al procesar las verificaciones: " + e.getMessage());
                }
            })
            .exceptionally(ex -> {
                System.out.println("\nError general: " + ex.getMessage());
                return null;
            })
            .join(); 

        System.out.println("\nProceso finalizado.");
    }
}


