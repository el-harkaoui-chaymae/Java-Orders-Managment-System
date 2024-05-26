
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



-- Table destination_Livraison

CREATE TABLE destination (
    numerodestination INT NOT NULL auto_increment,
    ville VARCHAR(100) NOT NULL,
    prix_livraison_estime DOUBLE NOT NULL,
    primary key (numerodestination),
    UNIQUE KEY unique_destination_price (ville, prix_livraison_estime)
);




-- Table livraison

CREATE TABLE livraison (
    numerolivraison INT NOT NULL AUTO_INCREMENT,
    numerodestination INT NOT NULL,
    numerocommande INT NOT NULL,
    PRIMARY KEY (numerolivraison),
    CONSTRAINT fk_lv_dn FOREIGN KEY (numerodestination) REFERENCES destination(numerodestination),
    CONSTRAINT fk_lv_commande FOREIGN KEY (numerocommande) REFERENCES commande(numerocommande)
    
    ON DELETE CASCADE
);







-- Table commande

CREATE TABLE commande (
    numerocommande INT NOT NULL AUTO_INCREMENT,
    date_commande DATE NOT NULL,
    temps_commande TIME NOT NULL,
    etat_commande VARCHAR(20) NOT NULL DEFAULT 'not shipped',
    numeroclient INT NOT NULL,
    PRIMARY KEY (numerocommande),
    CONSTRAINT fk_commande_client FOREIGN KEY (numeroclient) REFERENCES client(numeroclient)
    
    ON DELETE CASCADE

);




-- Table commande_produit

CREATE TABLE commande_produit (
    
    numerocommande INT NOT NULL,
    numeroproduit INT NOT NULL,
    quantite_commandee INT NOT NULL,
	PRIMARY KEY (numerocommande, numeroproduit),
	CONSTRAINT fk_cmp_numerocommande FOREIGN KEY (numerocommande) REFERENCES commande(numerocommande),
    CONSTRAINT fk_cmp_numeroproduit FOREIGN KEY (numeroproduit) REFERENCES produit(numeroproduit)
    
    ON DELETE CASCADE
);





-- Table Facture

CREATE TABLE Facture (
    numerofacture INT NOT NULL AUTO_INCREMENT,
    montant_total DOUBLE NOT NULL,
    numerocommande INT NOT NULL,
    PRIMARY KEY (numerofacture),
    CONSTRAINT fk_facture_numerocmd FOREIGN KEY (numerocommande) REFERENCES commande(numerocommande)
	
    ON DELETE CASCADE
);






-- Table message

CREATE TABLE message (
    numeromessage INT NOT NULL,
    date_message DATETIME NOT NULL,
    text_message TEXT NOT NULL,
    numeroclient INT NOT NULL,
    PRIMARY KEY (numeromessage),
	CONSTRAINT fk_message_client FOREIGN KEY (numeroclient) REFERENCES client(numeroclient)
    
    ON DELETE CASCADE
    
);



-- Table panier

CREATE TABLE panier (
    numeropanier INT NOT NULL AUTO_INCREMENT,
    numeroclient INT NOT NULL,
    numeroproduit INT NOT NULL,
    quantite_produit INT NOT NULL DEFAULT 1,
    PRIMARY KEY (numeropanier),
	CONSTRAINT fk_panier_client FOREIGN KEY (numeroclient) REFERENCES client(numeroclient),
	CONSTRAINT fk_panier_produit FOREIGN KEY (numeroproduit) REFERENCES produit(numeroproduit)

    ON DELETE CASCADE
);














