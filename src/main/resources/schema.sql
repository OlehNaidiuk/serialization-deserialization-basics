CREATE TABLE shop
(
    shop_id             BIGINT NOT NULL AUTO_INCREMENT,
    address             VARCHAR(255) DEFAULT NULL,
    name                VARCHAR(255) DEFAULT NULL,
    number_of_employees INT          DEFAULT NULL,
    has_site            BIT          DEFAULT 0,
    PRIMARY KEY (shop_id)
);