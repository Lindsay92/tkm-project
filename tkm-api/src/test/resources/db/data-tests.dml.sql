DELETE FROM activities;
DELETE FROM accounts;
DELETE FROM roles;
DELETE FROM likes;

INSERT INTO roles
	(code_role, role_name)
	VALUES
	('ROLE_ADMIN', 'Administrator'), ('ROLE_USER', 'User');

INSERT INTO accounts
	(first_name, last_name, email, password, role_id)
	VALUES
	('Lindsay', 'Admin', 'lindsay.admin@tkm.com', '$2a$11$2vDTOYS1/qumqjYE8FToHuIgp4b5EEb.phj6B7UnPRZV1Q/klaSdK', 1),
	('Jordan', 'User', 'jordan.user@user.com', '$2a$11$WIhNyotafQMyPE6DDtE/wO0VfKZGjc5DKxGZzUVzCOoOSgQeN9g7S', 2)
	;

INSERT INTO activities
	(name, description, image_url, location, link_url, created_at)
	VALUES
	('Musee Alexandre Franconie', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit.', 
		'flower2.jpg', 'Cayenne', 'https://musee.ctguyane.fr/ws/collections/app/report/index.html', now()
		),
	('Tigdilo Marais de Kaw', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit.', 
		'forest.jpg', 'Route de Macouria', 'https://tigdilo.fr/', now()
		),
	('Centre spatial guyanais', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit.', 
		'house.jpg', 'Route de Macouria', 'https://centrespatialguyanais.cnes.fr/fr/', now()
		);
		
INSERT INTO likes
	(activity_id, account_id)
	values
	((SELECT id FROM activities where id = 2), (SELECT id FROM accounts where id = 2)),
	((SELECT id FROM activities where id = 1), (SELECT id FROM accounts where id = 2)
	)
	;