SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id                    INT(11) NOT NULL AUTO_INCREMENT,
  title                 VARCHAR(50) NOT NULL,
  cost                  DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO products (title, cost)
VALUES
('Хлеб', 30), ('Молоко', 50), ('Паста', 40), ('Сливки', 90), ('Батон', 10), ('Кефир', 30), ('Сметана', 50),
('Творог', 100), ('Яйца', 50), ('Курица', 250), ('Ростбиф', 530), ('Голяшка', 670), ('Филе индейки', 580),
('Сок', 150), ('Морковь', 16), ('Салат', 45), ('Лук', 15), ('Кофе', 450), ('Чай', 320), ('Сыр', 450);