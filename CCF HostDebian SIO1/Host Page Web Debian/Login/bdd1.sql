CREATE TABLE JOUEURS
(
   ID_JOUEUR INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fk_id_pays int,
    fk_ID_EQUIPE INT ,
   NOM_JOUEUR varchar(40),
   PRENOM_JOUEUR VARCHAR(40),
   date_naissance date ,
    salaire int
  )
;
						
						
INSERT INTO JOUEURS (NOM_JOUEUR,PRENOM_JOUEUR,date_naissance, salaire,fk_ID_EQUIPE,fk_ID_PAYS) VALUES 
('NAVAS','KEYLOR','1987-03-12',600, 1,8),
('MARQUINHOS','','1996-07-08',600,1,2),
('MESSI','Léo','1987-06-24',2000,1,3),
('NEYMAR','Junior','1994-11-08',2300,1,2),
('MBAPPE','Kylian','2001-02-25',5000,1,4),
('UMTITI','Samuel','1996-08-14',200,2,4),
('RAKITIC','Ivan','1989-03-23',400,2,9),
('VARANE','Raphael','1995-01-24',1000,3,4),
('MARCELO','','1990-05-01',300,3,2),
('BENZEMA','Karim','1990-07-14',1900,3,4),
('PAYET','Dimitri','1989-09-12',100,4,4),
('ROLANDO','Jorge','1987-10-11',60,4,7),
('SARR','Bouna','1994-04-23',50,4,4),
('RADONJIC','Nemanja','1998-11-24',60,4,6),
('LOPES','Anthony','1990-12-11',30,5,7),
('NEUER','Manuel', '1986-03-27',40,6,11),
('COMAN','Kingsley','1996-06-13',120,6,4),
('MULLER','Thomas', '1989-09-13',900,6,11)
;

					
CREATE TABLE EQUIPES
(
   ID_EQUIPE INT NOT NULL PRIMARY KEY ,
    fk_ID_PAYS INT,
   NOM_EQUIPE varchar(40),
    nom_stade varchar(40),
    capacite_stade INT
)
;
					
INSERT INTO EQUIPES (id_equipe, nom_equipe, fk_id_pays, nom_stade, capacite_stade) VALUES 
(1,'Paris Saint Germain',4,'Parc des princes', 45000),
(2,'FC Barcelone',5, 'Camp Nou', 99000),
(3,'Real Madrid',5, 'Santiago Bernabeu', 90000),
(4,'Olympique de Marseille',4, 'Stade Vélodrome', 67000),
(5,'Olympique Lyonnais',4,'Gerland',35000),
(6,'Bayern Munich',11, 'Allianz Arena',75000)
;


CREATE TABLE PAYS
(
    ID_PAYS INT NOT NULL PRIMARY KEY,
    NOM_PAYS VARCHAR(30),
    ID_CONTINENT INT
 );
 
 INSERT INTO PAYS VALUES 
 (1,'Italie',1),
 (2,'Bresil',2),
 (3,'Argentine',2),
 (4, 'France',1),
 (5, 'Espagne',1),
 (6,'Serbie',1),
 (7,'Portugal',1),
 (8,'Costa Rica',2),
 (9,'Croatie',1),
 (10,'Pays Bas',1),
 (11,'Allemagne',1)
 ;
 
 CREATE TABLE CONTINENT
(
    ID_CONTINENT INT NOT NULL PRIMARY KEY,
    NOM_CONTINENT VARCHAR(30)
 );
 
 INSERT INTO CONTINENT VALUES 
 (1,'Europe'),
 (2,'Amerique du Sud')
 ;
 
 CREATE TABLE MATCHES
(
    ID_MATCH INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FK_ID_EQUIPE_LOCAL INT,
    FK_ID_EQUIPE_VISITE INT,
    DATE_MATCH DATE,
    SCORE_EQUIPE_LOCAL INT,
    SCORE_EQUIPE_VISITE INT
)
;

INSERT INTO MATCHES (FK_ID_EQUIPE_LOCAL, FK_ID_EQUIPE_VISITE, DATE_MATCH, SCORE_EQUIPE_LOCAL, SCORE_EQUIPE_VISITE)
VALUES
    (1 , 2,  '2019-05-02', 5, 2),
    (2 , 1,  '2019-05-16', 3, 4 ),
    (1 , 3,  '2019-04-05', 2, 2),
    (3 , 1,  '2019-04-19', 1, 3),
    (1 , 4,  '2019-03-27', 3, 0),
    (2 , 3,  '2019-05-11', 1, 1),  
    (3 , 2,  '2019-05-18', 2, 1) 
;

CREATE TABLE ENTRAINEUR
(
   ID_ENTRAINEUR INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fk_id_pays int,
    fk_ID_EQUIPE INT ,
   NOM_ENTRAINEUR varchar(40),
   PRENOM_ENTRAINEUR VARCHAR(40)
  )
;

INSERT INTO ENTRAINEUR(fk_id_pays,fk_ID_EQUIPE, NOM_ENTRAINEUR ,   PRENOM_ENTRAINEUR) VALUES 
(4,1,'Galtier', 'Christophe'),
(1,3,'Ancelotti','Carlo'),
(10,2,'Koeman','Ronald') ,
(3,4,'Sampaoli', 'Jorge'),
(4,5,'Garcia', 'Rudi'),
(11,6,'Flick', 'Hans')
;obi