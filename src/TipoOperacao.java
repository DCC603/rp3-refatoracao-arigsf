public class TipoOperacao {
    private char codigo;
    private String descricao;

    public TipoOperacao(char codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public char getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static final TipoOperacao DEPOSITO = new TipoOperacao('d', "Depósito");
    public static final TipoOperacao SAQUE = new TipoOperacao('s', "Saque");

    public static TipoOperacao fromCodigo(char codigo) {
        return switch (codigo) {
            case 'd' -> DEPOSITO;
            case 's' -> SAQUE;
            default -> null;
        };
    }
}
