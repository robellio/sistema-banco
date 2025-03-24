package br.com.banco.model;

import br.com.banco.enums.TipoConta;

public abstract class Conta {

    public static final double  LIMITE_SAQUE_DIARIO = 1200.00;
    protected int numero;
    protected String agencia;
    protected String nomeCliente;
    public double saldo;
    public double saqueDiario;
    protected TipoConta tipo;

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
