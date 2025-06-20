package Sesion3.reto1;

import java.util.*;
import java.util.stream.Collectors;

class Pedido {
    private String cliente;
    private String tipoEntrega; 
    private String telefono;    

    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }
}

public class ConfirmacionPedidos {
    public static void main(String[] args) {
        System.out.println("Procesando pedidos para confirmación...\n");

        List<Pedido> pedidos = Arrays.asList(
            new Pedido("Carlos", "domicilio", "555-1234"),
            new Pedido("Ana", "local", "555-0000"),
            new Pedido("Luis", "domicilio", null),
            new Pedido("Sofía", "domicilio", "555-5678"),
            new Pedido("Elena", "local", null)
        );

        pedidos.stream()
            .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio")) // Solo domicilio
            .map(Pedido::getTelefono)                                     // Optional<String>
            .filter(Optional::isPresent)                                  // Solo si hay teléfono
            .map(Optional::get)                                           // Extraer el teléfono
            .map(tel -> "Confirmación enviada al número: " + tel)      // Generar mensaje
            .forEach(System.out::println);                                // Mostrar en consola
    }
}
