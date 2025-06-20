package Sesion3.reto2;

import java.util.*;
import java.util.stream.*;

class Encuesta {
    private String paciente;
    private String comentario; 
    private int calificacion;

    public Encuesta(String paciente, String comentario, int calificacion) {
        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public Optional<String> getComentario() {
        return Optional.ofNullable(comentario);
    }
}

class Sucursal {
    private String nombre;
    private List<Encuesta> encuestas;

    public Sucursal(String nombre, List<Encuesta> encuestas) {
        this.nombre = nombre;
        this.encuestas = encuestas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Encuesta> getEncuestas() {
        return encuestas;
    }
}

public class ProcesamientoEncuestas {
    public static void main(String[] args) {
        System.out.println("Procesando encuestas de satisfacción...\n");

        Sucursal centro = new Sucursal("Centro", Arrays.asList(
            new Encuesta("Ana", "El tiempo de espera fue largo", 2),
            new Encuesta("Luis", null, 5),
            new Encuesta("Carlos", "Me ignoraron en recepción", 3)
        ));

        Sucursal norte = new Sucursal("Norte", Arrays.asList(
            new Encuesta("Sofía", "La atención fue buena, pero la limpieza puede mejorar", 3),
            new Encuesta("Marcos", null, 2),
            new Encuesta("Lucía", null, 4)
        ));

        List<Sucursal> sucursales = Arrays.asList(centro, norte);

        sucursales.stream()
            .flatMap(sucursal ->
                sucursal.getEncuestas().stream()
                    .filter(encuesta -> encuesta.getCalificacion() <= 3)
                    .map(encuesta ->
                        encuesta.getComentario()
                            .map(comentario ->
                                "Sucursal " + sucursal.getNombre() +
                                ": Seguimiento a paciente con comentario: \"" + comentario + "\""
                            )
                    )
            )
            .filter(Optional::isPresent)
            .map(Optional::get)
            .forEach(System.out::println);
    }
}
