package br.com.banco.service;

import br.com.banco.util.Validacao;
import br.com.banco.exception.*;
import br.com.banco.model.Conta;


public class ContaService {

    public void depositar(Conta conta, double valor) {
        Validacao.validarValorPositivo(valor);
        conta.saldo += valor;
    }

    public void sacar(Conta conta, double valor) throws SaldoInsuficienteException, LimiteDiarioExcedidoException {
        Validacao.validarValorPositivo(valor);

        double limiteRestante = Conta.LIMITE_SAQUE_DIARIO - conta.saqueDiario;
        if(valor > limiteRestante) {
            throw new LimiteDiarioExcedidoException(
                    "Limite diário restante: R$" + limiteRestante
            );
        }

        if(valor > conta.saldo) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente! Saldo atual: R$" + conta.saldo
            );
        }

        conta.saldo -= valor;
        conta.saqueDiario += valor;
    }

    public String consultarSaldo(Conta conta) {
        return String.format(
                "Saldo: R$%.2f | Saques hoje: R$%.2f | Limite restante: R$%.2f",
                conta.saldo, conta.saqueDiario, Conta.LIMITE_SAQUE_DIARIO - conta.saqueDiario
        );
    }
}