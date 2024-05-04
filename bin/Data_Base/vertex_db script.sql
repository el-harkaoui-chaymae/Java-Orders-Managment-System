-- first: we create a new user of the server under the name Vertex Group
-- second: we give this user all privilleges
-- third: we create a new connection under the name Vertex Group System
-- fourth: we create a new data base named vertex_db

CREATE DATABASE vertex_db;

use vertex_db;

-- Table client

CREATE TABLE client (
    
    numeroclient INT NOT NULL auto_increment,
	prenom VARCHAR(50) NOT NULL,
    nom VARCHAR(50) NOT NULL,
    ville VARCHAR(50) NOT NULL,
    adresse VARCHAR(200) NOT NULL,
    telephone VARCHAR(12) NOT NULL,
    mail VARCHAR(100) NOT NULL,
    mot_de_passe VARCHAR(50) NOT NULL,
    date_de_naissance Date NULL,
    genre VARCHAR(20) NULL,
    nationalite VARCHAR(50) NULL,
    niveau_education VARCHAR(100) NULL,
    revenu_faible DOUBLE NULL,
    revenu_eleve DOUBLE NULL,
    PRIMARY KEY (numeroclient)

);



-- Table produit

CREATE TABLE produit (
    numeroproduit INT NOT NULL auto_increment,
    nomproduit VARCHAR(100) NOT NULL,
    quantite INT NOT NULL,
	prix DOUBLE NOT NULL,
    primary key (numeroproduit)
);


-- Table commande

CREATE TABLE commande (
    numerocommande INT NOT NULL AUTO_INCREMENT,
    date_commande DATE NOT NULL, 
	numeroclient INT NOT NULL,
    numeroproduit INT NOT NULL,
    PRIMARY KEY (numerocommande),
    FOREIGN KEY (numeroclient) REFERENCES client(numeroclient),
    FOREIGN KEY (numeroproduit) REFERENCES produit(numeroproduit)    
);



-- Table livraison

CREATE TABLE livraison (
    numerolivraison INT NOT NULL auto_increment,
    datelivraison DATE NOT NULL,
    prix_livraison DOUBLE NOT NULL,
    numerocommande INT NOT NULL,
    primary key (numerolivraison),
    FOREIGN KEY (numerocommande) REFERENCES commande(numerocommande)
    
    
);


-- Table Facture

CREATE TABLE Facture (
    numerofacture INT NOT NULL auto_increment,
    datefacture DATE NOT NULL,
    montant_total DOUBLE NOT NULL,
    numerocommande INT NOT NULL,
    primary key (numerofacture),
    FOREIGN KEY (numerocommande) REFERENCES commande(numerocommande)
    
);












