INSERT INTO Person(lastname,firstname,FK_COUNTRY1_ID,birthdate,height) values ('Ntilikina','Frank',select id from country where name = 'United States',TO_DATE('1998/07/28 00:00:00', 'yyyy/mm/dd hh24:mi:ss'),193);
INSERT INTO Person(lastname,firstname,FK_COUNTRY1_ID,birthdate,height) values ('Morris','Marcus',select id from country where name = 'United States',TO_DATE('1998/07/28 00:00:00', 'yyyy/mm/dd hh24:mi:ss'),193);
INSERT INTO Person(lastname,firstname,FK_COUNTRY1_ID,birthdate,height) values ('Harkless ','Maurice',select id from country where name = 'United States',TO_DATE('1998/07/28 00:00:00', 'yyyy/mm/dd hh24:mi:ss'),193);