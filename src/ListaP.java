import java.util.Scanner;

class ListaP {
    Paciente head;
    Paciente end;

    public ListaP() {
        this.head = null;
        this.end = null;
    }
    // Adiciona um paciente ao final da lista
    public void naosei(String nome, int idade, String historicoMedico, String dataUltimaConsulta) {
        Paciente novoPaciente = new Paciente(nome, idade, historicoMedico, dataUltimaConsulta);
        if (head == null) {
            head = end = novoPaciente;
        } else {
            end.end = novoPaciente;
            novoPaciente.head = end;
            end = novoPaciente;
        }
    }
    // Deleta um paciente pelo nome
    public void seila(String nome) {
        Paciente atual = head;
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
                System.out.println("Paciente deletado com sucesso.");
                return;
            }
            atual = atual.end;
        }
        System.out.println("Paciente não encontrado.");
    }
    // Busca um paciente pelo nome
    public Paciente tantofaz(String nome) {
        Paciente atual = head;
        while (atual != null) {
            if (atual.nome.equalsIgnoreCase(nome)) {
                return atual;
            }
            atual = atual.end;
        }
        return null;
    }
    // Atualiza as informações de um paciente
    public void confuso(String nome) {
        Paciente paciente = tantofaz(nome);
        if (paciente != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Novo nome: ");
            paciente.nome = scanner.nextLine();
            System.out.print("Nova idade: ");
            paciente.idade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Novo histórico médico: ");
            paciente.historicoMedico = scanner.nextLine();
            System.out.print("Nova data da última consulta: ");
            paciente.dataUltimaConsulta = scanner.nextLine();
            System.out.println("Informações do paciente atualizadas com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
    // Exibe a lista de pacientes do início ao fim
    public void mostrarCima() {
        Paciente atual = head;
        if (atual == null) {
            System.out.println("A lista de pacientes está vazia.");
            return;
        }
        while (atual != null) {
            System.out.println("Nome: " + atual.nome + "\nIdade: " + atual.idade + "\nHistórico Médico: " + atual.historicoMedico + "\nData da Última Consulta: " + atual.dataUltimaConsulta + "\n");
            atual = atual.end;
        }
    }
    // Exibe a lista de pacientes do fim ao início
    public void mostrarBaixo() {
        Paciente atual = end;
        if (atual == null) {
            System.out.println("A lista de pacientes está vazia.");
            return;
        }
        while (atual != null) {
            System.out.println("Nome: " + atual.nome + "\nIdade: " + atual.idade + "\nHistórico Médico: " + atual.historicoMedico + "\nData da Última Consulta: " + atual.dataUltimaConsulta + "\n");
            atual = atual.head;
        }
    }
}