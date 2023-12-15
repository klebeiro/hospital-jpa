package org.example.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Medico;
    @Column(name="Nome")
    private String Nome;
    @OneToMany(mappedBy = "medico")
    private List<Consulta> Consulta;

    public Medico() {
    }

    public Medico(String nome) {
        Nome = nome;
    }

    public Medico(Long id_Medico, String nome, List<org.example.Model.Consulta> consulta) {
        Id_Medico = id_Medico;
        Nome = nome;
        Consulta = consulta;
    }

    public Long getId_Medico() {
        return Id_Medico;
    }

    public void setId_Medico(Long id_Medico) {
        Id_Medico = id_Medico;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public List<org.example.Model.Consulta> getConsulta() {
        return Consulta;
    }

    public void setConsulta(List<org.example.Model.Consulta> consulta) {
        Consulta = consulta;
    }
}