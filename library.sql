CREATE DATABASE library;
USE library;
CREATE TABLE books (
    isbn BIGINT,
    title VARCHAR(80) NOT NULL,
    author VARCHAR(60) NOT NULL,
    stock INT,
    PRIMARY KEY(isbn)
);
INSERT INTO books VALUES(9780195312010,"The Pope's Daughter","Dr. Caroline P. Murphy",5);
INSERT INTO books VALUES(9780195314397,"Murder Of A Medici Princess","Dr. Caroline P. Murphy",2);
INSERT INTO books VALUES(9780300099133,"Lavinia Fontana","Dr. Caroline P. Murphy",5);
INSERT INTO books VALUES(9780099554899,"The Divorce of Henry VIII","Catherine Fletcher",3);
INSERT INTO books VALUES(9780563537472,"A History of Britain","Simon Scharma",5);
INSERT INTO books VALUES(9780563493334,"The Nazis: A Warning From History","Laurence Rees",10);
INSERT INTO books VALUES(9780582350342,"History of the British Economy","Brian Murphy",7);
INSERT INTO books VALUES(9780006863519,"The Prospect Before Her: History of Women in the West","Olwen Hufton",3);
INSERT INTO books VALUES(9780801492082,"Europe : Privilege and Protest,","Olwen Hufton",4);
INSERT INTO books VALUES(9780199554904,"Autobiography and Other Writings","Benjamin Franklin",12);
COMMIT;
CREATE TABLE users (
    user_id INT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    contact_number VARCHAR(20) NOT NULL,
    address_1 VARCHAR(30),
    address_2 VARCHAR(30),
    county VARCHAR(15),
    postcode VARCHAR(10),
    PRIMARY KEY (user_id)
);
INSERT INTO users VALUES(10593,"Boris","Johnson","020 7 534 2000","10 Downing Street","Westminster","London","SW1A 2AA");
INSERT INTO users VALUES(10366,"Nigel","Adams","020 7 547 4760","1 Hyde Park Square","Marble Arch","London","W2 1PB");
INSERT INTO users VALUES(10774,"Nadine","Dorries","020 7 624 0912","52 Cheyne Walk","Chelsea","London","SW3 5LR");
INSERT INTO users VALUES(10622,"Alexander","Lebedev","020 7 347 2770","102 Eaton Square","Belgravia","London","SW1W 9AN");
INSERT INTO users VALUES(10859,"Rishi","Sunak","020 7 675 8166","45 Park Lane","Mayfair","London","W1K 1PN");
INSERT INTO users VALUES(10822,"Kit","Malthouse","020 7 371 3309","85 Albert Embankment","Kennington","London","SE1 7TP");
INSERT INTO users VALUES(10811,"Theresa","May","020 7 466 6390","131 Electric Avenue","Brixton","London","SW19 6EP");
INSERT INTO users VALUES(10937,"Norman","Tebbit","020 7 273 6368","18 Chareston Street","Pimlico","London","W2 7WE");
INSERT INTO users VALUES(10523,"Liz","Truss","020 7 286 3366","22 Credibilty Street","Stoke Newington","London","W16 5GF");
INSERT INTO users VALUES(10619,"Jacob","Rees-Mogg","020 7 568 8348","44 Rusholme Avenue","Victoria","London","NW4 3DE");
COMMIT;
CREATE TABLE loaned (
    b_id BIGINT,
    u_id INT,
    FOREIGN KEY (b_id) REFERENCES books(isbn),
    FOREIGN KEY (u_id) REFERENCES users(user_id),
    date_lent DATE,
    due_date DATE
);
INSERT INTO loaned VALUES(9780099554899,10774,"22-07-12","22-07-23");
INSERT INTO loaned VALUES(9780199554904,10859,"22-07-11","22-07-22");
INSERT INTO loaned VALUES(9780563493334,10593,"22-06-25","22-07-04");
INSERT INTO loaned VALUES(9780195314397,10622,"22-07-10","22-07-19");
INSERT INTO loaned VALUES(9780582350342,10619,"22-07-13","22-07-21");
COMMIT;