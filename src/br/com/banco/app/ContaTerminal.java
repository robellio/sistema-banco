package br.com.banco.app;

import br.com.banco.model.Conta;
import br.com.banco.model.ContaCorrente;
import br.com.banco.model.ContaPoupanca;
import br.com.banco.service.ContaService;

import java.util.Scanner;

public class ContaTerminal {
    private static final Scanner scanner = new Scanner(System.in);
    private static ContaService service = new ContaService();
    private static Conta conta;

    public static void main(String[] args) {
        while(true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch(opcao) {
                case 1 -> criarConta();
                case 2 -> depositar();
                case 3 -> sacar();
                case 4 -> consultarSaldo();
                case 5 -> System.exit(0);
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n===== Banco Digital =====");
        System.out.println("1. Criar conta");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("4. Consultar saldo");
        System.out.println("5. Sair");
        System.out.print("Escolha: ");
    }

    private static void criarConta() {
        System.out.print("\nNúmero da conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Tipo (1-Corrente 2-Poupança): ");
        int tipo = scanner.nextInt();

        if(tipo == 1) {
            conta = new ContaCorrente(numero, agencia, nome);
        } else {
            conta = new ContaPoupanca(numero, agencia, nome);
        }

        System.out.println("Conta criada com sucesso!");
    }

    private static void depositar() {
        System.out.print("\nValor do depósito: R$");
        double valor = scanner.nextDouble();

        try {
            service.depositar(conta, valor);
            System.out.println("Depósito realizado!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void sacar() {
        System.out.print("\nValor do saque: R$");
        double valor = scanner.nextDouble();

        try {
            service.sacar(conta, valor);
            System.out.println("Saque realizado!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void consultarSaldo() {
        System.out.println("\n" + service.consultarSaldo(conta));
    }
}