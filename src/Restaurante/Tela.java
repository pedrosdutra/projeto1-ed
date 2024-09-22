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
        criarTelaLogin();
    }

    private void criarTelaLogin() {
        frame = new JFrame("Restaurante - Login");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel painelLogin = new JPanel(new GridLayout(3, 2));

        JLabel labelUsuario = new JLabel("Usuário:");
        JTextField campoUsuario = new JTextField();
        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField();

        JButton botaoLogin = new JButton("Login");
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());

                if (autenticarUsuario(usuario, senha)) {
                    criarTelaPrincipal();
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuário ou senha inválidos.");
                }
            }
        });

        painelLogin.add(labelUsuario);
        painelLogin.add(campoUsuario);
        painelLogin.add(labelSenha);
        painelLogin.add(campoSenha);
        painelLogin.add(new JLabel());
        painelLogin.add(botaoLogin);

        frame.add(painelLogin, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private boolean autenticarUsuario(String usuario, String senha) {
        // Implementar autenticação (usuário: "admin", senha: "1234")
        return usuario.equals("admin") && senha.equals("1234");
    }

    private void criarTelaPrincipal() {
        frame.getContentPane().removeAll();  // Limpa a tela de login
        frame.setTitle("Restaurante - Gerenciamento");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(2, 2, 10, 10));  // Melhora espaçamento

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

        // Botão para sair
        JButton botaoSair = new JButton("Sair");
        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarTelaLogin();  // Retorna à tela de login
            }
        });
        painelBotoes.add(botaoSair);

        frame.add(painelBotoes, BorderLayout.SOUTH);
        frame.revalidate();  // Atualiza a tela
        frame.repaint();  // Redesenha a tela
    }

    private void adicionarMesa() {
        String numeroStr = JOptionPane.showInputDialog("Número da Mesa:");
        String cliente = JOptionPane.showInputDialog("Nome do Cliente:");
        boolean ocupada = JOptionPane.showConfirmDialog(frame, "A mesa está ocupada?", "Ocupada", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    
        int numero = Integer.parseInt(numeroStr);
        Mesa mesa = new Mesa(numero, cliente, ocupada, null);
        listaMesa.adicionarMesa(mesa);
    
        String ocupacaoTexto = ocupada ? "Sim" : "Não";
        areaTexto.append("Mesa adicionada: Mesa " + numero + " - Cliente: " + cliente + " - Ocupada: " + ocupacaoTexto + "\n");
        scrollToBottom();
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
        scrollToBottom();
    }

    private void listarMesas() {
        areaTexto.setText("");  // Limpa a área de texto
        areaTexto.append("Listando mesas:\n");
        MesaNode atual = listaMesa.primeiro;
        while (atual != null) {
            areaTexto.append(atual.mesa.toString() + "\n");
            atual = atual.proximo;
        }
        scrollToBottom();
    }

    private void listarPedidos() {
        areaTexto.setText("");  // Limpa a área de texto
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
        scrollToBottom();
    }

    // Método para rolar o JTextArea para o final após adicionar texto
    private void scrollToBottom() {
        areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
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
