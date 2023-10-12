import java.util.Locale;
import java.util.Scanner;

public class ContaBancaria {

    private String nomeTitular;
    private String agencia;
    private String numero;
    private double saldo;

    public ContaBancaria(String nomeTitular, String agencia, String numero,double saldoInicial){
        this.nomeTitular = nomeTitular;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldoInicial;
    }
    public void depositar(double valor){
        if (valor > 0){
            saldo += valor;
            System.out.println("Depósito de R$" + valor + "realizado com sucesso.");
        }else{
            System.out.println("O valor do depósito deve ser maior que zero.");
        }
    }
    public void sacar(double valor){
        if (valor >0 && saldo >=valor){
            saldo -= valor;
            System.out.println("Saque de R$" + valor + "realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");  
        }
    }
    public double getSaldo(){
        return saldo;
    }
    public void mostrarSaldo(){
        System.out.println("Titular: " + nomeTitular);
        System.out.println("Agência: " + agencia);
        System.out.println("Número: " + numero);
        System.out.println("Saldo: R$" + saldo);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();

        System.out.print("Digite a agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Digite o número da conta: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        System.out.print("Digite o valor do depósito: ");
        double valorDeposito = scanner.nextDouble();

        ContaBancaria minhaConta = new ContaBancaria(nomeTitular, agencia, numero, saldoInicial);

        minhaConta.depositar(valorDeposito);;
        minhaConta.mostrarSaldo();

        System.out.println("Olá " + nomeTitular + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numero + " e seu saldo R$" + minhaConta.getSaldo() + " já está disponível para saque.");


        scanner.close();
    }
}
