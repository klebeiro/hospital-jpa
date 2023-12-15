package org.example.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Prescricao")
public class Prescricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Prescricao;

    @Column(name="Posologia")
    private String Posologia;

    @ManyToOne
    @JoinColumn(name="Id_Consulta")
    private Consulta Consulta;

    @OneToMany
    @JoinColumn(name="Id_Medicamento")
    private List<Medicamento> Medicamento;

    public Prescricao() {
    }

    public Prescricao(Long id_Prescricao, String posologia, Consulta consulta, List<Medicamento> medicamento) {
        Id_Prescricao = id_Prescricao;
        Posologia = posologia;
        this.Consulta = consulta;
        this.Medicamento = medicamento;
    }

    public Long getId_Prescricao() {
        return Id_Prescricao;
    }

    public void setId_Prescricao(Long id_Prescricao) {
        Id_Prescricao = id_Prescricao;
    }

    public String getPosologia() {
        return Posologia;
    }

    public void setPosologia(String posologia) {
        Posologia = posologia;
    }

    public Consulta getConsulta() {
        return Consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.Consulta = consulta;
    }

    public List<Medicamento> getMedicamento() {
        return Medicamento;
    }

    public void setMedicamento(List<Medicamento> medicamento) {
        this.Medicamento = medicamento;
    }
}