DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS auction;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS seller_review;
DROP TABLE IF EXISTS seller_auction;
DROP TABLE IF EXISTS seller;

CREATE TABLE IF NOT EXISTS category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS auction (
    id INT NOT NULL UNIQUE AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    initial_price DECIMAL(6, 2) NOT NULL,
    current_price DECIMAL(6, 2),
    description VARCHAR(5000),
    end_time DATETIME NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE IF NOT EXISTS seller (
    seller_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS seller_auction (
    seller_id INT,
    auction_id INT
);

CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    enabled INT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS authorities (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS seller_review (
    id INT NOT NULL AUTO_INCREMENT,
    rate INT NOT NULL,
    comment VARCHAR(150),
    seller_id INT,
    reviewer_id INT,
    CONSTRAINT FK_seller_id FOREIGN KEY (seller_id) REFERENCES seller(seller_id),
    PRIMARY KEY(id)
);

