--Créer les 4 tables avec toutes contraintes d’intégrité ****************
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
