package exercicio.um;

public class Diretor {

    private String nome;
    private int idade;
    private int quantidadeDeFilmes;
    private Genero genero;


    public Diretor(String nome, int idade, int quantidadeDeFilmes, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeDeFilmes = quantidadeDeFilmes;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void imprimir() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Gênero: " + genero.getDescricao());
    }
}
