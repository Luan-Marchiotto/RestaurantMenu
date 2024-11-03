<%-- 
    Document   : gerencia_produtos
    Created on : 18 de jun. de 2024, 13:16:30
    Author     : Gustavo Macedo
--%>


<%@page import="java.util.List"%>
<%@page import="VO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem</title>
        <link rel="stylesheet" type="text/css" href="gerencia_produtos.css">
    </head>
    <body>
    <% 
        List<Produto> produtos = (List<Produto>) request.getAttribute("lista");
        if (produtos != null ) {
   
                out.print("<h1>Lista de Produtos:</h1><br><br><br>");
                out.print("<table>");
                out.print(" <tr>");
                    out.print("     <th>ID</th>");
                    out.print("     <th>Nome do Produto</th>");
                    out.print("     <th>Descrição</th>");
                    out.print("     <th>Categoria</th>");
                    out.print("     <th>Preço</th>");
                    out.print("     <th>Ações</th>");
                    out.print(" </tr>");
                for (int cont = 0; cont < produtos.size(); cont++) {
                    Produto p = new Produto();
                    p = (Produto) produtos.get(cont);

                    out.print("<tr>");
                    out.print("<td>" + p.getId_produto() + "</td>");
                    out.print("<td>" + p.getNome_produto() + "</td>");
                    out.print("<td>" + p.getDescricao_produto() + "</td>");
                    out.print("<td>" + p.getCategoria_produto() + "</td>");
                    out.print("<td>" + "R$" + p.getPreco_produto() + "</td>"); 
                    out.print("<td><a href=\"ExcluiCadastroController?id_produto=" + p.getId_produto() + "\">Excluir</a>");
                    out.print("   |    <a href=\"AlterarCadastroController?id_produto=" + p.getId_produto() + "\">Alterar</a></td>");
                    
                    
                    
                    
                    out.print("</tr>");
                }
                out.print("</table>");
            }            
        %>
         <center>   <button type="button" onclick="window.history.back()">Voltar</button></center>
    </body>
</html>

