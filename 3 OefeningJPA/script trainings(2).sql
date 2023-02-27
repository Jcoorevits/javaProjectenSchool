DROP TABLE if exists lesson.watchList;
CREATE TABLE lesson.watchList (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `movieId` int(32) NOT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO lesson.watchList (number,movieId) VALUES (1);
INSERT INTO lesson.watchList (number,movieId) VALUES (2);
INSERT INTO lesson.watchList (number,movieId) VALUES (3);
INSERT INTO lesson.watchList (number,movieId) VALUES (4);
INSERT INTO lesson.watchList (number,movieId) VALUES (5);
INSERT INTO lesson.watchList (number,movieId) VALUES (6);