<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
    <link rel="stylesheet" type="text/css" href="cadastro.css">
</head>
<body>
    
   
    <h2>Cadastrar Conta:</h2>
    
    <form action="ClienteController" method="POST">
        <label for="nomecli">Nome:</label>
        <input type="text" id="nomecli" name="nomecli" required><br><br>

        <label for="enderecocli">Endereço:</label>
        <input type="text" id="enderecocli" name="enderecocli" required><br><br>

        <label for="telefonecli">Telefone:</label>
        <input type="tel" id="telefonecli" name="telefonecli" pattern="[0-9]{2} [0-9]{5}-[0-9]{4}" placeholder="11 99999-9999" minlength="13" maxlength="14" required><br><br>
        
        <label for="emailcli">E-mail:</label>
        <input type="email" id="emailcli" name="emailcli" required><br><br>
        
        <label for="senhacli">Senha:</label>
        <input type="password" id="senhacli" name="senhacli" required><br><br>
        
        <button type="submit">Criar Conta</button>
    </form>

    
</body>
</html>
