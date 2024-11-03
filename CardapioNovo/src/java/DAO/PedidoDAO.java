package DAO;

import Connection.Conexao;
import VO.Pedido;
import VO.PedidoProduto;
import VO.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoDAO {

    public boolean salvarPedido(Pedido pedido) {
        Connection con = null;
        PreparedStatement psPedido = null;
        PreparedStatement psPedidoProduto = null;
        ResultSet rs = null;
        try {
            con = new Conexao().estabeleceConexao();
            

            psPedido = con.prepareStatement("INSERT INTO pedido (total) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS); 
            psPedido.setDouble(1, pedido.getTotal());
            psPedido.executeUpdate();

            rs = psPedido.getGeneratedKeys();
            if (rs.next()) {
                pedido.setId_pedido(rs.getLong(1));
            }

            psPedidoProduto = con.prepareStatement("INSERT INTO pedido_produto (id_pedido, id_produto, quantidade, preco) VALUES (?, ?, ?, ?)");
            for (PedidoProduto pp : pedido.getProdutos()) {
                psPedidoProduto.setLong(1, pedido.getId_pedido());
                psPedidoProduto.setLong(2, pp.getId_produto());
                psPedidoProduto.setInt(3, pp.getQuantidade());
                psPedidoProduto.setDouble(4, pp.getPreco());
                psPedidoProduto.executeUpdate();
            }

            
            return true;
        } catch (SQLException e) {
            
            return false;
        } 
    }
    
    public List<Pedido> buscarTodosPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        try (Connection con = new Conexao().estabeleceConexao();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM pedido")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setId_pedido(rs.getLong("id_pedido"));
                    pedido.setData_pedido(rs.getTimestamp("data_pedido"));
                    pedido.setTotal(rs.getDouble("total"));

                    PreparedStatement psProdutos = con.prepareStatement(
                            "SELECT pp.*, pr.nome_produto " +
                            "FROM pedido_produto pp " +
                            "JOIN produto pr ON pp.id_produto = pr.id_produto " +
                            "WHERE pp.id_pedido = ?");
                    psProdutos.setLong(1, pedido.getId_pedido());
                    ResultSet rsProdutos = psProdutos.executeQuery();

                    List<PedidoProduto> produtos = new ArrayList<>();
                    while (rsProdutos.next()) {
                        PedidoProduto pp = new PedidoProduto();
                        pp.setId_pedido_produto(rsProdutos.getLong("id_pedido_produto"));
                        pp.setId_pedido(rsProdutos.getLong("id_pedido"));
                        pp.setId_produto(rsProdutos.getLong("id_produto"));
                        pp.setNome_produto(rsProdutos.getString("nome_produto"));
                        pp.setQuantidade(rsProdutos.getInt("quantidade"));
                        pp.setPreco(rsProdutos.getDouble("preco"));
                        produtos.add(pp);
                    }
                    pedido.setProdutos(produtos);
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException e) {
            
        }
        return pedidos;
    }
    
    
    
    
    
    
    public Pedido buscarPedidoPorId(long id_pedido) {
        Pedido pedido = null;
        try (Connection con = new Conexao().estabeleceConexao();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM pedido WHERE id_pedido = ?")) {
            ps.setLong(1, id_pedido);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pedido = new Pedido();
                    pedido.setId_pedido(rs.getLong("id_pedido"));
                    pedido.setData_pedido(rs.getTimestamp("data_pedido"));
                    pedido.setTotal(rs.getDouble("total"));

                    PreparedStatement psProdutos = con.prepareStatement(
                            "SELECT pp.*, p.nome_produto " +
                            "FROM pedido_produto pp " +
                            "JOIN produto p ON pp.id_produto = p.id_produto " +
                            "WHERE pp.id_pedido = ?");
                    psProdutos.setLong(1, pedido.getId_pedido());
                    ResultSet rsProdutos = psProdutos.executeQuery();

                    List<PedidoProduto> produtos = new ArrayList<>();
                    while (rsProdutos.next()) {
                        PedidoProduto pp = new PedidoProduto();
                        pp.setId_pedido_produto(rsProdutos.getLong("id_pedido_produto"));
                        pp.setId_pedido(rsProdutos.getLong("id_pedido"));
                        pp.setId_produto(rsProdutos.getLong("id_produto"));
                        pp.setNome_produto(rsProdutos.getString("nome_produto"));  // Setando o nome do produto
                        pp.setQuantidade(rsProdutos.getInt("quantidade"));
                        pp.setPreco(rsProdutos.getDouble("preco"));
                        produtos.add(pp);
                    }
                    pedido.setProdutos(produtos);
                }
            }
        } catch (SQLException e) {
            
        }
        return pedido;
    }
    
    public boolean excluirPedido(long idPedido) {
        Connection con = null;
        PreparedStatement psPedido = null;
        PreparedStatement psPedidoProduto = null;
        try {
            con = new Conexao().estabeleceConexao();
            con.setAutoCommit(false);

            psPedidoProduto = con.prepareStatement("DELETE FROM pedido_produto WHERE id_pedido = ?");
            psPedidoProduto.setLong(1, idPedido);
            psPedidoProduto.executeUpdate();

            psPedido = con.prepareStatement("DELETE FROM pedido WHERE id_pedido = ?");
            psPedido.setLong(1, idPedido);
            psPedido.executeUpdate();

            con.commit();
            return true;
        } catch (SQLException e) {
            
            return false;
        } 
    }
    
}
