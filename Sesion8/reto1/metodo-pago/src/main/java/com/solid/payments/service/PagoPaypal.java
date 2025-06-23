package com.solid.payments.service;

import com.solid.payments.model.MetodoPago;

public class PagoPaypal implements MetodoPago {
     @Override
    public void pay(double amount) {
        System.out.println("Procesando pago con PayPal por $" + amount);
    }
}
