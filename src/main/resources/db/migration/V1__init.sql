CREATE TABLE to_do_tasks (
                             id SERIAL PRIMARY KEY,
                             title VARCHAR(255) NOT NULL,
                             description TEXT,
                             completed BOOLEAN DEFAULT FALSE,
                             created_at TIMESTAMP,
                             updated_at TIMESTAMP,
                             deadline TIMESTAMP
);

INSERT INTO to_do_tasks (title, description, completed, created_at, updated_at, deadline)
VALUES
    ('Сделать приложение', 'Описание задачи 1', FALSE, current_timestamp, current_timestamp, '2023-11-15 21:20:51.804329'),
    ('Сделать фронт', 'Описание задачи 2', FALSE, current_timestamp, current_timestamp, '2023-12-01 14:30:00.000000'),
    ('Сделать бэк', 'Описание задачи 3', FALSE, current_timestamp, current_timestamp, '2023-12-31 23:59:59.999999');


CREATE TABLE notes (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       content TEXT,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP
);

INSERT INTO notes (title, content, created_at, updated_at)
VALUES
    ('Купить молока', 'Сходить в ближайший магазин, купить молока "Домик в деревне" 3.5%', current_timestamp, current_timestamp),
    ('Собрать пк Маркушу', 'Когда у Маркуша будет бабло собрать ему комп', current_timestamp, current_timestamp),
    ('Никита должен найти работу', 'Когда Никита закончит обучение, а лучше раньше, то он уже будет работать в разработке', current_timestamp, current_timestamp);
