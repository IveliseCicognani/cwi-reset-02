package exercicio.um;

public class Ator extends Pessoa{

    private int numeroOscarsVencidos;

    public Ator(String nome, int idade, Genero genero, int numeroOscarsVencidos) {
        super(nome, idade, genero);
        this.numeroOscarsVencidos = numeroOscarsVencidos;
    }

}
