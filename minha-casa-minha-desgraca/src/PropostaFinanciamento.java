public class PropostaFinanciamento {

    private Beneficiario beneficiario;
    private Imovel imovel;
    private int prazoPagamento;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovel, int prazoPagamento) {
        this.beneficiario = beneficiario;
        this.imovel = imovel;
        this.prazoPagamento = prazoPagamento;
    }


    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     *
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     *   for equivalente a pelo menos 50% do valor do imóvel.
     *
     *   Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     *      o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */
    public void validarProposta() {

        if(UnidadeFederativa.SP.equals(imovel.getEndereco().getEstado())) {
            if ((beneficiario.getSalario() * prazoPagamento) >= (imovel.getValor() * 0.65)) {
                imprimirPropostaAprovada();
            } else {
                imprimirPropostaNegada();
            }
        }
        else if (UnidadeFederativa.RJ.equals(imovel.getEndereco().getEstado())){
            if ((beneficiario.getSalario() * prazoPagamento) >= (imovel.getValor() * 0.60)){
                imprimirPropostaAprovada();
            }else{
                imprimirPropostaNegada();
            }
        }
        else{
            if((beneficiario.getSalario() * prazoPagamento) >= (imovel.getValor() * 0.50)){
                imprimirPropostaAprovada();
            }else{
                imprimirPropostaNegada();
            }

        }
    }

    private void imprimirPropostaAprovada(){
        System.out.println("Nome do beneficiário: "+ beneficiario.getNome());
        System.out.println("Imóvel: " +imovel.apresentacao());
        System.out.println("Prazo: " +prazoPagamento + " meses.");
        System.out.println("--------------STATUS PROPOSTA---------------------");
        System.out.println("Parabéns, sua proposta foi APROVADA.");
    }

    private void imprimirPropostaNegada(){
        System.out.println("Nome do beneficiário: "+ beneficiario.getNome());
        System.out.println("Imóvel: "+imovel.apresentacao());
        System.out.println("Prazo: " + prazoPagamento + " meses.");
        System.out.println("--------------STATUS PROPOSTA---------------------");
        System.out.println("Infelizmente sua proposta foi NEGADA.");
    }
}
