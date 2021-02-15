public class Casa extends Imovel{

    private boolean patio;

    public Casa(Endereco endereco, double valor, boolean patio) {
        super(endereco, valor);
        this.patio = patio;
    }

    @Override
    public String apresentacao() {
        String possuiPatio = (patio) ? "com":"sem";

        return ("[CASA] "+possuiPatio+" pátio, localizada no endereço: "
                +super.getEndereco().getLogradouro()+", Nº: "
                +super.getEndereco().getNumero()+", Compl.: "
                +super.getEndereco().getComplemento()+", Bairro: "
                +super.getEndereco().getBairro()+", Cidade: "
                +super.getEndereco().getCidade()+", UF: "
                +super.getEndereco().getEstado().getDescricao()+". \n Valor: R$ " +super.getValor()+".");
    }
}
