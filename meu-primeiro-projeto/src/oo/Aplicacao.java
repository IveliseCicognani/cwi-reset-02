package oo;

public class Aplicacao {
    public static void main(String[] args) {
    Calculadora calc = new Calculadora();
    Comparador comparador = new Comparador();
    Aluno aluno = new Aluno();

    int resultadoSoma = calc.soma(1,2);
        System.out.println(resultadoSoma);

    int resultadoSubtracao = calc.subtrai(3,5);
        System.out.println(resultadoSubtracao);

    int resultadoMultiplicacao = calc.multiplica(3,4);
        System.out.println(resultadoMultiplicacao);

    int resultadoDivisao = calc.divide(4,2);
        System.out.println(resultadoDivisao);

    boolean resultadoComparacao = comparador.menorQue(7,10);
        System.out.println(resultadoComparacao);

    String resultadoAluno = aluno.Aluno("Ivelise",7);
        System.out.println("O aluno(a) "+aluno.getNome() + " está "+resultadoAluno +" com a nota final "+ aluno.getNotaFinal() +".");
    }

}
