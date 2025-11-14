public class Operacao {
    private TipoOperacao tipo;
    private double valor;

    public Operacao(TipoOperacao tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String toString() {
        return tipo.getDescricao() + ":\t" + valor;
    }
}
