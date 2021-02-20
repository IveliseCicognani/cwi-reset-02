package exercicio.um;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public void imprimir(){

//        LocalDate date = LocalDate.now();
//        int idade = date.getYear() - dataNascimento.getYear();

        System.out.println("Nome: "+ nome);
        System.out.println("Idade: "+ Period.between(dataNascimento, LocalDate.now()).getYears());
        System.out.println("Gênero: "+ genero.getDescricao());
    }

    public String getNome() {
        return nome;
    }

}
