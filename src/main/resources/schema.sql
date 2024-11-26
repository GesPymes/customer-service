
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CUSTOMER` (
  `customer_id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `address` VARCHAR(355) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `mobile_phone` VARCHAR(20) NOT NULL,
  `needs_invoice` INT NOT NULL,
  PRIMARY KEY (`customer_id`));

