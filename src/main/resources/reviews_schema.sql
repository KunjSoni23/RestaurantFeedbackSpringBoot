CREATE TABLE review(id LONG PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), review VARCHAR(255),
		reviewDate DATE, reviewTime TIME);
INSERT INTO review(name, review, reviewDate, reviewTime) VALUES
	('Honest', 'Excellent', '2020-03-23', '12:03:03'),
	('NewAnmol', 'Good', '2020-05-09', '12:09:09'),
	('Sahyog', 'Perfect', '2020-10-11', '12:11:11');