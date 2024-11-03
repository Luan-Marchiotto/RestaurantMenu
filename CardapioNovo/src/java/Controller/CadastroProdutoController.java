package Controller;

import DAO.ProdutoDAO;
import VO.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CadastroProdutoController", urlPatterns = {"/CadastroProdutoController"})
public class CadastroProdutoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try (PrintWriter out = response.getWriter()) {
           double preco = Double.parseDouble(request.getParameter("preco_produto"));
           Produto produto = new Produto();
           produto.setNome_produto(request.getParameter("nome_produto"));
           produto.setDescricao_produto(request.getParameter("descricao_produto"));
           produto.setCategoria_produto(request.getParameter("categoria_produto"));
           produto.setPreco_produto(preco);
           
           
           
            ProdutoDAO produtoDAO = new ProdutoDAO();
            if(produtoDAO.salvarProduto(produto)){
                response.sendRedirect("MostraProdutoController"); // Faz um redirecionamento de arquivo
            }else{
                response.sendRedirect("erro4.jsp"); // Faz um redirecionamento de arquivo
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
