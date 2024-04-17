CREATE TABLE ALBUM (
    ID INT NOT NULL AUTO_INCREMENT,
    TITLE VARCHAR(200) NOT NULL,
    LAUNCH_YEAR INT(4) NOT NULL,
    IMAGE VARCHAR(200) NOT NULL,
    ARTIST_ID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (ARTIST_ID) REFERENCES ARTIST(ID)
) ENGINE=INNODB;
