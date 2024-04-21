DROP TABLE IF EXISTS MUSEUS;

CREATE TABLE MUSEUS(
    ID int unsigned not null AUTO_INCREMENT,
    NOME varchar(100) unique not null,
    PAIS varchar(100) not null,
    PRIMARY KEY ( ID )
);


