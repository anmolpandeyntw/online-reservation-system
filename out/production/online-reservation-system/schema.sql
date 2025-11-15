-- MySQL schema for Online Reservation System
CREATE DATABASE IF NOT EXISTS reservationdb;
USE reservationdb;

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS reservations (
  pnr INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  train_number VARCHAR(20),
  train_name VARCHAR(100),
  class_type VARCHAR(50),
  date_of_journey DATE,
  from_place VARCHAR(100),
  to_place VARCHAR(100),
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- sample user
INSERT INTO users (username, password) VALUES ('demo', 'demo123');
