package VO;

public class PedidoProduto {
    private long id_pedido_produto;
    private long id_pedido;
    private long id_produto;
    private String nome_produto;  // Novo campo
    private int quantidade;
    private double preco;

    public long getId_pedido_produto() {
        return id_pedido_produto;
    }

    public void setId_pedido_produto(long id_pedido_produto) {
        this.id_pedido_produto = id_pedido_produto;
    }

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
