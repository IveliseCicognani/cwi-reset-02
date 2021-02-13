package exercicio.um;

public class Diretor {

    private String nome;
    private int idade;
    private int quantidadeDeFilmes;


    public Diretor(String nome, int idade, int quantidadeDeFilmes) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeDeFilmes = quantidadeDeFilmes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getQuantidadeDeFilmes() {
        return quantidadeDeFilmes;
    }

    public void setQuantidadeDeFilmes(int quantidadeDeFilmes) {
        this.quantidadeDeFilmes = quantidadeDeFilmes;
    }
}
