
package br.com.banco.exception;

public class LimiteDiarioExcedidoException extends Exception {
    public LimiteDiarioExcedidoException(String mensagem) {
        super(mensagem);
    }
}
