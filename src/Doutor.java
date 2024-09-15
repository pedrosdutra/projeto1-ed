class Doutor {
    String nome;
    String especialidade;
    String disponibilidade;
    Doutor head;
    Doutor end;

    Doutor(String nome, String especialidade, String disponibilidade) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponibilidade = disponibilidade;
        this.head = null;
        this.end = null;
    }
}