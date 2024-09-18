package Restaurante;

public class Pedido {
    int id;  //id para identificar o pedido
    String descricao;
    int quantidade;
    double total;

    public Pedido(int id, String descricao, int quantidade, double total) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido ID: " + id + " - " + descricao + " - Quantidade: " + quantidade + " - Total: R$ " + total;
    }
}
