package exercicio.um;

public class Filme {
    private String nome;
    private String descricao;
    private int duracao;
    private int anoDeLancamento;
    private double avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, int duracao, int anoDeLancamento, Diretor diretor, int avaliacao) {
        defineAvaliacao(avaliacao);
        validaNomeeDefineAvaliacao(nome);
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

    private void defineAvaliacao(int avaliacao){
        if(avaliacao < 1 || avaliacao > 5){
            this.avaliacao = 3;
        } else {
            this.avaliacao = avaliacao;
        }
    }

    private void validaNomeeDefineAvaliacao(String nome){
        if("O Clube da Luta".equals(nome)){
            avaliacao = 5;
        } else if("Batman vs Superman".equals(nome)){
            avaliacao = 1;
        }
    }

}
