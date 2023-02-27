
DROP TABLE IF EXISTS lesson.bread;

CREATE TABLE lesson.bread (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ;


INSERT INTO lesson.bread VALUES (1,'nut bread',3.2), (2,'white bread',2.4),(3,'multigrain bread',2.6), (4,'wholemeal bread',2.5);
