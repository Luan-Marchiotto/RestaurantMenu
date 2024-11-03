package Controller;

import DAO.ClienteDAO;
import VO.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        try (PrintWriter out = response.getWriter()) {
           Cliente cliente = new Cliente();
           cliente.setNome(request.getParameter("nomecli"));
           cliente.setEndereco(request.getParameter("enderecocli"));
           cliente.setEmail(request.getParameter("emailcli"));
           cliente.setTelefone(request.getParameter("telefonecli"));
           cliente.setSenha(request.getParameter("senhacli"));
           
           
            ClienteDAO clienteDAO = new ClienteDAO();
            if(clienteDAO.salvarnobanco(cliente)){
                response.sendRedirect("sucesso.jsp"); // Faz um redirecionamento de arquivo
            }else{
                response.sendRedirect("erro.jsp"); // Faz um redirecionamento de arquivo
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
