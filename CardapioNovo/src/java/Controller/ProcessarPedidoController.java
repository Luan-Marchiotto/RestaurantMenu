package Controller;

import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import VO.Pedido;
import VO.PedidoProduto;
import VO.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcessarPedidoController", urlPatterns = {"/ProcessarPedidoController"})
public class ProcessarPedidoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        PedidoDAO pedidoDAO = new PedidoDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        List<Produto> listaProdutos = produtoDAO.buscarProdutos();

        List<PedidoProduto> produtos = new ArrayList<>();
        double total = 0;

        for (Produto produto : listaProdutos) {
            String param = "quantidade_" + produto.getId_produto();
            int quantidade = Integer.parseInt(request.getParameter(param));
            if (quantidade > 0) {
                PedidoProduto pedidoProduto = new PedidoProduto();
                pedidoProduto.setId_produto(produto.getId_produto());
                pedidoProduto.setNome_produto(produto.getNome_produto()); 
                pedidoProduto.setQuantidade(quantidade);
                pedidoProduto.setPreco(produto.getPreco_produto());
                produtos.add(pedidoProduto);
                total += produto.getPreco_produto() * quantidade;
            }
        }

        Pedido pedido = new Pedido();
        pedido.setProdutos(produtos);
        pedido.setTotal(total);

        boolean success = pedidoDAO.salvarPedido(pedido);

        if (success) {
            response.sendRedirect("MostrarPedidoController?idPedido=" + pedido.getId_pedido());
        } else {
            response.sendRedirect("error.jsp");
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
