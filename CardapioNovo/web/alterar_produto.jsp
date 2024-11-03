<%-- 
    Document   : alterar_produto
    Created on : 18 de jun. de 2024, 16:18:27
    Author     : Gustavo Macedo
--%>

<%@page import="VO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Alterar Produto</title>
        <link rel="stylesheet" type="text/css" href="alterar_produto.css">
    </head>
    <body>
        <h1>Alterar Produto</h1>
        <%
            Produto produto = (Produto) request.getAttribute("produto");
            if (produto != null) {
        %>
        <form action="AlterarCadastroController" method="post">
            <input type="hidden" name="id_produto" value="<%= produto.getId_produto() %>">
            <label for="nome_produto">Nome do Produto:</label>
            <input type="text" id="nome_produto" name="nome_produto" value="<%= produto.getNome_produto() %>" required>
            <br>
            <label for="preco_produto">Preço do Produto:</label>
            <input type="number" step="0.01" id="preco_produto" name="preco_produto" value="<%= produto.getPreco_produto() %>" required>
            <br>
            <label for="descricao_produto">Descrição do Produto:</label>
            <textarea id="descricao_produto" name="descricao_produto" required><%= produto.getDescricao_produto() %></textarea>
            <br>
            <label for="categoria_produto">Categoria do Produto:</label>
        <select id="categoria_produto" name="categoria_produto" required>
            <option value="Prato Principal" <%= produto.getCategoria_produto().equals("Prato Principal") ? "selected" : "" %>>Prato Principal</option>
            <option value="Entrada" <%= produto.getCategoria_produto().equals("Entrada") ? "selected" : "" %>>Entrada</option>
            <option value="Sobremesa" <%= produto.getCategoria_produto().equals("Sobremesa") ? "selected" : "" %>>Sobremesa</option>
        </select>
            <br>
            <button type="submit">Salvar Alterações</button>
            <!-- Botão "Voltar" -->
        <button type="button" onclick="window.history.back()">Voltar</button>
        </form>
        <% 
            } else {
                out.println("<p>Produto não encontrado.</p>");
            }
        %>
        
        
        
    </body>
</html>

