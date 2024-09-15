package Restaurante;

public class ListaPedidos {
    private PedidoNode inicio;
    private PedidoNode fim;
    private int contaPedidos = 1;

    public ListaPedidos() {
        inicio = null;
        fim = null;
    }
    public void adicionarPedido(String descricao, int quantidade, double total) {
        Pedido novoPedido = new Pedido(contaPedidos++, descricao, quantidade, total);
        PedidoNode novoPedidoNo = new PedidoNode(novoPedido);

        if (inicio == null) {
            inicio = novoPedidoNo;
            fim = novoPedidoNo;
            fim.proximo = inicio;
        } else {
            fim.proximo = novoPedidoNo;
            fim = novoPedidoNo;
            fim.proximo = inicio;
        }
    }
    public void listarPedidos() {
        if (inicio == null) {
            System.out.println("Nenhum pedido no momento");
            return;
        }
        PedidoNode atual = inicio;
        do {
            System.out.println(atual.pedido);
            atual = atual.proximo;
        } while (atual != inicio);
    }
}