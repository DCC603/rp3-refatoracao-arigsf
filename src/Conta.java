import java.util.ArrayList;
import java.util.List;

public class Conta {
    private Cliente cliente;

    private int numAgencia;
    private int numConta;
    private String gerente;

    private double saldo;

    private List<Operacao> operacoes;

    public Conta(Cliente cliente, int numAgencia, int numConta, String gerente, double saldo) {
        this.cliente = cliente;
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.gerente = gerente;
        this.saldo = saldo;
        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, 0, 0, null, 0);
    }

    public void depositar(double valor) {
        this.saldo += valor;
        Operacao op = new Operacao('d', valor);
        this.operacoes.add(op);
    }

    public void sacar(double valor) {
        if(saldo < valor){
            return;
        }
        this.saldo -= valor;
        Operacao op = new Operacao('s', valor);
        this.operacoes.add(op);
    }

    public String toString() {
        // TODO(#4) REFATORAR: Esses dados não estão relacionados a conta
        String dadosCliente = String.format("CPF: %s\nNome: %s\nTelefone: %s",
                this.cpfCliente, this.nomeCliente, this.telefoneCliente);

        // TODO(#4) REFATORAR: Esses dados não estão relacinados a conta
        String dadosConta = String.format("Ag.: %d\nConta: %d\nGerente: %s\nSaldo: %.2f",
                this.numAgencia, this.numConta, this.gerente, this.valor);

        // TODO(#5) REFATORAR: Essa operação não deveria estar sendo realizada neste método
        String dadosExtrato = "";
        for(Operacao op : this.operacoes) {
            dadosExtrato += op.toString() + "\n";
        }

        return "-----CLIENTE-----\n" +
                dadosCliente +
                "\n\n" +
                "-----CONTA-----\n" +
                dadosConta +
                "\n\n" +
                "-----EXTRATO-----\n" +
                dadosExtrato +
                "\n";
    }
}
