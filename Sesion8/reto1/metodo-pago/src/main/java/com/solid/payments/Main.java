package com.solid.payments;

import com.solid.payments.model.MetodoPago;
import com.solid.payments.procesador.ProcesoPago;
import com.solid.payments.service.*;

public class Main {
    public static void main(String[] args) {
        ProcesoPago(new PagoTarjeta(), 1500.00);
        ProcesoPago(new PagoPaypal(), 8500.00);
        ProcesoPago(new PagoCrypto(), 10557.00);
        ProcesoPago(new PagoTranferencia(), 150897.27);
    }

    private static void ProcesoPago(MetodoPago method, double amount) {
        ProcesoPago processor = new ProcesoPago(method);
        processor.process(amount);
    }
}
