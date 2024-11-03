<%-- 
    Document   : gerenciamento
    Created on : 18 de jun. de 2024, 13:10:20
    Author     : Gustavo Macedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Gerenciamento de Cardapio</title>
    <link rel="stylesheet" href="gerenciamento.css">
</head>
<body>
    <header>
        <h1>Gerenciamento de Cardapio</h1>
        <button class="logout-button" onclick="location.href='SairController';">Logout</button>
    </header>
    <main>
        <div class="content">
            <div class="message">
                <h2>Bem-vindo ao sistema de gerenciamento de Cardapio.</h2>
                <p>Use o menu abaixo para navegar pelo sistema.</p>
            </div>
            <nav>
                <ul>
                    <li><a href="addprato.jsp">Adicionar Prato</a></li>
                    <li><a href="MostraProdutoController">Listar Todos os Pratos</a></li>
                    
                </ul>
            </nav>
        </div>
    </main>
</body>
</html>
