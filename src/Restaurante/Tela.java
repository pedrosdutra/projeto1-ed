package Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela {
    private ListaMesa listaMesa;
    private ListaPedidos listaPedidos;
    private JFrame frame;
    private JTextArea areaTexto;

    public Tela() {
        listaMesa = new ListaMesa();
        listaPedidos = new ListaPedidos();
        criarGUI();
    }

    private void criarGUI() {
        frame = new JFrame("Restaurante - Gerenciamento");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(4, 2));

        // Botão para adicionar mesa
        JButton botaoAdicionarMesa = new JButton("Adicionar Mesa");
        botaoAdicionarMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarMesa();
            }
        });
        painelBotoes.add(botaoAdicionarMesa);

        // Botão para adicionar pedido
        JButton botaoAdicionarPedido = new JButton("Adicionar Pedido");
        botaoAdicionarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarPedido();
            }
        });
        painelBotoes.add(botaoAdicionarPedido);

        // Botão para listar mesas
        JButton botaoListarMesas = new JButton("Listar Mesas");
        botaoListarMesas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarMesas();
            }
        });
        painelBotoes.add(botaoListarMesas);

        // Botão para listar pedidos
        JButton botaoListarPedidos = new JButton("Listar Pedidos");
        botaoListarPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPedidos();
            }
        });
        painelBotoes.add(botaoListarPedidos);

        frame.add(painelBotoes, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void adicionarMesa() {
        String numeroStr = JOptionPane.showInputDialog("Número da Mesa:");
        String cliente = JOptionPane.showInputDialog("Nome do Cliente:");
        boolean ocupada = JOptionPane.showConfirmDialog(frame, "A mesa está ocupada?", "Ocupada", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        int numero = Integer.parseInt(numeroStr);
        Mesa mesa = new Mesa(numero, cliente, ocupada, null);
        listaMesa.adicionarMesa(mesa);
        areaTexto.append("Mesa adicionada: " + mesa + "\n");
    }

    private void adicionarPedido() {
        String numeroStr = JOptionPane.showInputDialog("Número da Mesa:");
        int numero = Integer.parseInt(numeroStr);
        Mesa mesa = listaMesa.buscarMesa(numero);

        if (mesa == null) {
            JOptionPane.showMessageDialog(frame, "Mesa não encontrada.");
            return;
        }

        String descricao = JOptionPane.showInputDialog("Descrição do Pedido:");
        String quantidadeStr = JOptionPane.showInputDialog("Quantidade:");
        String totalStr = JOptionPane.showInputDialog("Total:");

        int quantidade = Integer.parseInt(quantidadeStr);
        double total = Double.parseDouble(totalStr);

        listaPedidos.adicionarPedido(descricao, quantidade, total);

        areaTexto.append("Pedido adicionado à mesa " + numero + ": " + descricao + "\n");
    }

    private void listarMesas() {
        areaTexto.setText(""); // Limpa a área de texto
        areaTexto.append("Listando mesas:\n");
        MesaNode atual = listaMesa.primeiro;
        while (atual != null) {
            areaTexto.append(atual.mesa.toString() + "\n");
            atual = atual.proximo;
        }
    }

    private void listarPedidos() {
        areaTexto.setText(""); // Limpa a área de texto
        areaTexto.append("Listando pedidos:\n");
        PedidoNode atual = listaPedidos.inicio;
        if (atual != null) {
            do {
                areaTexto.append(atual.pedido.toString() + "\n");
                atual = atual.proximo;
            } while (atual != listaPedidos.inicio);
        } else {
            areaTexto.append("Nenhum pedido no momento\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tela();
            }
        });
    }
}