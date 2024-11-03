package DAO;

import Connection.Conexao;
import VO.Cliente;
import java.sql.*;

public class ClienteDAO {
   
    public boolean salvarnobanco(Cliente cliente) {
        try {
            Connection con = new Conexao().estabeleceConexao();
            PreparedStatement ps;
            String sql = "INSERT INTO cliente (nome,endereco,email,telefone,senha) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getSenha());
            if (ps.executeUpdate() != 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }
        } catch (SQLException erro) {
            return false;
        }
        
        
    }
    
        
    public boolean verificarLogin(String email, String senha)  {
        
         boolean loginSucesso = false;
        try {
            Connection con = new Conexao().estabeleceConexao();
            PreparedStatement ps;
            ResultSet rs;
            String sql = "SELECT * FROM cliente WHERE email = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
            String senhaArmazenada = rs.getString("senha");
            if (senhaArmazenada.equals(senha)) {
                loginSucesso = true;
            }
        }
    } catch (SQLException erro) {
            return false;
        }
        return loginSucesso;
    }
}