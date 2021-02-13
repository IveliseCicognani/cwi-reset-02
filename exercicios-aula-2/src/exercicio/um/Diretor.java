package exercicio.um;

public class Diretor extends Pessoa{

    private int quantidadeDeFilmes;

    public Diretor(String nome, int idade, int quantidadeDeFilmes, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeDeFilmes = quantidadeDeFilmes;
    }
}
