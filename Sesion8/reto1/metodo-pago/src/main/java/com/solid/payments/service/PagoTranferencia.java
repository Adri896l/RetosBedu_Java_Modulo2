package com.solid.payments.service;

import com.solid.payments.model.MetodoPago;

public class PagoTranferencia implements MetodoPago{

     @Override
    public void pay(double amount) {
        System.out.println("Procesando pago con transferencia bancaria por $" + amount);
    }
}
