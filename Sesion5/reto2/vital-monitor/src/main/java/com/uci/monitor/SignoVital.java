package com.uci.monitor;

public class SignoVital {
    private int pacienteId;
    private int frecuenciaCardiaca;
    private int presionSistolica;
    private int presionDiastolica;
    private int spo2;

    public SignoVital(int pacienteId, int fc, int sistolica, int diastolica, int spo2) {
        this.pacienteId = pacienteId;
        this.frecuenciaCardiaca = fc;
        this.presionSistolica = sistolica;
        this.presionDiastolica = diastolica;
        this.spo2 = spo2;
    }

    public int getPacienteId() { return pacienteId; }
    public int getFrecuenciaCardiaca() { return frecuenciaCardiaca; }
    public int getPresionSistolica() { return presionSistolica; }
    public int getPresionDiastolica() { return presionDiastolica; }
    public int getSpo2() { return spo2; }

    @Override
    public String toString() {
        return String.format("Paciente %d - FC: %d bpm, PA: %d/%d mmHg, SpO2: %d%%",
                pacienteId, frecuenciaCardiaca, presionSistolica, presionDiastolica, spo2);
    }
}
