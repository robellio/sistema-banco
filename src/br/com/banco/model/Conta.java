package br.com.banco.model;

import br.com.banco.enums.TipoConta;

public abstract class Conta {

    protected int numero;
    protected String agencia;
    protected String nomeCliente;
    protected double saldo;
    protected double saqueDiario;
    protected TipoConta tipo;
    protected static final double LIMITE_SAQUE_DIARIO = 1200.00;

    public Conta(int numero, String agencia, String nomeCliente, TipoConta tipo){
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.tipo = tipo;
        this.saldo = 0.0;
        this.saqueDiario = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaqueDiario() {
        return saqueDiario;
    }

    public TipoConta getTipo() {
        return tipo;
    }

}
