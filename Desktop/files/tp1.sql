INSERT INTO CANDIDAT VALUES(08935321,'Hamed', 'Ali','03/02/1982','BAC+3','Tunisien');

INSERT INTO CANDIDAT VALUES(11234567,'Bensalah',' Asma','','BAC+4','Tunisienne');

INSERT INTO CANDIDAT VALUES(11908723,'Naffeti',' Dorra','12/12/1980','BAC+5','Tunisienne');

INSERT INTO CANDIDAT VALUES(09712368,'Boushih',' Mohamed','14/09/1990','BAC+3','Etranger');

INSERT INTO formations VALUES ('PL/SQL','Les fondamentaux du langage PL/SQL',2,250);

INSERT INTO formations VALUES ('APEX-DEV','Developing Web application',3, 290);

INSERT INTO FORMATIONS VALUES('DB12C ADMIN I',' AdministrationWorkshop',5, 500);

INSERT INTO FORMATIONS VALUES('ADV-SQL', 'SQL Workshop II', 2 ,300);

INSERT INTO sessions VALUES ('Janvier2016-1','11/01/2016','Chokri ouniss','ADV-SQL');

INSERT INTO sessions VALUES ('Decembre2015-1',' 21/12/2015' ,'Chokri ouniss', 'ADV-SQL');

INSERT INTO sessions VALUES ('Septembre2015-1','14/09/2015','Faouzi fourati','PL/SQL');

INSERT INTO sessions VALUES ('Janvier2016-2 ','18/01/2015',' ','PL/SQL');

UPDATE formations
SET formations.duree = 7 where nomformation='APEX-DEV';
 
 
DELETE FROM sessions WHERE idsession='Janvier2016-2';
 
 
UPDATE  formations
  SET prix = prix +prix*15/100
  where nomformation='DB12C ADMIN I';
  
 
UPDATE  formations
  SET prix = prix +prix*15/100
  where nomformation='APEX-DEV';
  
  -- methode 2 
  UPDATE formations 
SET prix = prix+prix*0.15
WHERE UPPER(nomFormation) in
 ('DB12C ADMIN I', 'ADV-SQL');
