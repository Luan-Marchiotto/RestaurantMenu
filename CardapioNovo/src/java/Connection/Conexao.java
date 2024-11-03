package Connection;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {

    private static final String BD = "jdbc:mysql://localhost:3306/cardapio_bd";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public Connection estabeleceConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(BD,USUARIO, SENHA);
        } catch (ClassNotFoundException erro) {
            System.out.println("Erro na conexão: " + erro);
            return null;
        }
    }   
}
