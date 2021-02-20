package exercicio.um;

public class Diretor extends Pessoa{

    private int quantidadeDeFilmes;

    public Diretor(String nome, int idade, int quantidadeDeFilmes, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeDeFilmes = quantidadeDeFilmes;
    }

    public int getQuantidadeDeFilmes() {
        return quantidadeDeFilmes;
    }
    public void imprimir(){
        super.imprimir();
        System.out.println("Quantidade de filmes" + getQuantidadeDeFilmes());
    }
}
