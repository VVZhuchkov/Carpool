INSERT INTO auth_users (id, email, password, status) VALUES ("1", "vz@vz.com", "vz", "ACTIVE");
INSERT INTO roles (id, role) VALUES ("1", "SUPER_ADMINISTRATOR");
INSERT INTO auth_users_has_roles (auth_users_id, roles_id) VALUES ("1", "1");
