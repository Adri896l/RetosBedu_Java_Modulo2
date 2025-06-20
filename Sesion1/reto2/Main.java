package Sesion1.reto2;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("Materiales del curso:");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
        System.out.println();
    }

    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video video : lista) {
            total += video.getDuracion();
        }
        System.out.println("Duración total de videos: " + total + " minutos\n");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                ((Ejercicio) obj).marcarRevisado();
            }
        }
        System.out.println();
    }

    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, String autor) {
        System.out.println("Filtrando materiales por autor:");
        for (MaterialCurso material : lista) {
            if (material.getAutor().equalsIgnoreCase(autor)) {
                material.mostrarDetalle();
            }
        }
    }

    public static void main(String[] args) {
        List<MaterialCurso> materiales = new ArrayList<>();
        materiales.add(new Video("Introducción a Java", "Mario", 15));
        materiales.add(new Video("POO en Java", "Carlos", 20));
        materiales.add(new Articulo("Historia de Java", "Ana", 1200));
        materiales.add(new Articulo("Tipos de datos", "Luis", 800));
        materiales.add(new Ejercicio("Variables y tipos", "Luis"));
        materiales.add(new Ejercicio("Condicionales", "Mario"));

        mostrarMateriales(materiales);

        List<Video> videos = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            }
        }
        contarDuracionVideos(videos);

        marcarEjerciciosRevisados(materiales);

        filtrarPorAutor(materiales, "Mario");
    }
}
