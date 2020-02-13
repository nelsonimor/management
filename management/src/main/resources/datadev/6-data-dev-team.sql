INSERT INTO team(name,fk_city1_id) VALUES('New York Knicks',select id from city where name = 'New York');
INSERT INTO team(name,fk_city1_id) VALUES('Brooklyn Nets',select id from city where name = 'New York');
INSERT INTO team(name,fk_city1_id) VALUES('Los Angeles Lakers',select id from city where name = 'Los Angeles');
INSERT INTO team(name,fk_city1_id) VALUES('Los Angeles Clippers',select id from city where name = 'Los Angeles');
INSERT INTO team(name,fk_city1_id) VALUES('ASVEL Lyon Villeurbanne',select id from city where name = 'Lyon');
INSERT INTO team(name,fk_city1_id) VALUES('BCM Gravelines Dunkerque',select id from city where name = 'Dunkerque');