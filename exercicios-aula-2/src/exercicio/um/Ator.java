package exercicio.um;

import java.time.LocalDate;

public class Ator extends Pessoa{

    private int numeroOscarsVencidos;

    public Ator(String nome, LocalDate dataNasciento, Genero genero, int numeroOscarsVencidos) {
        super(nome, dataNasciento, genero);
        this.numeroOscarsVencidos = numeroOscarsVencidos;
    }

    public int getNumeroOscarsVencidos() {
        return numeroOscarsVencidos;
    }

        public void imprimir() {
            super.imprimir();
            System.out.println("Quantidade de Oscars Vencidos" + getNumeroOscarsVencidos());
        }
    }

