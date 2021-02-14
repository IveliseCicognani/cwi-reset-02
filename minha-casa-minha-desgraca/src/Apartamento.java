public class Apartamento extends Imovel{

    private int andar;

    public Apartamento(Endereco endereco, double valor, int andar) {
        super(endereco, valor);
        this.andar = andar;
    }

    @Override
    public String apresentacao() {
        return ("[APARTAMENTO] Localizado no endereço: "
                +super.getEndereco().getLogradouro()+", Nº: "
                +super.getEndereco().getNumero()+", Andar: "
                +andar+", Compl.: "
                +super.getEndereco().getComplemento()+", Bairro: "
                +super.getEndereco().getBairro()+", Cidade: "
                +super.getEndereco().getCidade()+", UF: "
                +super.getEndereco().getEstado().getDescricao()+".");
    }
}
