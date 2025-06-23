package com.solid.payments.service;

import com.solid.payments.model.MetodoPago;

public class PagoCrypto implements MetodoPago{
    @Override
    public void pay(double amount) {
        System.out.println("Procesando pago con criptomonedas por $" + amount);
    }
    
}
