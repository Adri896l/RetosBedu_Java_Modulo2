package com.meridian;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ReactiveSystemsManager implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();

        Flux<String> trafficFlux = Flux.interval(Duration.ofMillis(500))
            .map(tick -> random.nextInt(101))
            .onBackpressureBuffer(10)
            .filter(congestion -> congestion > 70)
            .map(congestion -> "Alerta: Congestión del " + congestion + "% en Avenida Solar");

        Flux<String> pollutionFlux = Flux.interval(Duration.ofMillis(600))
            .map(tick -> 20 + random.nextInt(80))
            .filter(pm -> pm > 50)
            .map(pm -> "Alerta: Contaminación alta (PM2.5: " + pm + " ug/m3)");

        List<String> priorities = Arrays.asList("Baja", "Media", "Alta");
        Flux<String> accidentFlux = Flux.interval(Duration.ofMillis(800))
            .map(tick -> priorities.get(random.nextInt(priorities.size())))
            .filter(priority -> priority.equals("Alta"))
            .map(priority -> "Emergencia vial: Accidente con prioridad " + priority);

        Flux<String> maglevFlux = Flux.interval(Duration.ofMillis(700))
            .map(tick -> random.nextInt(11))
            .filter(delay -> delay > 5)
            .map(delay -> "Tren maglev con retraso crítico: " + delay + " minutos")
            .onBackpressureBuffer(5);

        List<String> semStates = Arrays.asList("Verde", "Amarillo", "Rojo");
        Flux<String> semaphoreFlux = Flux.interval(Duration.ofMillis(400))
            .map(tick -> semStates.get(random.nextInt(semStates.size())))
            .buffer(3, 1)
            .filter(window -> window.size() == 3 && window.stream().allMatch(state -> state.equals("Rojo")))
            .map(window -> "Semáforo en Rojo detectado 3 veces seguidas en cruce Norte");

        Flux<String> combinedFlux = Flux.merge(trafficFlux, pollutionFlux, accidentFlux, maglevFlux, semaphoreFlux)
            .publish()
            .autoConnect();

        combinedFlux
            .bufferTimeout(5, Duration.ofSeconds(1))
            .filter(events -> events.size()>=3)
            .subscribe(events -> {
                System.out.println("\nAlerta global: Múltiples eventos críticos detectados en Meridian Prime");
                events.forEach(System.out::println);
                System.out.println();
            });

        trafficFlux.subscribe( System.out::println);
        pollutionFlux.subscribe(System.out::println);
        accidentFlux.subscribe( System.out::println);
        maglevFlux.subscribe(System.out::println);
        semaphoreFlux.subscribe(System.out::println);

        Thread.sleep(30000);
    }
}
