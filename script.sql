CREATE TABLE TBL_USERS
(
    ID              integer CONSTRAINT pk_id PRIMARY KEY,
    NAME            varchar(30) NOT NULL,
    PASSWORD        varchar(40) NOT NULL
)