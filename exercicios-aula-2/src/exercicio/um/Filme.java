package exercicio.um;

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

}
