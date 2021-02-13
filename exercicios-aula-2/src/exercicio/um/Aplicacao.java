package exercicio.um;

public class Aplicacao {

    public static void main(String[] args){

        Diretor diretor = new Diretor("Ivelise Brum",32,9);

        Filme primeiroFilme = new Filme("Gladiador","Descrição do filme",120,1988,diretor);
        Filme segundoFilme = new Filme("Titanic","Descrição filme 2",160,1887,diretor);

        primeiroFilme.reproduzirFilme();
        segundoFilme.reproduzirFilme();
    }
}
