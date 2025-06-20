package Sesion4.reto2;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        AeropuertoControl control = new AeropuertoControl();
        try {
            control.procesarAterrizaje().get(); 
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error general en el sistema: " + e.getMessage());
        }
    }
}
