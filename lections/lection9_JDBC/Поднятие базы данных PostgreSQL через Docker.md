
#### **Настройка PostgreSQL в Docker**:

- **Команда для запуска контейнера**:
    
    ```bash
    docker run --name postgres-db -e POSTGRES_PASSWORD=secret -p 5432:5432 -d postgres
    ```
    
- **Разбор команды**:
    - `docker run`: запуск нового контейнера.
    - `--name postgres-db`: задаёт имя контейнера для удобства управления.
    - `-e POSTGRES_PASSWORD=secret`: установка пароля для пользователя `postgres`.
    - `-p 5432:5432`: проброс порта 5432 (по умолчанию для PostgreSQL) на хост-машину.
    - `-d postgres`: запуск контейнера в фоновом режиме с образом PostgreSQL.
- **Проверка, что контейнер работает**:
    
    ```bash
    docker ps
    ```
    
    - Убедитесь, что контейнер с именем `postgres-db` запущен.

---

#### **Проверка работы базы**:

- **Подключение к базе через `psql`**:
    
    1. Установите клиент `psql` (если он не установлен):
        
        - На Linux:
            
            ```bash
            sudo apt install postgresql-client
            ```
            
        - На macOS:
            
            ```bash
            brew install libpq
            ```
            
    2. Подключение к базе данных:
        
        ```bash
        psql -h localhost -p 5432 -U postgres
        ```
        
        - `-h localhost`: хост, где работает база.
        - `-p 5432`: порт базы данных.
        - `-U postgres`: пользователь для подключения.
    3. Введите пароль `secret`, указанный при создании контейнера.
        
- **Проверка подключения через SQL**:
    
    - Выполните команду:
        
        ```sql
        SELECT version();
        ```
        
    - Убедитесь, что PostgreSQL возвращает версию базы данных.

---

#### **Дополнительно**:

- **Логи контейнера**:
    
    - Посмотреть логи, чтобы убедиться, что PostgreSQL работает корректно:
        
        ```bash
        docker logs postgres-db
        ```
        
- **Остановка и запуск контейнера**:
    
    - Остановить контейнер:
        
        ```bash
        docker stop postgres-db
        ```
        
    - Запустить снова:
        
        ```bash
        docker start postgres-db
        ```
        
