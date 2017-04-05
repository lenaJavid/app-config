DROP TABLE IF EXISTS configuration_tbl;
CREATE TABLE configuration_tbl(
    id BIGINT NOT NULL AUTO_INCREMENT,
    app_code VARCHAR(50)  NOT NULL ,
    version VARCHAR(50) NOT NULL ,
    config_doc TEXT,
    CREATED_DATE timestamp not null default now(),
    UPDATED_DATE timestamp not null default now(),
--     It could be JSON type if mysql is 5.7+

    PRIMARY KEY (id)
)