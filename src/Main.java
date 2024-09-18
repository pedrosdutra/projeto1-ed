import java.util.Scanner;

import Restaurante.Tela;

// Função principal
public class Main {
    public static void main(String[] args) {
        new Tela();
        Scanner scanner = new Scanner(System.in);
        ListaP pacientes = new ListaP();
        ListaD doutores = new ListaD();
        ListaC consultas = new ListaC();
        int loginOption;
        do {
            System.out.println("Sistema de Login:");
            System.out.println("1. Fazer login");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            loginOption = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha
            if (loginOption == 1) {
                System.out.print("Digite o nome de usuário: ");
                String username = scanner.nextLine();

                if (username.equalsIgnoreCase("admin")) {
                    adminMenu(scanner, pacientes, doutores, consultas);
                } else {
                    employeeMenu(scanner, pacientes, doutores, consultas);
                }
            } else if (loginOption == 2) {
                System.out.println("Saindo do programa...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (loginOption != 2);
        scanner.close();
    }
    // Menu para o administrador
    public static void adminMenu(Scanner scanner, ListaP pacientes, ListaD doutores, ListaC consultas) {
        int option;
        do {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Adicionar paciente");
            System.out.println("2. Exibir lista de pacientes (Início ao fim)");
            System.out.println("3. Exibir lista de pacientes (Fim ao início)");
            System.out.println("4. Editar informações de paciente");
            System.out.println("5. Deletar paciente");
            System.out.println("6. Adicionar doutor");
            System.out.println("7. Exibir lista de doutores (Início ao fim)");
            System.out.println("8. Exibir lista de doutores (Fim ao início)");
            System.out.println("9. Editar informações de doutor");
            System.out.println("10. Deletar doutor");
            System.out.println("11. Adicionar consulta");
            System.out.println("12. Exibir lista de consultas (Início ao fim)");
            System.out.println("13. Exibir lista de consultas (Fim ao início)");
            System.out.println("14. Editar informações de consulta");
            System.out.println("15. Deletar consulta");
            System.out.println("16. Logout");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Idade do paciente: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Histórico Médico: ");
                    String medicalHistory = scanner.nextLine();
                    System.out.print("Data da Última Consulta: ");
                    String lastConsultationDate = scanner.nextLine();

                    pacientes.naosei(patientName, patientAge, medicalHistory, lastConsultationDate);
                    System.out.println("Paciente adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("\nLista de pacientes do início ao fim:");
                    pacientes.mostrarCima();
                    break;
                case 3:
                    System.out.println("\nLista de pacientes do fim ao início:");
                    pacientes.mostrarBaixo();
                    break;
                case 4:
                    System.out.print("Digite o nome do paciente que deseja editar: ");
                    String patientNameToUpdate = scanner.nextLine();
                    pacientes.confuso(patientNameToUpdate);
                    break;
                case 5:
                    System.out.print("Digite o nome do paciente que deseja deletar: ");
                    String patientNameToDelete = scanner.nextLine();
                    pacientes.seila(patientNameToDelete);
                    break;
                case 6:
                    System.out.print("Nome do doutor: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Especialidade do doutor: ");
                    String specialty = scanner.nextLine();
                    System.out.print("Disponibilidade do doutor: ");
                    String availability = scanner.nextLine();
                    doutores.naosei(doctorName, specialty, availability);
                    System.out.println("Doutor adicionado com sucesso!");
                    break;
                case 7:
                    System.out.println("\nLista de doutores do início ao fim:");
                    doutores.mostrarCima();
                    break;
                case 8:
                    System.out.println("\nLista de doutores do fim ao início:");
                    doutores.mostrarBaixo();
                    break;
                case 9:
                    System.out.print("Digite o nome do doutor que deseja editar: ");
                    String doctorNameToUpdate = scanner.nextLine();
                    doutores.confuso(doctorNameToUpdate);
                    break;
                case 10:
                    System.out.print("Digite o nome do doutor que deseja deletar: ");
                    String doctorNameToDelete = scanner.nextLine();
                    doutores.seila(doctorNameToDelete);
                    break;
                case 11:
                    System.out.print("Nome do paciente: ");
                    String consultationPatientName = scanner.nextLine();
                    System.out.print("Nome do doutor: ");
                    String consultationDoctorName = scanner.nextLine();
                    System.out.print("Data da consulta: ");
                    String consultationDate = scanner.nextLine();
                    System.out.print("Observações: ");
                    String consultationNotes = scanner.nextLine();
                    consultas.naosei(consultationPatientName, consultationDoctorName, consultationDate, consultationNotes);
                    System.out.println("Consulta adicionada com sucesso!");
                    break;
                case 12:
                    System.out.println("\nLista de consultas do início ao fim:");
                    consultas.mostrarCima();
                    break;
                case 13:
                    System.out.println("\nLista de consultas do fim ao início:");
                    consultas.mostrarBaixo();
                    break;
                case 14:
                    System.out.print("Digite o nome do paciente da consulta que deseja editar: ");
                    String consultationPatientNameToUpdate = scanner.nextLine();
                    consultas.confuso(consultationPatientNameToUpdate);
                    break;
                case 15:
                    System.out.print("Digite o nome do paciente da consulta que deseja deletar: ");
                    String consultationPatientNameToDelete = scanner.nextLine();
                    consultas.seila(consultationPatientNameToDelete);
                    break;
                case 16:
                    System.out.println("Deslogando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 16);
    }
    // Menu para funcionários (não-admin)
    public static void employeeMenu(Scanner scanner, ListaP pacientes, ListaD doutores, ListaC consultas) {
        int option;
        do {
            System.out.println("\nMenu Funcionário:");
            System.out.println("1. Exibir lista de pacientes (Início ao fim)");
            System.out.println("2. Exibir lista de pacientes (Fim ao início)");
            System.out.println("3. Exibir lista de doutores (Início ao fim)");
            System.out.println("4. Exibir lista de doutores (Fim ao início)");
            System.out.println("5. Adicionar consulta");
            System.out.println("6. Exibir lista de consultas (Início ao fim)");
            System.out.println("7. Exibir lista de consultas (Fim ao início)");
            System.out.println("8. Editar informações de consulta");
            System.out.println("9. Deletar consulta");
            System.out.println("10. Logout");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("\nLista de pacientes do início ao fim:");
                    pacientes.mostrarCima();
                    break;
                case 2:
                    System.out.println("\nLista de pacientes do fim ao início:");
                    pacientes.mostrarBaixo();
                    break;
                case 3:
                    System.out.println("\nLista de doutores do início ao fim:");
                    doutores.mostrarCima();
                    break;
                case 4:
                    System.out.println("\nLista de doutores do fim ao início:");
                    doutores.mostrarBaixo();
                    break;
                case 5:
                    System.out.print("Nome do paciente: ");
                    String consultationPatientName = scanner.nextLine();
                    System.out.print("Nome do doutor: ");
                    String consultationDoctorName = scanner.nextLine();
                    System.out.print("Data da consulta: ");
                    String consultationDate = scanner.nextLine();
                    System.out.print("Observações: ");
                    String consultationNotes = scanner.nextLine();
                    consultas.naosei(consultationPatientName, consultationDoctorName, consultationDate, consultationNotes);
                    System.out.println("Consulta adicionada com sucesso!");
                    break;
                case 6:
                    System.out.println("\nLista de consultas do início ao fim:");
                    consultas.mostrarCima();
                    break;
                case 7:
                    System.out.println("\nLista de consultas do fim ao início:");
                    consultas.mostrarBaixo();
                    break;
                case 8:
                    System.out.print("Digite o nome do paciente da consulta que deseja editar: ");
                    String consultationPatientNameToUpdate = scanner.nextLine();
                    consultas.confuso(consultationPatientNameToUpdate);
                    break;
                case 9:
                    System.out.print("Digite o nome do paciente da consulta que deseja deletar: ");
                    String consultationPatientNameToDelete = scanner.nextLine();
                    consultas.seila(consultationPatientNameToDelete);
                    break;
                case 10:
                    System.out.println("Deslogando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 10);
    }
}