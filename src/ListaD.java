import java.util.Scanner;

class ListaD {
    Doutor head;
    Doutor end;
    public ListaD() {
        this.head = null;
        this.end = null;
    }
    // Adiciona um doutor ao final da lista
    public void naosei(String nome, String especialidade, String disponibilidade) {
        Doutor novoDoutor = new Doutor(nome, especialidade, disponibilidade);
        if (head == null) {
            head = end = novoDoutor;
        } else {
            end.end = novoDoutor;
            novoDoutor.head = end;
            end = novoDoutor;
        }
    }
    // Deleta um doutor pelo nome
    public void seila(String nome) {
        Doutor atual = head;
        while (atual != null) {
            if (atual.nome.equalsIgnoreCase(nome)) {
                if (atual.head != null) {
                    atual.head.end = atual.end;
                } else {
                    head = atual.end;
                }
                if (atual.end != null) {
                    atual.end.head = atual.head;
                } else {
                    end = atual.head;
                }
                System.out.println("Doutor deletado com sucesso.");
                return;
            }
            atual = atual.end;
        }
        System.out.println("Doutor não encontrado.");
    }
    // Busca um doutor pelo nome
    public Doutor tantofaz(String nome) {
        Doutor atual = head;
        while (atual != null) {
            if (atual.nome.equalsIgnoreCase(nome)) {
                return atual;
            }
            atual = atual.end;
        }
        return null;
    }
    // Atualiza as informações de um doutor
    public void confuso(String nome) {
        Doutor doutor = tantofaz(nome);
        if (doutor != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Novo nome: ");
            doutor.nome = scanner.nextLine();
            System.out.print("Nova especialidade: ");
            doutor.especialidade = scanner.nextLine();
            System.out.print("Nova disponibilidade: ");
            doutor.disponibilidade = scanner.nextLine();
            System.out.println("Informações do doutor atualizadas com sucesso!");
        } else {
            System.out.println("Doutor não encontrado.");
        }
    }
    // Exibe a lista de doutores do início ao fim
    public void mostrarCima() {
        Doutor atual = head;
        if (atual == null) {
            System.out.println("A lista de doutores está vazia.");
            return;
        }
        while (atual != null) {
            System.out.println("Nome: " + atual.nome + "\nEspecialidade: " + atual.especialidade + "\nDisponibilidade: " + atual.disponibilidade + "\n");
            atual = atual.end;
        }
    }
    // Exibe a lista de doutores do fim ao início
    public void mostrarBaixo() {
        Doutor atual = end;
        if (atual == null) {
            System.out.println("A lista de doutores está vazia.");
            return;
        }
        while (atual != null) {
            System.out.println("Nome: " + atual.nome + "\nEspecialidade: " + atual.especialidade + "\nDisponibilidade: " + atual.disponibilidade + "\n");
            atual = atual.head;
        }
    }
}