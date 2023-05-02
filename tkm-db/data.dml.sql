DELETE FROM activities;

INSERT INTO activities
	(name, description, image_url, location, link_url, created_at)
	VALUES
	('Musee Alexandre Franconie', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit.', 
		'musee.png', 'Cayenne', 'https://musee.ctguyane.fr/ws/collections/app/report/index.html', now()
		),
	('Tigdilo Marais de Kaw', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit.', 
		'foret.png', 'Route de Macouria', 'https://tigdilo.fr/', now()
		),
	('Centre spatial guyanais', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit.', 
		'fusee.png', 'Route de Macouria', 'https://centrespatialguyanais.cnes.fr/fr/', now()
		);