package org.example;

import org.example.Model.Medicamento;
import org.example.Model.Medico;
import org.example.Model.Paciente;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("persistenceUnitName");
    static EntityManager entity = entityFactory.createEntityManager();
    public static void main(String[] args) {

        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarMedico();
                    break;
                case 2:
                    listarMedicos();
                    break;
                case 3:
                    atualizarMedico();
                    break;
                case 4:
                    deletarMedico();
                    break;
                case 0:
                    System.out.println("Encerrando o programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void deletarMedico() {
    }

    private static void atualizarMedico() {
    }

    private static void exibirMenu() {
        System.out.flush();
        System.out.println("\n------ Menu ------");
        System.out.println("1 - Cadastrar Médico");
        System.out.println("2 - Listar Médicos");
        System.out.println("3 - Atualizar Médico");
        System.out.println("4 - Deletar Médico");
        System.out.println("0 - Sair");
        System.out.println("-------------------");
    }

    private static void cadastrarMedico() {
        System.out.println("Informe o nome do médico: ");
        String nome = scanner.nextLine();

        Medico medico = new Medico(nome);
        entity.getTransaction().begin();
        entity.persist(medico);
        entity.getTransaction().commit();
    }

    private static void listarMedicos() {
        List<Medico> medicos = findAll(Medico.class);

        for (Medico medico : medicos) {
            System.out.println(medico.getId_Medico() + " " + medico.getNome());
        }
    }

    public static <T> List<T> findAll(Class<T> entityClass) {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        TypedQuery<T> query = entity.createQuery(jpql, entityClass);

        return query.getResultList();
    }

}