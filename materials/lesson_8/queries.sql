CREATE TABLE IF NOT EXISTS user
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name varchar(20) NOT NULL
    );

CREATE TABLE IF NOT EXISTS todo
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        varchar(100) NOT NULL,
    description varchar(255),
    user_id     BIGINT       NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id)
    );

ALTER TABLE todo MODIFY user_id BIGINT;


INSERT INTO user(name) VALUES ('Ruslan');
INSERT INTO user(name) VALUES ('Viktor');
INSERT INTO user(name) VALUES ('Dmitry');
INSERT INTO user(name) VALUES ('Vasilij');

SELECT * FROM user;

INSERT INTO todo (name, description)  VALUES ('First Todo', 'Without user id');

SELECT * FROM todo;


INSERT INTO todo (name, description)  VALUES ('Second Todo', 'Without user id');
INSERT INTO todo (name, description)  VALUES ('Third Todo', 'Without user id');


INSERT INTO todo (name, description, user_id)  VALUES ('Fourth Todo', 'With user id', 1);
INSERT INTO todo (name, description, user_id)  VALUES ('Fifth Todo', 'With user id', 2);
INSERT INTO todo (name, description, user_id)  VALUES ('Learn SQL', 'Introduction to SQL', 2);

SELECT * FROM todo;

SELECT * FROM todo LEFT JOIN user u on u.id = todo.user_id;

SELECT * FROM todo RIGHT JOIN user u on u.id = todo.user_id WHERE todo.user_id IS NOT NULL;

SELECT * FROM user LEFT JOIN todo t on user.id = t.user_id WHERE t.user_id IS NOT NULL;

SELECT * FROM user LEFT JOIN todo t on user.id = t.user_id
UNION
SELECT * FROM todo RIGHT JOIN user u on todo.user_id = u.id;


SELECT u.name, t.name FROM user u LEFT JOIN todo t on u.id = t.user_id;
