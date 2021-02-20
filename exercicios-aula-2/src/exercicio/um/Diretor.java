package exercicio.um;

import java.time.LocalDate;

public class Diretor extends Pessoa{

    private int quantidadeDeFilmes;

    public Diretor(String nome, LocalDate dataNascimento, int quantidadeDeFilmes, Genero genero) {
        super(nome, dataNascimento, genero);
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
