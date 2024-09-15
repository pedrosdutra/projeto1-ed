package Restaurante;

public class PedidoNode {
    Pedido pedido;
    PedidoNode proximo;
    public PedidoNode(Pedido pedido) {
        this.pedido = pedido;
        this.proximo = null;
    }
}
