INSERT INTO city(name,county,countycode,latitude,longitude,state,zip,fk_country_id) VALUES('New York','New York County','NY',40.71455,-74.007118,'New York','10007',select id from country where name = 'United States');
INSERT INTO city(name,county,countycode,latitude,longitude,state,zip,fk_country_id) VALUES('Los Angeles','Los Angelets County','LA',40.71455,-70.007118,'Los Angeles','XXXXX',select id from country where name = 'United States');
INSERT INTO city(name,county,countycode,latitude,longitude,state,zip,fk_country_id) VALUES('Lyon','XXXX','XX',40.71455,-70.007118,'Lyon','XXXXX',select id from country where name = 'France');
INSERT INTO city(name,county,countycode,latitude,longitude,state,zip,fk_country_id) VALUES('Dunkerque','XXXX','XX',40.71455,-70.007118,'Lyon','XXXXX',select id from country where name = 'France');