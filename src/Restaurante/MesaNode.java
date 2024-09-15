package Restaurante;

public class MesaNode {
    Mesa mesa;
    MesaNode proximo;
    public MesaNode(Mesa mesa) {
        this.mesa = mesa;
        this.proximo = null;
    }
}
