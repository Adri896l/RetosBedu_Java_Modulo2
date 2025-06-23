package com.uci.monitor;

import com.uci.monitor.SignoVital;
import com.uci.monitor.SignoVitalUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class GeneradorSignosService {

    public static Flux<SignoVital> generarFlujoPaciente(int pacienteId) {
        return Flux.interval(Duration.ofMillis(300))
                .onBackpressureDrop()
                .map(tick -> SignoVitalUtils.generarSignos(pacienteId))
                .delayElements(Duration.ofMillis(400)) 
                .doOnError(e -> System.err.println("Error flujo paciente " + pacienteId + ": " + e.getMessage()));
    }
}
