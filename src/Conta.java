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

    public Cliente getCliente() {
        return this.cliente;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        Operacao op = new Operacao(TipoOperacao.DEPOSITO, valor);
        this.operacoes.add(op);
    }

    public void sacar(double valor) {
        if(saldo < valor){
            return;
        }
        this.saldo -= valor;
        Operacao op = new Operacao(TipoOperacao.SAQUE, valor);
        this.operacoes.add(op);
    }

    public String getExtrato() {
        String dadosExtrato = "";
        for(Operacao op : this.operacoes) {
            dadosExtrato += op.toString() + "\n";
        }
        return dadosExtrato;
    }

    public String toString() {
        String dadosConta = String.format("Ag.: %d\nConta: %d\nGerente: %s\nSaldo: %.2f",
                this.numAgencia, this.numConta, this.gerente, this.saldo);
        
        return dadosConta;
    }
}
