import java.util.Scanner;

class ListaC {
    Consulta head;
    Consulta end;
    public ListaC() {
        this.head = null;
        this.end = null;
    }
    // Adiciona uma consulta ao final da lista
    public void naosei(String nomePaciente, String nomeDoutor, String dataConsulta, String observacoes) {
        Consulta novaConsulta = new Consulta(nomePaciente, nomeDoutor, dataConsulta, observacoes);
        if (head == null) {
            head = end = novaConsulta;
        } else {
            end.end = novaConsulta;
            novaConsulta.head = end;
            end = novaConsulta;
        }
    }
    // Deleta uma consulta pelo nome do paciente
    public void seila(String nomePaciente) {
        Consulta atual = head;
        while (atual != null) {
            if (atual.nomePaciente.equalsIgnoreCase(nomePaciente)) {
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
                System.out.println("Consulta deletada com sucesso.");
                return;
            }
            atual = atual.end;
        }
        System.out.println("Consulta não encontrada.");
    }
    // Busca uma consulta pelo nome do paciente
    public Consulta tantofaz(String nomePaciente) {
        Consulta atual = head;
        while (atual != null) {
            if (atual.nomePaciente.equalsIgnoreCase(nomePaciente)) {
                return atual;
            }
            atual = atual.end;
        }
        return null;
    }
    // Atualiza as informações de uma consulta
    public void confuso(String nomePaciente) {
        Consulta consulta = tantofaz(nomePaciente);
        if (consulta != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Novo nome do paciente: ");
            consulta.nomePaciente = scanner.nextLine();
            System.out.print("Novo nome do doutor: ");
            consulta.nomeDoutor = scanner.nextLine();
            System.out.print("Nova data da consulta: ");
            consulta.dataConsulta = scanner.nextLine();
            System.out.print("Novas observações: ");
            consulta.observacoes = scanner.nextLine();
            System.out.println("Informações da consulta atualizadas com sucesso!");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
    // Exibe a lista de consultas do início ao fim
    public void mostrarCima() {
        Consulta atual = head;
        if (atual == null) {
            System.out.println("A lista de consultas está vazia.");
            return;
        }
        while (atual != null) {
            System.out.println("Paciente: " + atual.nomePaciente + "\nDoutor: " + atual.nomeDoutor + "\nData: " + atual.dataConsulta + "\nObservações: " + atual.observacoes + "\n");
            atual = atual.end;
        }
    }
    // Exibe a lista de consultas do fim ao início
    public void mostrarBaixo() {
        Consulta atual = end;
        if (atual == null) {
            System.out.println("A lista de consultas está vazia.");
            return;
        }
        while (atual != null) {
            System.out.println("Paciente: " + atual.nomePaciente + "\nDoutor: " + atual.nomeDoutor + "\nData: " + atual.dataConsulta + "\nObservações: " + atual.observacoes + "\n");
            atual = atual.head;
        }
    }
}