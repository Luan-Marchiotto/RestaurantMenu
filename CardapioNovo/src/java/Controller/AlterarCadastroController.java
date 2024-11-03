package Controller;

import DAO.ProdutoDAO;
import VO.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarCadastroController", urlPatterns = {"/AlterarCadastroController"})
public class AlterarCadastroController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        long id_produto = Long.parseLong(request.getParameter("id_produto"));
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.buscarProdutoPorId(id_produto);
        request.setAttribute("produto", produto);
        request.getRequestDispatcher("alterar_produto.jsp").forward(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        
        long id_produto = Long.parseLong(request.getParameter("id_produto"));
        String nome_produto = request.getParameter("nome_produto");
        double preco_produto = Double.parseDouble(request.getParameter("preco_produto"));
        String descricao_produto = request.getParameter("descricao_produto");
        String categoria_produto = request.getParameter("categoria_produto");
        
       
        Produto produto = new Produto();
        produto.setId_produto(id_produto);
        produto.setNome_produto(nome_produto);
        produto.setPreco_produto(preco_produto);
        produto.setDescricao_produto(descricao_produto);
        produto.setCategoria_produto(categoria_produto);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        if (produtoDAO.alterarProduto(produto)) {
            response.sendRedirect("MostraProdutoController");
        } else {
           
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

