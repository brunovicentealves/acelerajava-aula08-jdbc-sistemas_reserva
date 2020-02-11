USE reserva;

-- MODALIDADE
CREATE TABLE `modalidade` (
  `id_modalidade` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id_modalidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- TIPO_PASSEIO
CREATE TABLE `tipo_passeio` (
  `id_tipo_passeio` int(11) NOT NULL AUTO_INCREMENT,
  `nome_passeio` varchar(45) NOT NULL,
  `descricao_passeio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_passeio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- GUIA
CREATE TABLE `guia` (
  `id_guia` int(11) NOT NULL AUTO_INCREMENT,
  `nome_guia` varchar(100) NOT NULL,
  `documento_guia` varchar(30) NOT NULL,
  `data_nascimento` datetime NOT NULL,
  `credencial` varchar(30) NOT NULL,
  `id_modalidade` int(11) DEFAULT NULL,
  `id_tipo_passeio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_guia`),
  KEY `FK_GUIA_MODALIDADE_idx` (`id_modalidade`),
  KEY `FK_GUIA_TIPO_PASSEIO_idx` (`id_tipo_passeio`),
  CONSTRAINT `FK_GUIA_MODALIDADE` FOREIGN KEY (`id_modalidade`) REFERENCES `modalidade` (`id_modalidade`),
  CONSTRAINT `FK_GUIA_TIPO_PASSEIO` FOREIGN KEY (`id_tipo_passeio`) REFERENCES `tipo_passeio` (`id_tipo_passeio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- PAIS
CREATE TABLE `pais` (
  `id_pais` int(11) NOT NULL AUTO_INCREMENT,
  `nome_pais` varchar(100) NOT NULL,
  PRIMARY KEY (`id_pais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ESTADO
CREATE TABLE `estado` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `nome_estado` varchar(100) NOT NULL,
  `id_pais` int(11) NOT NULL,
  PRIMARY KEY (`id_estado`),
  CONSTRAINT `FK_ESTADO_PAIS` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- CIDADE
CREATE TABLE `cidade` (
  `id_cidade` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cidade` varchar(100) NOT NULL,
  `id_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_cidade`),
  CONSTRAINT `FK_CIDADE_ESTADO` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- GUIA
CREATE TABLE `viajante` (
  `id_viajante` int(11) NOT NULL AUTO_INCREMENT,
  `nome_viajante` varchar(100) NOT NULL,
  `documento_viajante` varchar(30) NOT NULL,
  `data_nascimento` datetime NOT NULL,
  PRIMARY KEY (`id_viajante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- RESERVA
CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL AUTO_INCREMENT,
  `id_viajante` int(11) NOT NULL,
  `id_cidade` int(11) NOT NULL,
  `id_guia` int(11) NOT NULL,
  `data_horario` datetime NOT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `FK_RESERVA_CIDADE` (`id_cidade`),
  KEY `FK_RESERVA_VIAJANTE` (`id_viajante`),
  KEY `FK_RESERVA_GUIA` (`id_guia`),
  CONSTRAINT `FK_RESERVA_CIDADE` FOREIGN KEY (`id_cidade`) REFERENCES `cidade` (`id_cidade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_RESERVA_GUIA` FOREIGN KEY (`id_guia`) REFERENCES `guia` (`id_guia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_RESERVA_VIAJANTE` FOREIGN KEY (`id_viajante`) REFERENCES `viajante` (`id_viajante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- DROP FK'S
ALTER TABLE guia DROP FOREIGN KEY FK_GUIA_MODALIDADE;
ALTER TABLE guia DROP FOREIGN KEY FK_GUIA_TIPO_PASSEIO;

ALTER TABLE guia DROP COLUMN id_modalidade;
ALTER TABLE guia DROP COLUMN id_tipo_passeio;

-- GUIA_MODALIDADE
CREATE TABLE `guia_modalidade` (
  `id_guia_modalidade` int(11) NOT NULL AUTO_INCREMENT,
  `id_guia` int(11) NOT NULL,
  `id_modalidade` int(11) NOT NULL,
  PRIMARY KEY (`id_guia_modalidade`),
  KEY `FK_GUIA_MODALIDADE_GUIA` (`id_guia`),
  KEY `FK_GUIA_MODALIDADE_MODALIDADE` (`id_modalidade`),
  CONSTRAINT `FK_GUIA_MODALIDADE_GUIA` FOREIGN KEY (`id_guia`) REFERENCES `guia` (`id_guia`),
  CONSTRAINT `FK_GUIA_MODALIDADE_MODALIDADE` FOREIGN KEY (`id_modalidade`) REFERENCES `modalidade` (`id_modalidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- GUIA_TIPO_PASSEIO
CREATE TABLE `guia_tipo_passeio` (
  `id_guia_tipo_passeio` int(11) NOT NULL AUTO_INCREMENT,
  `id_guia` int(11) NOT NULL,
  `id_tipo_passeio` int(11) NOT NULL,
  PRIMARY KEY (`id_guia_tipo_passeio`),
  KEY `FK_GUIA_TIPO_PASSEIO_GUIA` (`id_guia`),
  KEY `FK_GUIA_TIPO_PASSEIO_TIPO_PASSEIO` (`id_tipo_passeio`),
  CONSTRAINT `FK_GUIA_TIPO_PASSEIO_GUIA` FOREIGN KEY (`id_guia`) REFERENCES `guia` (`id_guia`),
  CONSTRAINT `FK_GUIA_TIPO_PASSEIO_TIPO_PASSEIO` FOREIGN KEY (`id_tipo_passeio`) REFERENCES `tipo_passeio` (`id_tipo_passeio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

