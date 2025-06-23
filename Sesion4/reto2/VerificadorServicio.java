package Sesion4.reto2;

import java.util.concurrent.*;

public class VerificadorServicio {

    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Verificando pista...");
            Utils.dormir(2 + Utils.aleatorio(0, 1));
            boolean disponible = Utils.probabilidad(80);
            System.out.println("Pista disponible: " + disponible);
            return disponible;
        });
    }

    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Verificando clima...");
            Utils.dormir(2 + Utils.aleatorio(0, 1));
            boolean favorable = Utils.probabilidad(85);
            System.out.println("Clima favorable: " + favorable);
            return favorable;
        });
    }

    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Verificando tráfico aéreo...");
            Utils.dormir(2 + Utils.aleatorio(0, 1));
            boolean despejado = Utils.probabilidad(90);
            System.out.println("Tráfico aéreo despejado: " + despejado);
            return despejado;
        });
    }

    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Verificando personal en tierra...");
            Utils.dormir(2 + Utils.aleatorio(0, 1));
            boolean disponible = Utils.probabilidad(95);
            System.out.println("Personal disponible: " + disponible);
            return disponible;
        });
    }
}
