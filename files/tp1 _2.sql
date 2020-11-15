
CREATE TABLE FORMATIONS(
NomFormation varchar(50) CONSTRAINT PK_NomFormation PRIMARY KEY,
Description varchar(50),
Duree int NOT NULL,
Prix float NOT NULL);
Prix float);

CREATE TABLE CANDIDAT(
CIN_candidat int CONSTRAINT PK_CIN PRIMARY KEY,
NomCandidat varchar(15),
prenomCandidat varchar(15),
DateN date,
Niveau varchar(15),
Nationnalite varchar(20));

CREATE TABLE SESSIONS(
IdSession varchar (30) CONSTRAINT PK_Id PRIMARY KEY,
DateDebutSession date,
NomFormateur varchar (30),
NomFormation varchar(50) CONSTRAINT FK_N REFERENCES FORMATIONS(NomFormation));	
 
CREATE TABLE PARTICIPATIONS(
idCandidat int CONSTRAINT FK_idC REFERENCES CANDIDAT(CIN_candidat),
IdSession varchar (30) CONSTRAINT FK_idS REFERENCES SESSIONS(idSession));

ALTER TABLE SESSIONS 
ADD Lieu varchar(15) DEFAULT 'ORADIST' NOT NULL;


Alter table FORMATIONS add constraint nom_de UNIQUE
(Description);

ALTER TABLE CANDIDAT ADD Constraint ck_n1 CHECK(Niveau IN('BAC+2','BAC+3','BAC+4','BAC+5')); 

ALTER TABLE FORMATIONS ADD Constraint ck_d1 CHECK(Duree between 2 AND 90);

 -- Supprimer les tables avec toutes les contraintes

DROP TABLE CANDIDAT cascade constraints;
DROP TABLE FORMATIONS cascade constraints;
DROP TABLE SESSIONS cascade constraints;
DROP TABLE PARTICIPATIONS cascade constraints;

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
