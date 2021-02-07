package oo;

public class Aluno {

    private String nome;
    private double notaFinal;

    public String Aluno(String nome, double notaFinal){
        this.nome = nome;
        this.notaFinal = notaFinal;
        String resultado;

        resultado = (notaFinal>=7) ? "Aprovado":"Reprovado";

        return (resultado);
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public String getNome() {
        return nome;
    }
}
