<%@page import="java.util.List"%>
<%@page import="VO.Pedido"%>
<%@page import="VO.PedidoProduto"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalhes do Pedido</title>
    <link rel="stylesheet" type="text/css" href="mostrarPedido.css">
</head>
<body>
    <h1>Detalhes do Pedido</h1>
    
    <% 
    Pedido pedido = (Pedido) request.getAttribute("pedido");
    
    if (pedido != null) {
        out.println("<h3>Pedido ID: " + pedido.getId_pedido() + "</h3>");
        out.println("<h3>Data do Pedido: " + pedido.getData_pedido() + "</h3>");
        
        
        out.println("<br>");
        
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>ID do Produto</th>");
        out.println("<th>Nome do Produto</th>");
        out.println("<th>Quantidade</th>");
        out.println("<th>Preço Unitário</th>");
        out.println("<th>Subtotal</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        
        List<PedidoProduto> produtos = pedido.getProdutos();
        for (PedidoProduto p : produtos) {
            out.println("<tr>");
            out.println("<td>" + p.getId_produto() + "</td>");
            out.println("<td>" + p.getNome_produto() + "</td>");
            out.println("<td>" + p.getQuantidade() + "</td>");
            out.println("<td>R$ " + p.getPreco() + "</td>");
            out.println("<td>R$ " + (p.getQuantidade() * p.getPreco()) + "</td>");
            out.println("</tr>");
        }
        
        out.println("</tbody>");
        out.println("</table>");
        out.println("<h2>Total do Pedido: R$ " + pedido.getTotal() + "</h2>");
    } else {
        out.println("<p>Não foi possível encontrar informações do pedido.</p>");
    }
    %>
    
<center>  <a href="gerenciamentocliente.jsp"> Voltar </a> </center>
</body>
</html>
