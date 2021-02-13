package exercicio.um;

import java.sql.SQLOutput;

public class Filme {
    private String nome;
    private String descricao;
    private int duracao;
    private int anoDeLancamento;
    private double avaliacao;
    private Diretor diretor;


    public Filme(String nome, String descricao, int duracao, int anoDeLancamento, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        this.diretor = diretor;
    }

    public void reproduzirFilme(){
        System.out.println("Nome filme= " + this.nome);
        System.out.println("Descricao filme= " + this.descricao);
        System.out.println("Duração= " + this.duracao);
        System.out.println("Nome diretor= " + this.diretor.getNome());
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

}
