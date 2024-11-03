-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 19/06/2024 às 22:25
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `cardapio_bd`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `senha` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nome`, `endereco`, `email`, `telefone`, `senha`) VALUES
(1, 'Gustavo', 'Benjamin Constant', 'teste@teste.com', '11 99870-1507', '123'),
(3, 'Gustavo 2', 'Benjamin Constant', 'teste2@teste.com', '11 99870-1507', '12345'),
(5, 'teste', 'teste', 'teste3@teste.com.br', '14 99860-1507', '123'),
(7, 'Conta teste', 'Benjamin Constant 1690', 'emailteste@teste.com', '14 99860-1507', '1234');

-- --------------------------------------------------------

--
-- Estrutura para tabela `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` bigint(20) NOT NULL,
  `data_pedido` timestamp NOT NULL DEFAULT current_timestamp(),
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `pedido`
--

INSERT INTO `pedido` (`id_pedido`, `data_pedido`, `total`) VALUES
(1, '2024-06-19 20:07:03', 1000),
(3, '2024-06-19 20:10:43', 70.57),
(4, '2024-06-19 20:13:29', 25.4),
(5, '2024-06-19 20:13:51', 13.5),
(6, '2024-06-19 20:14:19', 28.3),
(7, '2024-06-19 20:15:18', 71.61),
(8, '2024-06-19 20:15:24', 205.49),
(10, '2024-06-19 20:22:52', 12.9),
(11, '2024-06-19 20:23:03', 46.8);

-- --------------------------------------------------------

--
-- Estrutura para tabela `pedido_produto`
--

CREATE TABLE `pedido_produto` (
  `id_pedido_produto` bigint(20) NOT NULL,
  `id_pedido` bigint(20) DEFAULT NULL,
  `id_produto` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `preco` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `pedido_produto`
--

INSERT INTO `pedido_produto` (`id_pedido_produto`, `id_pedido`, `id_produto`, `quantidade`, `preco`) VALUES
(1, 1, 13, 1, 1000),
(5, 3, 1, 1, 12.9),
(6, 3, 7, 2, 10.5),
(7, 3, 8, 1, 12.8),
(8, 3, 11, 1, 23.87),
(9, 4, 1, 1, 12.9),
(10, 4, 7, 1, 10.5),
(11, 5, 7, 3, 10.5),
(12, 6, 7, 2, 10.5),
(13, 6, 8, 3, 12.8),
(14, 7, 9, 3, 23.87),
(15, 8, 8, 3, 12.8),
(16, 8, 9, 3, 23.87),
(17, 8, 11, 4, 23.87),
(18, 10, 1, 1, 12.9),
(19, 11, 1, 2, 12.9),
(20, 11, 7, 2, 10.5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL,
  `nome_produto` varchar(100) NOT NULL,
  `descricao_produto` text DEFAULT NULL,
  `categoria_produto` varchar(50) DEFAULT NULL,
  `preco_produto` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `nome_produto`, `descricao_produto`, `categoria_produto`, `preco_produto`) VALUES
(1, 'Macarrão', 'Muito bom, compre!', 'Entrada', 12.90),
(7, 'Pastelão do bom', 'Um pastel show de bola', 'Prato Principal', 10.50),
(8, 'Pastelão do bom 2', 'Esse é mais show ainda', 'Sobremesa', 12.80),
(9, 'Macarrão Água e oleo', 'Macarronada topzera', 'Prato Principal', 23.87),
(11, 'broa', 'broa da boa top', 'Sobremesa', 23.87),
(13, 'Produto teste', 'Teste', 'Prato Principal', 1000.00);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Índices de tabela `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`);

--
-- Índices de tabela `pedido_produto`
--
ALTER TABLE `pedido_produto`
  ADD PRIMARY KEY (`id_pedido_produto`),
  ADD KEY `id_pedido` (`id_pedido`),
  ADD KEY `id_produto` (`id_produto`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `pedido_produto`
--
ALTER TABLE `pedido_produto`
  MODIFY `id_pedido_produto` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `pedido_produto`
--
ALTER TABLE `pedido_produto`
  ADD CONSTRAINT `pedido_produto_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`),
  ADD CONSTRAINT `pedido_produto_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
