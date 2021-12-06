-- movie_ticket_booking_system.booking definition

CREATE TABLE `booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `show_booking_id` int NOT NULL,
  `transaction_id` varchar(100) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `show_booking_id_fk` (`show_booking_id`),
  KEY `booking_user_id_fk` (`user_id`),
  CONSTRAINT `booking_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `show_booking_id_fk` FOREIGN KEY (`show_booking_id`) REFERENCES `show_booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- movie_ticket_booking_system.movie definition

CREATE TABLE `movie` (
  `movie_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `genre` varchar(500) NOT NULL,
  `director` varchar(100) DEFAULT NULL,
  `cast` varchar(100) DEFAULT NULL,
  `year` varchar(100) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- movie_ticket_booking_system.movie_show definition

CREATE TABLE `movie_show` (
  `id` int NOT NULL AUTO_INCREMENT,
  `show_time_id` int NOT NULL,
  `movie_id` int NOT NULL,
  `screen_id` int NOT NULL,
  `is_cancel` tinyint(1) NOT NULL,
  `show_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `movie_show_movie_id_fk` (`movie_id`),
  KEY `movie_show_screen_id_fk` (`screen_id`),
  KEY `movie_show_show_id_fk` (`show_time_id`),
  CONSTRAINT `movie_show_movie_id_fk` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  CONSTRAINT `movie_show_screen_id_fk` FOREIGN KEY (`screen_id`) REFERENCES `screen` (`screen_id`),
  CONSTRAINT `movie_show_show_id_fk` FOREIGN KEY (`show_time_id`) REFERENCES `show_time` (`show_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- movie_ticket_booking_system.place_lookup definition

CREATE TABLE `place_lookup` (
  `place_id` int NOT NULL AUTO_INCREMENT,
  `place_name` varchar(150) DEFAULT NULL,
  `place_parent_id` int DEFAULT NULL,
  `is_active` binary(1) DEFAULT NULL,
  PRIMARY KEY (`place_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- movie_ticket_booking_system.screen definition

CREATE TABLE `screen` (
  `screen_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `theater_id` int NOT NULL,
  `is_active` binary(1) NOT NULL,
  PRIMARY KEY (`screen_id`),
  KEY `screen_theater_id_fk` (`theater_id`),
  CONSTRAINT `screen_theater_id_fk` FOREIGN KEY (`theater_id`) REFERENCES `theater` (`theater_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- movie_ticket_booking_system.screen_row definition

CREATE TABLE `screen_row` (
  `row_id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(10) NOT NULL,
  `is_active` binary(1) NOT NULL,
  `screen_id` int NOT NULL,
  PRIMARY KEY (`row_id`),
  KEY `screen_screen_id_fk` (`screen_id`),
  CONSTRAINT `screen_screen_id_fk` FOREIGN KEY (`screen_id`) REFERENCES `screen` (`screen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- movie_ticket_booking_system.seat definition

CREATE TABLE `seat` (
  `seat_id` int NOT NULL AUTO_INCREMENT,
  `position` int NOT NULL,
  `screen_row_id` int NOT NULL,
  `is_active` binary(1) NOT NULL,
  PRIMARY KEY (`seat_id`),
  KEY `screen_row_screen_id_fk` (`screen_row_id`),
  CONSTRAINT `screen_row_screen_id_fk` FOREIGN KEY (`screen_row_id`) REFERENCES `screen_row` (`row_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- movie_ticket_booking_system.show_booking definition

CREATE TABLE `show_booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `seat_id` int NOT NULL,
  `movie_show_id` int NOT NULL,
  `movie_id` int NOT NULL,
  `show_time_id` int NOT NULL,
  `theater_id` int NOT NULL,
  `row_id` int NOT NULL,
  `screen_id` int NOT NULL,
  `is_booked` tinyint(1) NOT NULL DEFAULT '0',
  `version` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `show_booking_seat_id_fk` (`seat_id`),
  KEY `movie_show_id_fk` (`movie_show_id`),
  CONSTRAINT `movie_show_id_fk` FOREIGN KEY (`movie_show_id`) REFERENCES `movie_show` (`id`),
  CONSTRAINT `show_booking_seat_id_fk` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`seat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4098 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- movie_ticket_booking_system.show_time definition

CREATE TABLE `show_time` (
  `show_id` int NOT NULL AUTO_INCREMENT,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`show_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- movie_ticket_booking_system.theater definition

CREATE TABLE `theater` (
  `theater_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` text NOT NULL,
  `latitude` int DEFAULT NULL,
  `longitude` int DEFAULT NULL,
  `is_active` binary(1) NOT NULL,
  `place_id` int NOT NULL,
  PRIMARY KEY (`theater_id`),
  KEY `theater_place_id_fk` (`place_id`),
  CONSTRAINT `theater_place_id_fk` FOREIGN KEY (`place_id`) REFERENCES `place_lookup` (`place_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- movie_ticket_booking_system.`user` definition

CREATE TABLE `user` (
  `user_id` varchar(100) NOT NULL,
  `name` varchar(150) NOT NULL,
  `email_id` varchar(150) NOT NULL,
  `phone_number` int NOT NULL,
  `is_active` binary(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;