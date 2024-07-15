package br.com.pinedev.saladeaula.modelo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int trimestre;
    @ElementCollection
    private List<Double> notas;
    private Double notaRecuperacao;

    @ManyToOne
    private Aluno aluno;

    // Construtores, getters e setters
    public Avaliacao() {}

    public Avaliacao(int trimestre, List<Double> notas) {
        this.trimestre = trimestre;
        this.notas = notas;
    }

    public int getId() {
        return id;
    }

    public int getTrimestre() {
        return trimestre;
    }
    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public Double getNotaRecuperacao() {
        return notaRecuperacao;
    }

    public void setNotaRecuperacao(Double notaRecuperacao) {
        this.notaRecuperacao = notaRecuperacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public double calcularMedia() {
        List<Double> notasConsideradas = new ArrayList<>(notas);
        if (notaRecuperacao != null) {
            double menorNota = notas.stream().min(Double::compareTo).orElse(0.0);
            if (menorNota < notaRecuperacao) {
                notasConsideradas.remove(menorNota);
                notasConsideradas.add(notaRecuperacao);
            }
        }
        return notasConsideradas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}