package VO;
public class Produto {
    
    private long id_produto;
    private String nome_produto;
    private String descricao_produto;
    private String categoria_produto;
    private Double preco_produto;
    private int  quantidade;
    private Double valortotal;

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    public int  getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int  quantidade) {
        this.quantidade = quantidade;
    }
    

    public long getId_produto() {
        return id_produto;
    }

    public void setId_produto(long id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public String getCategoria_produto() {
        return categoria_produto;
    }

    public void setCategoria_produto(String categoria_produto) {
        this.categoria_produto = categoria_produto;
    }

    public Double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(Double preco_produto) {
        this.preco_produto = preco_produto;
    }
}
