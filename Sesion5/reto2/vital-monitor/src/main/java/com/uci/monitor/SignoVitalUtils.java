package com.uci.monitor;

import com.uci.monitor.SignoVital;
import java.util.concurrent.ThreadLocalRandom;

public class SignoVitalUtils {

    public static SignoVital generarSignos(int pacienteId) {
        return new SignoVital( pacienteId,
                ThreadLocalRandom.current().nextInt(30, 151),     
                ThreadLocalRandom.current().nextInt(80, 161),     
                ThreadLocalRandom.current().nextInt(50, 101),     
                ThreadLocalRandom.current().nextInt(70, 101)      
        );
    }

    public static boolean esCritico(SignoVital sv) {
        return sv.getFrecuenciaCardiaca() < 50 || sv.getFrecuenciaCardiaca() > 120
                || sv.getPresionSistolica() < 90 || sv.getPresionSistolica() > 140
                || sv.getPresionDiastolica() < 60 || sv.getPresionDiastolica() > 90
                || sv.getSpo2() < 90;
    }

    public static String mensajeCritico(SignoVital sv) {
        if (sv.getFrecuenciaCardiaca() < 50 || sv.getFrecuenciaCardiaca() > 120)
            return String.format("Paciente %d - FC crítica: %d bpm", sv.getPacienteId(), sv.getFrecuenciaCardiaca());
        if (sv.getPresionSistolica() < 90 || sv.getPresionSistolica() > 140 ||
            sv.getPresionDiastolica() < 60 || sv.getPresionDiastolica() > 90)
            return String.format("Paciente %d - PA crítica: %d/%d mmHg", sv.getPacienteId(),
                    sv.getPresionSistolica(), sv.getPresionDiastolica());
        if (sv.getSpo2() < 90)
            return String.format("Paciente %d - SpO2 baja: %d%%", sv.getPacienteId(), sv.getSpo2());
        return null;
    }
}
