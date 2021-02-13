package exercicio.um;

public class Ator {

    private String nome;
    private int idade;
    private int numeroOscarsVencidos;
    private Genero genero;

    public Ator(String nome, int idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public void imprimir(){
        System.out.println("Nome: "+ nome);
        System.out.println("Idade: "+ idade);
        System.out.println("Gênero: "+ genero.getDescricao());
    }

}
