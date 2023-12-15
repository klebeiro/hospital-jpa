package org.example.Model;

import javax.persistence.*;

@Entity
@Table(name = "Medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Medicamento;
    @Column(name="Nome")
    private String Nome;
    @ManyToOne
    @JoinColumn(name = "Id_Prescricao")
    private Prescricao prescricao;

    public Medicamento() {
    }

    public Medicamento(String nome) {
        Nome = nome;
    }

    public Medicamento(Long id_Medicamento, String nome, Prescricao prescricao) {
        Id_Medicamento = id_Medicamento;
        Nome = nome;
        this.prescricao = prescricao;
    }

    public Long getId_Medicamento() {
        return Id_Medicamento;
    }

    public void setId_Medicamento(Long id_Medicamento) {
        Id_Medicamento = id_Medicamento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Prescricao getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(Prescricao prescricao) {
        this.prescricao = prescricao;
    }
}