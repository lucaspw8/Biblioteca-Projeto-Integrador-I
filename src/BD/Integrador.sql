-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.21-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para integrador
CREATE DATABASE IF NOT EXISTS `integrador` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `integrador`;

-- Copiando estrutura para tabela integrador.curso
CREATE TABLE IF NOT EXISTS `curso` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `coordenador` varchar(50) DEFAULT NULL,
  `disciplina` tinyblob,
  PRIMARY KEY (`idCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela integrador.curso: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` (`idCurso`, `nome`, `coordenador`, `disciplina`) VALUES
	(7, 'Sistemas de Informação', 'Renato', NULL),
	(8, 'Mecatrônica', 'Rafael', NULL),
	(9, 'Fisica', 'Batman5', NULL),
	(10, 'Integrado Informatica', 'Elias', NULL);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;

-- Copiando estrutura para tabela integrador.disciplina
CREATE TABLE IF NOT EXISTS `disciplina` (
  `idDisciplina` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL DEFAULT '0',
  `semestre` varchar(3) NOT NULL,
  PRIMARY KEY (`idDisciplina`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela integrador.disciplina: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` (`idDisciplina`, `nome`, `semestre`) VALUES
	(1, 'WEB', '3º'),
	(2, 'Design e MultimideA', '1º'),
	(6, 'jubileu', '3º'),
	(7, 'pweb', '3º'),
	(12, 'Resistência dos materiais', '2º');
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;

-- Copiando estrutura para tabela integrador.livro
CREATE TABLE IF NOT EXISTS `livro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL DEFAULT '0',
  `autor` varchar(50) NOT NULL DEFAULT '0',
  `quantidade` int(11) DEFAULT '0',
  `disponivel` varchar(30) NOT NULL DEFAULT '0',
  `editora` varchar(30) NOT NULL DEFAULT '0',
  `ano` varchar(4) NOT NULL DEFAULT '2000',
  `edicao` varchar(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela integrador.livro: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `livro` DISABLE KEYS */;
INSERT INTO `livro` (`id`, `titulo`, `autor`, `quantidade`, `disponivel`, `editora`, `ano`, `edicao`) VALUES
	(4, 'JavaScript2', 'Sultãowqe', 24, 'Virtual', 'New Pop', '2017', '4'),
	(5, 'Calculo I', 'Jeffin', 23, 'Físico', 'Nova Era', '2008', '1');
/*!40000 ALTER TABLE `livro` ENABLE KEYS */;

-- Copiando estrutura para tabela integrador.rel_curso_disci
CREATE TABLE IF NOT EXISTS `rel_curso_disci` (
  `idCurso` int(11) DEFAULT NULL,
  `idDisciplina` int(11) DEFAULT NULL,
  KEY `FK_rel_curso_disci_curso` (`idCurso`),
  KEY `FK_rel_curso_disci_disciplina` (`idDisciplina`),
  CONSTRAINT `FK_rel_curso_disci_curso` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_rel_curso_disci_disciplina` FOREIGN KEY (`idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela integrador.rel_curso_disci: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `rel_curso_disci` DISABLE KEYS */;
INSERT INTO `rel_curso_disci` (`idCurso`, `idDisciplina`) VALUES
	(7, 2),
	(8, 6),
	(10, 12);
/*!40000 ALTER TABLE `rel_curso_disci` ENABLE KEYS */;

-- Copiando estrutura para tabela integrador.rel_livro_disci
CREATE TABLE IF NOT EXISTS `rel_livro_disci` (
  `idLivro` int(11) DEFAULT NULL,
  `idDisciplina` int(11) DEFAULT NULL,
  KEY `FK_rel_livro_disci_livro` (`idLivro`),
  KEY `FK_rel_livro_disci_disciplina` (`idDisciplina`),
  CONSTRAINT `FK_rel_livro_disci_disciplina` FOREIGN KEY (`idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_rel_livro_disci_livro` FOREIGN KEY (`idLivro`) REFERENCES `livro` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela integrador.rel_livro_disci: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `rel_livro_disci` DISABLE KEYS */;
INSERT INTO `rel_livro_disci` (`idLivro`, `idDisciplina`) VALUES
	(4, 6),
	(4, 12);
/*!40000 ALTER TABLE `rel_livro_disci` ENABLE KEYS */;

-- Copiando estrutura para tabela integrador.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) DEFAULT NULL,
  `senha` varchar(30) NOT NULL DEFAULT '0',
  `nome` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) DEFAULT '0',
  `cargo` varchar(30) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela integrador.usuario: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `login`, `senha`, `nome`, `email`, `cargo`) VALUES
	(1, 'lukas', '12345', 'Lucas Moura Miranda', 'lucas@gmail.com.br', 'Funcionario'),
	(4, 'jeff', '1234', 'Jefferson', 'jefferson@gmail.com', 'Gerente'),
	(5, 'junior', '1234', 'Júnior', 'junior@gmail.com', 'Gerente'),
	(7, 'root', 'root', 'root', 'junior@gmail.com', 'Funcionario');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
