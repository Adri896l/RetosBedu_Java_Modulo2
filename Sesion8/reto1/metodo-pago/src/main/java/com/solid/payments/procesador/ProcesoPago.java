package com.solid.payments.procesador;

import com.solid.payments.model.MetodoPago;

public class ProcesoPago {
    private final MetodoPago MetodoPago;

    public ProcesoPago(MetodoPago MetodoPago) {
        this.MetodoPago = MetodoPago;
    }

    public void process(double amount) {
        MetodoPago.pay(amount);
    }
    
}
