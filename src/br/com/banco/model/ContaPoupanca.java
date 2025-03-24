package br.com.banco.model;

import br.com.banco.enums.TipoConta;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, String agencia, String nomeCliente) {
        super(numero, agencia, nomeCliente, TipoConta.POUPANCA);
    }
}
