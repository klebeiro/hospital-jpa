package org.example.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Consulta;

    @ManyToOne
    @JoinColumn(name = "Id_Medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "Id_Paciente")
    private Paciente paciente;

    @OneToMany(mappedBy = "Consulta")
    private List<Prescricao> prescricao;

    @Column(name = "Data")
    private Date data;

    public Consulta() {
    }

    public Consulta(Long id_Consulta, Medico medico, Paciente paciente, List<Prescricao> prescricao, Date data) {
        Id_Consulta = id_Consulta;
        this.medico = medico;
        this.paciente = paciente;
        this.prescricao = prescricao;
        this.data = data;
    }

    public Long getId_Consulta() {
        return Id_Consulta;
    }

    public void setId_Consulta(Long id_Consulta) {
        Id_Consulta = id_Consulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Prescricao> getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(List<Prescricao> prescricao) {
        this.prescricao = prescricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}