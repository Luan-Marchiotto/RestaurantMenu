<%@page import="java.util.List"%>
<%@page import="VO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listagem</title>
    <link rel="stylesheet" type="text/css" href="listaprodutoscli.css">
</head>
<body>
    
<% 
    List<Produto> produtos = (List<Produto>) request.getAttribute("lista");
    if (produtos != null) {
        out.print("<h1>Conheça nossas opções:</h1><br><br><br>");
        out.print("<form action='ProcessarPedidoController' method='post'>");
        out.print("<table>");
        out.print("<tr>");
        out.print("<th>Nome do Produto</th>");
        out.print("<th>Descrição</th>");
        out.print("<th>Preço</th>");
        out.print("<th>Quantidade</th>");
        out.print("</tr>");
                    
        for (Produto p : produtos) {
            out.print("<tr>");
            out.print("<td>" + p.getNome_produto() + "</td>");
            out.print("<td>" + p.getDescricao_produto() + "</td>");
            out.print("<td>" + "R$ " + p.getPreco_produto() + "</td>");
            out.print("<td><input type='number' name='quantidade_" + p.getId_produto() + "' min='0' value='0'></td>");
            out.print("</tr>");
        }  
        
        out.print("</table>");
        out.print("<center><input type='submit' value='Enviar Pedido'></center>");
        out.print("</form>");
    } else {
        out.print("<p>Não há produtos disponíveis.</p>");
    }
%>

</body>
</html>
