<%-- 
    Document   : gerenciamentocliente
    Created on : 19 de jun. de 2024, 15:32:55
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
                <h2>Bem-vindo ao nosso sistema.</h2>
                <p>Use o menu abaixo para navegar pelo sistema.</p>
            </div>
            <nav>
                <ul>
                    <li><a href="MostraProdutoClienteController">Adicionar pedido</a></li>
                    <li><a href="ListarTodosPedidosController">Todos os Pedidos</a></li>
                    
                </ul>
            </nav>
        </div>
    </main>
</body>
</html>
