<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Inserir Produto</title>
    <link rel="stylesheet" type="text/css" href="addprato.css">
</head>
<body>
    <h2>Cadastrar Produto</h2>

    <form action="CadastroProdutoController" method="POST">
        <label for="nome_produto">Nome do Produto:</label>
        <input type="text" id="nome_produto" name="nome_produto" required><br><br>

        <label for="descricao_produto">Descrição:</label><br>
        <textarea id="descricao_produto" name="descricao_produto" rows="4" cols="50"></textarea><br><br>

        <label for="categoria_produto">Categoria:</label>
        <select id="categoria_produto" name="categoria_produto" required>
            <option value="">Selecione a categoria</option>
            <option value="Entrada">Entrada</option>
            <option value="Prato Principal">Prato Principal</option>
            <option value="Sobremesa">Sobremesa</option>
        </select><br><br>

        <label for="preco_produto">Preço:</label>
        <input type="text" id="preco_produto" name="preco_produto" pattern="[0-9]+(\.[0-9]{1,2})?" placeholder="0.00" required><br><br>

        <button type="submit">Cadastrar Produto</button>

        <!-- Botão "Voltar" -->
        <button type="button" onclick="window.history.back()">Voltar</button>
    </form>
</body>
</html>
