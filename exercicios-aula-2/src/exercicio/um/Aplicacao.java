package exercicio.um;

import java.io.LineNumberInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args){

        LocalDate dataNascimento = LocalDate.of(1991, 12,24);
        LocalDate dataNascimentoDois = LocalDate.of(1964, 5,20);
        LocalDate dataNascimentoTres = LocalDate.of(1986, 7,14);
        LocalDate dataNascimentoQuatro = LocalDate.of(1973, 10,17);

        Diretor diretor = new Diretor("Ivelise Brum", dataNascimento,9, Genero.FEMININO);
        Ator ator = new Ator("Peter", dataNascimentoDois, Genero.MASCULINO, 2);
        Ator atorDois = new Ator("Carolina", dataNascimentoTres, Genero.FEMININO, 3);
        Ator atorTres = new Ator("Fabricio", dataNascimentoQuatro, Genero.MASCULINO, 7);

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
