INSERT INTO user (id, created_at, updated_at, activation_code, avg_rating,
                  email, first_name, last_name, password, role, status)
                  VALUES ('1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null, '0.0','articzander@mail.ru',
                          'Artemiy','Stankevich','$2y$12$oUUoNABrprQhHNeReEjBG.OXzG.ohFAW30jLpY7xQULZLmKSIxa22',
                          'ADMIN',true);