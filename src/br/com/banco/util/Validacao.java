package br.com.banco.util;

public class Validacao {
    public static void validarValorPositivo(double valor) {
        if(valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo!");
        }
    }
}