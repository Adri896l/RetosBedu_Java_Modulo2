package com.uci.monitor;

import com.uci.monitor.SignoVital;
import com.uci.monitor.GeneradorSignosService;
import com.uci.monitor.SignoVitalUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;


    @Component
public class MonitoreoRunner {

    @PostConstruct
    public void iniciarMonitoreo() {
        Flux<SignoVital> paciente1 = GeneradorSignosService.generarFlujoPaciente(1);
        Flux<SignoVital> paciente2 = GeneradorSignosService.generarFlujoPaciente(2);
        Flux<SignoVital> paciente3 = GeneradorSignosService.generarFlujoPaciente(3);

        Flux.merge(paciente1, paciente2, paciente3)
            .delayElements(Duration.ofSeconds(1)) 
            .doOnNext(sv -> System.out.println("Datos: " + sv)) 
            .filter(SignoVitalUtils::esCritico) 
            .map(SignoVitalUtils::mensajeCritico)
            .subscribe(msg -> System.out.println("Alerta: " + msg));
    }
}

