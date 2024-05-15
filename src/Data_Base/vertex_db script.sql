



-- first: we create a new user of the server under the name Vertex Group
-- second: we give this user all privilleges
-- third: we create a new connection under the name Vertex Group System
-- fourth: we create a new database named vertex_db

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
    numeroproduit INT NOT NULL AUTO_INCREMENT,
    categorie_produit VARCHAR(500) NOT NULL,
    nom_produit VARCHAR(600) NOT NULL,
    quantite DOUBLE NOT NULL,
    prix DOUBLE NOT NULL,
    photo_1 LONGBLOB NULL,
    photo_2 LONGBLOB NULL,
    photo_3 LONGBLOB NULL,
    description_produit TEXT NOT NULL,
    fournisseur VARCHAR(100) NOT NULL,
    PRIMARY KEY (numeroproduit)
);




-- Table livraison

CREATE TABLE livraison (
    numerolivraison INT NOT NULL auto_increment,
    date_livraison DATE NOT NULL,
    prix_livraison DOUBLE NOT NULL,
    primary key (numerolivraison)
);







-- Table commande

CREATE TABLE commande (
    numerocommande INT NOT NULL AUTO_INCREMENT,
    date_commande DATE NOT NULL,
    etat_commande VARCHAR(20),
	numerolivraison INT NOT NULL,
	numeroclient INT NOT NULL,
    PRIMARY KEY (numerocommande),
    FOREIGN KEY (numeroclient) REFERENCES client(numeroclient),
    FOREIGN KEY (numerolivraison) REFERENCES livraison(numerolivraison)    
);


-- Table commande_produit

CREATE TABLE commande_produit (
    numerocommande INT NOT NULL,
    numeroproduit INT NOT NULL,
    quantite_commandee INT NOT NULL,
    PRIMARY KEY (numerocommande, numeroproduit),
    FOREIGN KEY (numerocommande) REFERENCES commande(numerocommande),
    FOREIGN KEY (numeroproduit) REFERENCES produit(numeroproduit)
);


-- Table Facture

CREATE TABLE Facture (
    numerofacture INT NOT NULL auto_increment,
    date_facture DATE NOT NULL,
    montant_total DOUBLE NOT NULL,
    numerocommande INT NOT NULL,
    primary key (numerofacture),
    FOREIGN KEY (numerocommande) REFERENCES commande(numerocommande)
);


-- Table message

CREATE TABLE message (
    numeromessage INT NOT NULL,
    date_message DATETIME NOT NULL,
    text_message TEXT NOT NULL,
    numeroclient INT NOT NULL,
    PRIMARY KEY (numeromessage),
    FOREIGN KEY (numeroclient) REFERENCES client(numeroclient)
    
);









