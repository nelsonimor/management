INSERT INTO continent (id, name, code) VALUES (1, 'Africa', 'AF');
INSERT INTO continent (id, name, code) VALUES (2, 'Asia', 'AS');
INSERT INTO continent (id, name, code) VALUES (3, 'Europe', 'EU');
INSERT INTO continent (id, name, code) VALUES (4, 'North America', 'NA');
INSERT INTO continent (id, name, code) VALUES (5, 'South America', 'SA');
INSERT INTO continent (id, name, code) VALUES (6, 'Oceania', 'OC');
INSERT INTO continent (id, name, code) VALUES (7, 'Antarctica', 'AN');

INSERT INTO country(name,codeiso2,codeiso3,nationality,fk_continent_id) VALUES ('United States','US','USA','American',select id from continent where name = 'North America');
INSERT INTO city(name,county,countycode,latitude,longitude,state,zip,fk_country_id) VALUES('New York','New York County','NY',40.71455,-74.007118,'New York','10007',select id from country where name = 'United States');
INSERT INTO league(name,type,fk_city_id) VALUES('NBA','Open',select id from city where name = 'New York');
INSERT INTO arena(name,capacity,yearcreation,fk_city_id) VALUES('Madison Square Garden',15000,1975,select id from city where name = 'New York');