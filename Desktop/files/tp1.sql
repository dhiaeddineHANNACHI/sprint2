
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

-- Ajouter les conditions suivantes **************************

ALTER TABLE SESSIONS 
ADD Lieu varchar(15) DEFAULT 'ORADIST' NOT NULL;


Alter table FORMATIONS add constraint nom_de UNIQUE
(Description);

ALTER TABLE CANDIDAT ADD Constraint ck_n1 CHECK(Niveau IN('BAC+2','BAC+3','BAC+4','BAC+5')); 

ALTER TABLE FORMATIONS ADD Constraint ck_d1 CHECK(Duree between 2 AND 90);

