<%@page import="VO.PedidoProduto"%>
<%@page import="VO.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<!-- webapp/todosPedidos.jsp -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Todos os Pedidos</title>
    <link rel="stylesheet" type="text/css" href="listaprodutoscli.css">
</head>
<body>
    <h1>Todos os Pedidos</h1>
    <%
        List<Pedido> listaPedidos = (List<Pedido>) request.getAttribute("listaPedidos");
        if (listaPedidos != null && !listaPedidos.isEmpty()) {
            out.print("<table>");
            out.print(" <tr>");
            out.print("     <th>ID Pedido</th>");
            out.print("     <th>Nome dos Produtos</th>");
            out.print("     <th>Quantidade dos Produtos</th>");
            out.print("     <th>Valor Total</th>");
            out.print("     <th>Ações</th>");
            out.print(" </tr>");

            for (Pedido pedido : listaPedidos) {
                out.print("<tr>");
                out.print("<td>" + pedido.getId_pedido() + "</td>");

                out.print("<td>");
                for (PedidoProduto produto : pedido.getProdutos()) {
                    out.print(produto.getNome_produto() + "<br>");
                }
                out.print("</td>");

                out.print("<td>");
                for (PedidoProduto produto : pedido.getProdutos()) {
                    out.print(produto.getQuantidade() + "<br>");
                }
                out.print("</td>");

                out.print("<td>" + pedido.getTotal() + "</td>");

                out.print("<td>");
                out.print("<form action='ListarTodosPedidosController' method='post' style='display:inline;'>");
                out.print("<input type='hidden' name='idPedido' value='" + pedido.getId_pedido() + "'>");
                out.print("<input type='hidden' name='action' value='delete'>");
                out.print("<button type='submit'>Excluir</button>");
                out.print("</form>");
                out.print("</td>");

                out.print("</tr>");
            }
            out.print("</table>");
        } else {
            out.print("<p>Não há pedidos.</p>");
        }
    %>
    
    <center>  <a href="gerenciamentocliente.jsp"> Voltar </a> </center>
</body>
</html>
