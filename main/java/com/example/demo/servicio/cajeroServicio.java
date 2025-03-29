package com.ejemplo.cajero.servicio;

import org.omg.IOP.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class CajeroServicio {

    public final TransactionService transactionService;
    private double saldo = 100000.00;  // Saldo inicial

    public double verificarSaldo() {
        return saldo;
    }

    public String retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return "Retiro exitoso. Saldo restante: " + saldo;
        } else {
            return "Saldo insuficiente.";
        }
    }

    public String depositar(double monto) {
        saldo += monto;
        return "Depósito exitoso. Nuevo saldo: " + saldo;
    }
}
