package AtividadePOO;

import java.sql.SQLOutput;
import java.time.LocalDate;


public class SistemaPedidos {
    public static void main(String[] args) {
        Produto teclado = new Produto("Teclado Fortrek", 79.10);
        Produto mousepad = new Produto("Mouse pad preto", 8.90);
        Produto mouse = new Produto("Mouse Dell", 62.00);
        Produto monitor  = new Produto("Monitor", 1500.00);
        Produto cadeira = new Produto("Cadeira", 500.00);
        Produto mesa = new Produto("Mesa", 800.00);

        ItemPedido itemTeclado = new ItemPedido(teclado, 1);
        ItemPedido itemMousepad = new ItemPedido(mousepad, 2);
        ItemPedido itemMouse = new ItemPedido(mouse, 2);
        ItemPedido itemMonitor = new ItemPedido(monitor, 3);
        ItemPedido itemCadeira = new ItemPedido(cadeira, 4);
        ItemPedido itemMesa = new ItemPedido(mesa, 3);

        ClientePF clientePF = new ClientePF("Henrique", "henriquelj@gmail.com", "033234105612");
        ClientePJ clientePJ = new ClientePJ("Sávio LTDA", "savio@empresa.com", "9086535100000");


        Pedido pedido1 = new Pedido(1, LocalDate.now(), "Aberto", clientePF);
        pedido1.adicionarItem(teclado, 1);
        pedido1.adicionarItem(mousepad, 1);
        pedido1.adicionarItem(mouse, 1);

        IPagamento pagamento1 = new PagamentoCartaoCredito();
        System.out.println("Cliente PF: " + clientePF.getNome());
        System.out.println("Pedido 1 (Cartão)");
        System.out.println("Total: R$ " + String.format("%.2f", pedido1.calcularTotal()));
        System.out.println("Pagamento aprovado? " + pagamento1.processarPagamento(pedido1.calcularTotal()));
        System.out.println();


        Pedido pedido2 = new Pedido(2, LocalDate.now(), "Aberto", clientePF);
        pedido2.adicionarItem(cadeira, 1);
        IPagamento pagamento2 = new PagamentoCartaoCredito();
        System.out.println("Cliente PF: " + clientePF.getNome());
        System.out.println("Pedido 2 (Cartão)");
        System.out.println("Total: R$ " + String.format("%.2f", pedido2.calcularTotal()));
        System.out.println("Pagamento aprovado? " + pagamento2.processarPagamento(pedido2.calcularTotal()));
        System.out.println();

        Pedido pedido3 = new Pedido(3, LocalDate.now(), "Aberto", clientePJ);
        pedido3.adicionarItem(mesa, 1);
        IPagamento pagamento3 = new PagamentoBoleto();
        System.out.println("Cliente PJ: " + clientePJ.getNome());
        System.out.println("Pedido 3 (Boleto)");
        System.out.println("Total: R$ " + String.format("%.2f", pedido3.calcularTotal()));
        System.out.println("Pagamento aprovado? " + pagamento3.processarPagamento(pedido3.calcularTotal()));
        System.out.println();

        Pedido pedido4 = new Pedido (4, LocalDate.now(), "Aberto", clientePJ);
        pedido4.adicionarItem(monitor, 1);
        IPagamento pagamento4 = new PagamentoBoleto();
        System.out.println("Cliente PJ: " + clientePJ.getNome());
        System.out.println("Pedido 4 (Boleto)");
        System.out.println("Total: R$ " + String.format("%.2f", pedido4.calcularTotal()));
        System.out.println("Pagamento aprovado? " +  pagamento4.processarPagamento(pedido4.calcularTotal()) );

    }
}
