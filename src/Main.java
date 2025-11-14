public class Main {

    public static void main(String[] args) {

        Cliente clienteJoao = new Cliente("João", "111.111.111-11", "31 1111-1111");
        
        Conta minhaConta = new Conta(clienteJoao,
                            111, 222222, "Gil", 0.00);

        minhaConta.depositar(450);
        minhaConta.sacar(50);
        minhaConta.sacar(50);
        minhaConta.sacar(50);

        System.out.println("-----CLIENTE-----");
        System.out.println(minhaConta.getCliente());
        System.out.println();
        
        System.out.println("-----CONTA-----");
        System.out.println(minhaConta);
        System.out.println();

        System.out.println("-----EXTRATO-----");
        System.out.println(minhaConta.getExtrato());
    }
}