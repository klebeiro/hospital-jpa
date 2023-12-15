package org.example.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Paciente;
    @Column(name="Nome")
    private String Nome;
    @Column (name="Telefone")
    private String Telefone;
    @Column (name="Idade")
    private Integer Idade;
    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consulta;

    public Paciente() {
    }

    public Paciente(Long id_Paciente, String nome, String telefone, Integer idade, List<Consulta> consulta) {
        Id_Paciente = id_Paciente;
        Nome = nome;
        Telefone = telefone;
        Idade = idade;
        this.consulta = consulta;
    }

    public Paciente(String nome, String telefone, Integer idade) {
        Nome = nome;
        Telefone = telefone;
        Idade = idade;
    }

    public Long getId_Paciente() {
        return Id_Paciente;
    }

    public void setId_Paciente(Long id_Paciente) {
        Id_Paciente = id_Paciente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public Integer getIdade() {
        return Idade;
    }

    public void setIdade(Integer idade) {
        Idade = idade;
    }

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }
}