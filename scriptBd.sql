/*Crear esquema*/
CREATE SCHEMA `papers` DEFAULT CHARACTER SET utf8;
/*Crear usuario*/
CREATE USER 'papers_admin'@'localhost' IDENTIFIED BY 'P@pers5';
/*dar privilegios a un usuario desde root*/
GRANT ALL privileges ON papers.* TO 'papers_admin'@'localhost' with grant option;
/*refresh privilegios*/
flush privileges; 
/*Ver  lista de usuarios desde consola*/
select user,host from mysql.user; 
/*Ver privilegios de un usuario*/
show grants for 'papers_admin'@'localhost'; 

/*Categorias*/
CREATE TABLE `papers`.`bl_categories` (
  `id` SMALLINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Categories of items';

/*Proveedores*/
CREATE TABLE `papers`.`bl_providers` (
  `id` TINYINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `ruc` VARCHAR(30) NULL,
  `address` VARCHAR(255) NULL,
  `phone` VARCHAR(50) NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Providers of items';

/*Propietarios del articulo, dueños de los distintos negocios de articulos*/
CREATE TABLE `papers`.`bl_owners` (
  `id` TINYINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

/*Marcas de los articulos*/
CREATE TABLE `papers`.`bl_makes` (
  `id` SMALLINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '/*Makes of items*/';

/*Lista de articulos del Negocio*/
CREATE TABLE `papers`.`bl_items` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(250) NOT NULL,
  `make` SMALLINT NOT NULL,
  `serial` VARCHAR(45) NULL,
  `reference` VARCHAR(45) NULL,
  `category` SMALLINT NOT NULL,
  `stock` SMALLINT NOT NULL DEFAULT 0,
  `sale_price` FLOAT NOT NULL DEFAULT 0,
  `owner` TINYINT NOT NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

/*Tipos de atributos que pueden tener los articulos*/
CREATE TABLE `papers`.`bl_attribute_types` (
  `id` TINYINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'Attribute types of items';

/*Atributos de un articulo en caso de que se requiera adicionar caracteristicas*/
CREATE TABLE `papers`.`bl_item_attributes` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT,
  `item` MEDIUMINT NOT NULL,
  `attribute_type` TINYINT NOT NULL,
  `attribute_value` VARCHAR(100) NOT NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Attributes of an item if necessary';

/*Clientes del negocio, por defecto sera Consumidor final*/
CREATE TABLE `papers`.`bl_customers` (
  `id` SMALLINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `ci` VARCHAR(30) NULL,
  `address` VARCHAR(255) NULL,
  `phone` VARCHAR(50) NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

/*Facturas*/
CREATE TABLE `papers`.`bl_invoices` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT,
  `reference` MEDIUMINT NOT NULL COMMENT 'Number of invoice',
  `customer` SMALLINT NOT NULL,
  `sale_date` DATETIME NOT NULL,
  `net_value` FLOAT NOT NULL DEFAULT 0,
  `iva` FLOAT NOT NULL DEFAULT 0,
  `total_value` FLOAT NOT NULL DEFAULT 0,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

/*Detalles de las Facturas*/
CREATE TABLE `papers`.`bl_invoices_details` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT,
  `invoice` MEDIUMINT NOT NULL,
  `item` MEDIUMINT NOT NULL,
  `quantity` SMALLINT NOT NULL,
  `unit_value` FLOAT NOT NULL DEFAULT 0,
  `total_value` FLOAT NOT NULL DEFAULT 0
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

/*Ordenes de compra*/
CREATE TABLE `papers`.`bl_purchase_orders` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT,
  `reference` MEDIUMINT NULL,
  `provider` TINYINT NOT NULL,
  `purchase_date` DATE NOT NULL,
  `net_value` FLOAT NOT NULL DEFAULT 0,
  `iva` FLOAT NOT NULL DEFAULT 0,
  `ice` FLOAT NOT NULL DEFAULT 0,
  `total_value` FLOAT NOT NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

/*Detalles de Ordenes de compra*/
CREATE TABLE `papers`.`bl_purchase_orders_details` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT,
  `purchase_order` MEDIUMINT NOT NULL,
  `item` MEDIUMINT NOT NULL,
  `quantity` SMALLINT NOT NULL,
  `unit_value` FLOAT NOT NULL DEFAULT 0,
  `total_value` FLOAT NOT NULL DEFAULT 0
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

/*Usuarios*/
CREATE TABLE `papers`.`adm_users` (
  `id` SMALLINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `user` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `register_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Users';

/*Perfiles*/
CREATE TABLE `papers`.`adm_profiles` (
  `id` SMALLINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Profiles';

/*Opciones*/
CREATE TABLE `papers`.`adm_options` (
  `id` SMALLINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `page` VARCHAR(255),
  `top_option` SMALLINT(6),
  `order` TINYINT(4) NOT NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Options';

/*Opciones de perfiles*/
CREATE TABLE `papers`.`adm_profile_options` (
  `id` SMALLINT NOT NULL AUTO_INCREMENT,
  `profile` SMALLINT NOT NULL,
  `option` SMALLINT NOT NULL,
  `create` VARCHAR(1),
  `read` VARCHAR(1),
  `update` VARCHAR(1),
  `delete` VARCHAR(1),
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Profile Options';

/*Perfiles de Usuario*/
CREATE TABLE `papers`.`adm_user_profiles` (
  `id` SMALLINT NOT NULL AUTO_INCREMENT,
  `user` SMALLINT NOT NULL,
  `profile` SMALLINT NOT NULL,
  `state` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'User Profiles';

/*CREAR RELACIONES FORANEAS*/
/*Articulos*/
ALTER TABLE `papers`.`bl_items` 
ADD INDEX `fk_items_makes_idx` (`make` ASC),
ADD INDEX `fk_items_categories_idx` (`category` ASC),
ADD INDEX `fk_items_owner_idx` (`owner` ASC);
ALTER TABLE `papers`.`bl_items` 
ADD CONSTRAINT `fk_items_makes`
  FOREIGN KEY (`make`)
  REFERENCES `papers`.`bl_makes` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_items_categories`
  FOREIGN KEY (`category`)
  REFERENCES `papers`.`bl_categories` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_items_owner`
  FOREIGN KEY (`owner`)
  REFERENCES `papers`.`bl_owners` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

/*Atributos de Articulos*/*/  
 ALTER TABLE `papers`.`bl_item_attributes` 
ADD INDEX `fk_item_attributes_attribute_types_idx` (`attribute_type` ASC),
ADD INDEX `fk_item_attributes_items_idx` (`item` ASC);
ALTER TABLE `papers`.`bl_item_attributes` 
ADD CONSTRAINT `fk_item_attributes_attribute_types`
  FOREIGN KEY (`attribute_type`)
  REFERENCES `papers`.`bl_attribute_types` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_item_attributes_items`
  FOREIGN KEY (`item`)
  REFERENCES `papers`.`bl_items` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

/*Facturas*/  
ALTER TABLE `papers`.`bl_invoices` 
ADD INDEX `fk_invoices_customers_idx` (`customer` ASC);
ALTER TABLE `papers`.`bl_invoices` 
ADD CONSTRAINT `fk_invoices_customers`
  FOREIGN KEY (`customer`)
  REFERENCES `papers`.`bl_customers` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
 
/*Detalles de Facturas*/  
ALTER TABLE `papers`.`bl_invoices_details` 
ADD INDEX `fk_invoice_details_invoices_idx` (`invoice` ASC),
ADD INDEX `fk_invoice_details_items_idx` (`item` ASC);
ALTER TABLE `papers`.`bl_invoices_details` 
ADD CONSTRAINT `fk_invoice_details_invoices`
  FOREIGN KEY (`invoice`)
  REFERENCES `papers`.`bl_invoices` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_invoice_details_items`
  FOREIGN KEY (`item`)
  REFERENCES `papers`.`bl_items` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

 /*Ordenes de compra*/
ALTER TABLE `papers`.`bl_purchase_orders` 
ADD INDEX `fk_purchase_orders_providers_idx` (`provider` ASC);
ALTER TABLE `papers`.`bl_purchase_orders` 
ADD CONSTRAINT `fk_purchase_orders_providers`
  FOREIGN KEY (`provider`)
  REFERENCES `papers`.`bl_providers` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

/*Detalles de la orden de compra*/
 ALTER TABLE `papers`.`bl_purchase_orders_details` 
ADD INDEX `fk_purchase_orders_details_purchase_orders_idx` (`purchase_order` ASC),
ADD INDEX `fk_purchase_orders_details_items_idx` (`item` ASC);
ALTER TABLE `papers`.`bl_purchase_orders_details` 
ADD CONSTRAINT `fk_purchase_orders_details_purchase_orders`
  FOREIGN KEY (`purchase_order`)
  REFERENCES `papers`.`bl_purchase_orders` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_purchase_orders_details_items`
  FOREIGN KEY (`item`)
  REFERENCES `papers`.`bl_items` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

 /*Perfiles de Usuarios*/
ALTER TABLE `papers`.`adm_user_profiles` 
ADD INDEX `fk_user_profiles_users_idx` (`user` ASC),
ADD INDEX `fk_user_profiles_profiles_idx` (`profile` ASC);
ALTER TABLE `papers`.`adm_user_profiles` 
ADD CONSTRAINT `fk_user_profiles_profiles`
  FOREIGN KEY (`profile`)
  REFERENCES `papers`.`adm_profiles` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_user_profiles_users`
  FOREIGN KEY (`user`)
  REFERENCES `papers`.`adm_users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  /*Opciones de Perfiles*/
ALTER TABLE `papers`.`adm_profile_options` 
ADD INDEX `fk_profile_options_profile_idx` (`profile` ASC),
ADD INDEX `fk_profile_options_options_idx` (`option` ASC);
ALTER TABLE `papers`.`adm_profile_options` 
ADD CONSTRAINT `fk_profile_options_profiles`
  FOREIGN KEY (`profile`)
  REFERENCES `papers`.`adm_profiles` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_profile_options_options`
  FOREIGN KEY (`option`)
  REFERENCES `papers`.`adm_options` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  /*Opciones de Opciones*/
  ALTER TABLE `papers`.`adm_options` 
ADD INDEX `fk_options_options_idx` (`top_option` ASC);
ALTER TABLE `papers`.`adm_options` 
ADD CONSTRAINT `fk_options_options`
  FOREIGN KEY (`top_option`)
  REFERENCES `papers`.`adm_options` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;






