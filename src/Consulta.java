class Consulta {
    String nomePaciente;
    String nomeDoutor;
    String dataConsulta;
    String observacoes;
    Consulta head;
    Consulta end;

    Consulta(String nomePaciente, String nomeDoutor, String dataConsulta, String observacoes) {
        this.nomePaciente = nomePaciente;
        this.nomeDoutor = nomeDoutor;
        this.dataConsulta = dataConsulta;
        this.observacoes = observacoes;
        this.head = null;
        this.end = null;
    }
}