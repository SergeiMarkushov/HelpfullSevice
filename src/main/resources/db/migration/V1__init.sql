CREATE TABLE to_do_tasks (
       id                           BIGSERIAL PRIMARY KEY,
       title                        VARCHAR(255) NOT NULL,
       description                  TEXT,
       completed                    BOOLEAN DEFAULT FALSE,
       created_at                   TIMESTAMP,
       updated_at                   TIMESTAMP,
       deadline                     TIMESTAMP
);

CREATE TABLE notes (
        id                          BIGSERIAL PRIMARY KEY,
        title                       VARCHAR(255) NOT NULL,
        content                     TEXT,
        created_at                  TIMESTAMP DEFAULT current_timestamp,
        updated_at                  TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE users(
        id                          BIGSERIAL PRIMARY KEY,
        username                    VARCHAR(36) NOT NULL,
        password                    VARCHAR(255) NOT NULL,
        email                       VARCHAR(255),
        phone                       VARCHAR(255),
        created_at                  TIMESTAMP DEFAULT current_timestamp,
        updated_at                  TIMESTAMP DEFAULT current_timestamp

);

CREATE TABLE roles
(
        id                          BIGSERIAL PRIMARY KEY,
        name                        VARCHAR(50) NOT NULL
);

CREATE TABLE user_roles
(
        user_id                     BIGSERIAL NOT NULL REFERENCES users (id),
        role_id                     BIGSERIAL NOT NULL REFERENCES roles (id),
                    PRIMARY KEY (user_id, role_id)
);

INSERT INTO to_do_tasks (title, description, completed, created_at, updated_at, deadline)
VALUES
    ('Сделать приложение', 'Описание задачи 1', FALSE, current_timestamp, current_timestamp, '2023-11-15 21:20:51.804329'),
    ('Сделать фронт', 'Описание задачи 2', FALSE, current_timestamp, current_timestamp, '2023-12-01 14:30:00.000000'),
    ('Сделать бэк', 'Описание задачи 3', FALSE, current_timestamp, current_timestamp, '2023-12-31 23:59:59.999999');


INSERT INTO notes (title, content, created_at, updated_at)
VALUES
    ('Купить молока', 'Сходить в ближайший магазин, купить молока "Домик в деревне" 3.5%', current_timestamp, current_timestamp),
    ('Собрать пк Маркушу', 'Когда у Маркуша будет бабло собрать ему комп', current_timestamp, current_timestamp),
    ('Никита должен найти работу', 'Когда Никита закончит обучение, а лучше раньше, то он уже будет работать в разработке', current_timestamp, current_timestamp);

INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO users (username, password)
VALUES
    ('Nikita', '$2a$12$MrWimWTeTBz2HXycX97Sbu50VeXLb6MyNye3AtYBgKh4.2RQsDJna'),
    ('Serg', '$2a$12$MrWimWTeTBz2HXycX97Sbu50VeXLb6MyNye3AtYBgKh4.2RQsDJna'),
    ('Test User', '$2a$12$MrWimWTeTBz2HXycX97Sbu50VeXLb6MyNye3AtYBgKh4.2RQsDJna');

INSERT INTO user_roles (user_id, role_id)
VALUES
    (1,2),
    (2,2),
    (3,1);