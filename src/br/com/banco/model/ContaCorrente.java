package br.com.banco.model;

import br.com.banco.enums.TipoConta;

    public class ContaCorrente extends Conta {
        public ContaCorrente(int numero, String agencia, String nomeCliente) {
            super(numero, agencia, nomeCliente, TipoConta.CORRENTE);
        }
    }

