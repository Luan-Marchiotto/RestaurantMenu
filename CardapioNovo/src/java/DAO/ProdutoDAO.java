package DAO;

import Connection.Conexao;
import VO.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public boolean salvarProduto(Produto produto) {
        try (Connection con = new Conexao().estabeleceConexao();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO produto (nome_produto, descricao_produto, categoria_produto, preco_produto) VALUES (?, ?, ?, ?)")) {

            ps.setString(1, produto.getNome_produto());
            ps.setString(2, produto.getDescricao_produto());
            ps.setString(3, produto.getCategoria_produto());
            ps.setDouble(4, produto.getPreco_produto());

            return ps.executeUpdate() > 0;
            
        } catch (SQLException erro) {
            System.err.println("Erro ao salvar produto: " + erro.getMessage());
            return false;
        }
    }

    public List<Produto> buscarProdutos() {
        List<Produto> lista = new ArrayList<>();
        
        try (Connection con = new Conexao().estabeleceConexao();
             PreparedStatement ps = con.prepareStatement("SELECT id_produto, nome_produto, descricao_produto, categoria_produto, preco_produto FROM produto");
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Produto p = new Produto();
                p.setId_produto(rs.getLong("id_produto"));
                p.setNome_produto(rs.getString("nome_produto"));
                p.setDescricao_produto(rs.getString("descricao_produto"));
                p.setCategoria_produto(rs.getString("categoria_produto"));
                p.setPreco_produto(rs.getDouble("preco_produto"));
                lista.add(p);
            }
            
        } catch (SQLException erro) {
            System.err.println("Erro ao buscar produtos: " + erro.getMessage());
        }
        
        return lista;
    }

    public boolean excluirProduto(Long id_produto) {
        try (Connection con = new Conexao().estabeleceConexao();
             PreparedStatement ps = con.prepareStatement("DELETE FROM produto WHERE id_produto = ?")) {

            ps.setLong(1, id_produto);

            return ps.executeUpdate() > 0;
            
        } catch (SQLException erro) {
            System.err.println("Erro ao excluir produto: " + erro.getMessage());
            return false;
        }
    }

    public Produto buscarProdutoPorId(long id_produto) {
        try (Connection con = new Conexao().estabeleceConexao();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM produto WHERE id_produto = ?")) {

            ps.setLong(1, id_produto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId_produto(rs.getLong("id_produto"));
                    produto.setNome_produto(rs.getString("nome_produto"));
                    produto.setDescricao_produto(rs.getString("descricao_produto"));
                    produto.setCategoria_produto(rs.getString("categoria_produto"));
                    produto.setPreco_produto(rs.getDouble("preco_produto"));
                    return produto;
                }
            }

        } catch (SQLException erro) {
            System.err.println("Erro ao buscar produto por ID: " + erro.getMessage());
        }
        
        return null;
    }

    public boolean alterarProduto(Produto produto) {
        try (Connection con = new Conexao().estabeleceConexao();
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE produto SET nome_produto = ?, descricao_produto = ?, categoria_produto = ?, preco_produto = ? WHERE id_produto = ?")) {

            ps.setString(1, produto.getNome_produto());
            ps.setString(2, produto.getDescricao_produto());
            ps.setString(3, produto.getCategoria_produto());
            ps.setDouble(4, produto.getPreco_produto());
            ps.setLong(5, produto.getId_produto());

            return ps.executeUpdate() > 0;
            
        } catch (SQLException erro) {
            System.err.println("Erro ao alterar produto: " + erro.getMessage());
            return false;
        }
    }
    
    
    
}