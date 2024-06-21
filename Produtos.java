public class Produtos {
    private int idProduto;
    private String NomeProduto;
    private float Preco;

    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public String getNomeProduto() {
        return NomeProduto;
    }
    public void setNomeProduto(String NomeProduto) {
        this.NomeProduto = NomeProduto;
    }
    public float getPreco() {
        return Preco;
    }
    public void setPreco(float Preco) {
        this.Preco = Preco;
    }
    
    public String relatorioProduto(){
        return "Id: " + getIdProduto() + " Nome: " + getNomeProduto() + " Preço: " + getPreco() + "\n" ;
    }
}