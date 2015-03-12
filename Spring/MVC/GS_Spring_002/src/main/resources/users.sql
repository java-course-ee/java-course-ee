DROP DATABASE IF EXISTS users;
CREATE DATABASE users;


USE users;


CREATE TABLE `users` (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB;


INSERT INTO `users` (`userId`, `login`, `password`, `email`) VALUES
  (1, 'user1','user1','user1@mail.ru'),
  (2, 'user2','user2','user2@mail.ru'),
  (3, 'user3','user3','user3@mail.ru');

COMMIT;