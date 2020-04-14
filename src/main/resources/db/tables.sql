USE kit;

CREATE TABLE IF NOT EXISTS dna (
    idDna int AUTO_INCREMENT NOT NULL,
    dna varchar(255) NOT NULL,
    PRIMARY KEY(idDna)
);

CREATE TABLE IF NOT EXISTS patient (
    idPatient int AUTO_INCREMENT NOT NULL,
    name varchar(255) NOT NULL,
    phoneNumber varchar(255) NOT NULL,
    bloodType varchar(255) NOT NULL,
    nationality varchar(255) NOT NULL,
    doc varchar(255) NOT NULL,
    age int NOT NULL,
    idDna int NOT NULL,
    suspicious boolean,
    confirmed boolean,
    quarantine boolean,
    risk varchar(255),
    PRIMARY KEY(idPatient)
);