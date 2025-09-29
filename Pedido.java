package AtividadePOO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private  int numero;
    private LocalDate data;
    private String status;
    //vetor de itens
    private List<ItemPedido> itens = new ArrayList<>();
    private Cliente cliente;
    private int indice = 0;
    private IPagamento metodoPagamento;



    public Pedido(int numero, LocalDate data, String status, Cliente cliente) {
        this.numero = numero;
        this.data = data;
        this.status = status;
        this.cliente = cliente;
        this.itens = new ArrayList<>();  //começa vazio
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void adicionarItem(Produto produto, int quantidade){
        itens.add(new ItemPedido(produto, quantidade));
    }

    double calcularTotal(){
        double total = 0.0;
        for(int i = 0; i < itens.size(); i++){
            double valorItem = itens.get(i).getSubtotal();
            total += valorItem;
        }
        return total;
    }


}
