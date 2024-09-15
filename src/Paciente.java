class Paciente {
    String nome;
    int idade;
    String historicoMedico;
    String dataUltimaConsulta;
    Paciente head;
    Paciente end;

    Paciente(String nome, int idade, String historicoMedico, String dataUltimaConsulta) {
        this.nome = nome;
        this.idade = idade;
        this.historicoMedico = historicoMedico;
        this.dataUltimaConsulta = dataUltimaConsulta;
        this.head = null;
        this.end = null;
    }
}