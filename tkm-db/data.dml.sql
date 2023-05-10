DELETE FROM activities;
DELETE FROM accounts;

INSERT INTO accounts
	(first_name, last_name, email, password)
	VALUES
	('Lindsay', 'user', 'user@simplon.com', 'test');

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