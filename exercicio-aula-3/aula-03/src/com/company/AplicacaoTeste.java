package com.company;

import com.company.domain.Filme;
import com.company.enumeradores.Genero;
import com.company.heranca.Diretor;

public class AplicacaoTeste {

    public static void main(String[] args) {

//        Editora editora1 = new Editora("DC Comics", "RS - BR");
//        System.out.println("Editora: " +editora1.getNome());
//
//        Editora editora2 = new Editora("New Editon", "RS - BR");
//        System.out.println("Editora: " +editora2.getNome());

        Diretor diretor = new Diretor("Ivelise", 24, 2, Genero.FEMININO);
        Filme filme = new Filme("Titanic", "Descrição do filme",160,1989,4,diretor);

        filme.reproduzir();


    }

}
