package exercicio.um;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args){

        Diretor diretor = new Diretor("Ivelise Brum",32,9, Genero.FEMININO);
        Ator ator = new Ator("Peter",40, Genero.MASCULINO, 2);
        Ator atorDois = new Ator("Carolina",24, Genero.FEMININO, 3);
        Ator atorTres = new Ator("Fabricio",54, Genero.MASCULINO, 7);

//        Filme primeiroFilme = new Filme("Gladiador","Descrição do filme",120,1988,diretor,4);
//        Filme segundoFilme = new Filme("O Clube da Luta","Descrição filme 2",160,1887,diretor,3);
//
//        primeiroFilme.reproduzirFilme();
//        segundoFilme.reproduzirFilme();
//
//        diretor.imprimir();
//        ator.imprimir();
        List<Pessoa> listaPessoas = new ArrayList<>();
        listaPessoas.add(diretor);
        listaPessoas.add(ator);
        listaPessoas.add(atorDois);
        listaPessoas.add(atorTres);
        Filme segundoFilme = new Filme("O Clube da Luta","Descrição filme 2",160,1887,diretor,3, listaPessoas);
        segundoFilme.exibirCreditos();
    }

}
