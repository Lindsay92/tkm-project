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
	('Lindsay', 'Admin', 'lindsay.admin@tkm.com', '$2a$11$2vDTOYS1/qumqjYE8FToHuIgp4b5EEb.phj6B7UnPRZV1Q/klaSdK', (
		SELECT id from roles WHERE code_role = 'ROLE_ADMIN')		
	),
	('Kevin', 'Saint', 'kevin.user@user.com', '$2a$11$.oj7xFvTJAS1g65vAlTbG.0HE7GwI4K68OmKXTGZoBOj1rEAHZNri', (
		SELECT id from roles WHERE code_role = 'ROLE_USER')
	);

INSERT INTO activities
	(name, description, image_url, location, link_url, created_at)
	VALUES
	('Musee Alexandre Franconie', 'Le Musée Territorial, inauguré en 1901 sous le nom de Musée Local, est l’une des plus anciennes institutions culturelles de Guyane.', 
		'flower2.jpg', 'Cayenne', 'https://musee.ctguyane.fr/ws/collections/app/report/index.html', now()
		),
	('Tigdilo Marais de Kaw', 'TIGDILO vous propose des circuits de découverte accompagnés de guides Naturalistes passionnés et spécialisés.
		Durant un circuit unique en pirogue, au plus prêt de la nature, observons ensemble la faune et la flore peuplant cet environnement.', 
		'forest.jpg', 'Route de Macouria', 'https://tigdilo.fr/', now()
		),
	('Centre spatial guyanais', 'Inauguré en 1996, le musée de l’Espace du Centre spatial guyanais est devenu au fil de ses 26 années d’existence l’un des sites les plus visités de Guyane, et un outil incontournable dans le paysage pédagogique, culturel et touristique de notre région.', 
		'house.jpg', 'Route de Kourou', 'https://centrespatialguyanais.cnes.fr/fr/le-musee-fait-peau-neuve', now()
		);
		
INSERT INTO likes
	(activity_id, account_id)
	values
	((SELECT id FROM activities where id = 3), (SELECT id FROM accounts where id = 2))
	; 