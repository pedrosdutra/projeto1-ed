package Restaurante;

public class Mesa {
    int numero;
    String cliente;
    boolean ocupada;
    Pedido pedidos;

    public Mesa(int numero, String cliente, boolean ocupada, Pedido pedidos) {
        this.numero = numero;
        this.cliente = cliente;
        this.ocupada = ocupada;
        this.pedidos = pedidos;
    }
    public void  fecharConta() {
        ocupada = false;
        pedidos = null;
    }
    public String toString() {
        return "Mesa " + numero + "- Cliente: " + cliente + "- Ocupada" + (ocupada ? "Sim" : "Não");
    }
}