package br.com.pinedev.saladeaula.modelo;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String telefone;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    // Construtores, getters e setters
    public Aluno() {}

    public Aluno(String nome, String telefone, Date dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Aluno(String nome, String telefone, String dataNascimento) {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
        avaliacao.setAluno(this);
    }

    public double calcularMediaGeral() {
        return avaliacoes.stream().mapToDouble(Avaliacao::calcularMedia).average().orElse(0.0);
    }

    public String determinarStatus() {
        double mediaGeral = calcularMediaGeral();
        if (mediaGeral >= 6.0) {
            return "Na média";
        } else {
            long avaliacoesAbaixoMedia = avaliacoes.stream().filter(a -> a.calcularMedia() < 6.0).count();
            if (avaliacoesAbaixoMedia > 0) {
                return "Em recuperação";
            } else {
                return "Reprovado";
            }
        }
    }
}