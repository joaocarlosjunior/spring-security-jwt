CREATE TABLE TBL_USER(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    FIRSTNAME VARCHAR(20) NOT NULL,
    LASTNAME VARCHAR(20) NOT NULL,
    EMAIL VARCHAR(50) UNIQUE NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL,
    ROLE VARCHAR(20) NOT NULL
);