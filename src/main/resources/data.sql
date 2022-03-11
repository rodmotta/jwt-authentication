--777
INSERT INTO tb_user (username, password) VALUES ('rod', '$2a$10$c6AisePx1DPDCP5dqlJMl.tMlEdE.kSLGQ1Vhf3xxjWqkXw3A/D4S');
--123
INSERT INTO tb_user (username, password) VALUES ('dolly', '$2a$10$j5m09WdV2lsM7t4JZBnLXeVR1CT309N86nQ94ehyqZNq69XnZqSDC');

INSERT INTO tb_role (role) VALUES ('ROLE_USER');
INSERT INTO tb_role (role) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);