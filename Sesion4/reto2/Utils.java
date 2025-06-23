package Sesion4.reto2;

import java.util.concurrent.TimeUnit;

public class Utils {

    public static void dormir(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static int aleatorio(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static boolean probabilidad(int porcentaje) {
        return Math.random() * 100 < porcentaje;
    }
}

