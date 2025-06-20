package Sesion1.reto1;

import java.util.*;

public class Main {

    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
        System.out.println();
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                ((OrdenPersonalizada) obj).aplicarCostoAdicional(costoAdicional);
            }
        }
        System.out.println();
    }

    public static void contarOrdenes(List<OrdenProduccion> todas) {
        int masa = 0, personalizada = 0, prototipo = 0;
        for (OrdenProduccion orden : todas) {
            if (orden instanceof OrdenMasa) masa++;
            else if (orden instanceof OrdenPersonalizada) personalizada++;
            else if (orden instanceof OrdenPrototipo) prototipo++;
        }
        System.out.println("Resumen total de órdenes:");
        System.out.println("Producción en masa: " + masa);
        System.out.println("Personalizadas: " + personalizada);
        System.out.println("Prototipos: " + prototipo);
    }

    public static void main(String[] args) {
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));

        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));

        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));

        List<OrdenProduccion> todasLasOrdenes = new ArrayList<>();
        todasLasOrdenes.addAll(ordenesMasa);
        todasLasOrdenes.addAll(ordenesPersonalizadas);
        todasLasOrdenes.addAll(ordenesPrototipo);

        System.out.println("Órdenes registradas:");
        mostrarOrdenes(ordenesMasa);

        System.out.println("Órdenes registradas:");
        mostrarOrdenes(ordenesPersonalizadas);

        System.out.println("Órdenes registradas:");
        mostrarOrdenes(ordenesPrototipo);

        procesarPersonalizadas(new ArrayList<>(ordenesPersonalizadas), 200);

        contarOrdenes(todasLasOrdenes);
    }
}
