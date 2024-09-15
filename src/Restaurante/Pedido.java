package Restaurante;

public class Pedido {
    String descricao;
    int quantidade;
    double total;

    public Pedido(String descricao, int quantidade, double total) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.total = total;
    }
    public String toString() {
        return descricao + " - Quantidade: " + quantidade + "-Total: " +total;
    }
}