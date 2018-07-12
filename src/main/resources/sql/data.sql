-- Don't change the order these inserts

INSERT INTO Address (Street, Nr, Zip, City) VALUES ('Nationale straat', '5', '2000', 'Antwerpen');
INSERT INTO Address (Street, Nr, Zip, City) VALUES ('Spuibeekstraat', '4', '2800', 'Mechelen');
INSERT INTO Address (Street, Nr, Zip, City) VALUES ('Kazernedreef', '100', '2500', 'Lier');

INSERT INTO PERSON (ADDRESS_ID, FIRSTNAME, LASTNAME) VALUES (1, 'Clarence', 'Ho');
INSERT INTO PERSON (ADDRESS_ID, FIRSTNAME, LASTNAME) VALUES (2, 'Scott', 'Tiger');
INSERT INTO PERSON (ADDRESS_ID, FIRSTNAME, LASTNAME) VALUES (3, 'John', 'Smith');

INSERT INTO CART (CART_ID) VALUES (1);
INSERT INTO CART (CART_ID) VALUES (2);
INSERT INTO CART (CART_ID) VALUES (3);

INSERT INTO USERS (PERSON_ID, USERNAME, ENCRYPTED_PASSWORD)
VALUES (1, 'clarence.ho@gmail.com', '$2a$10$d8OaqZ47XHngjcn5.CXfleGOHNfSd80nJwPl1WBBeLC7R4Px/aLoy');
INSERT INTO USERS (PERSON_ID, USERNAME, ENCRYPTED_PASSWORD)
VALUES (2, 'scott.tiger@live.com', '$2a$10$GaPeuHGVAtxkksKyHCkQceOT5blhRfeGcmwoER8MeMeX8f65.uf0G');
INSERT INTO USERS (PERSON_ID, USERNAME, ENCRYPTED_PASSWORD)
VALUES (3, 'john.smith@live.com', '$2a$10$OtWajBubGGHRKO8FdCRIMOdG/pgvTszv7ZegTXdTWTd9uPf4Dqab6');

INSERT INTO ROLE (CART_ID, ROLE_TYPE, "USER_USER_ID") VALUES (1, 'ROLE_CLIENT', 1);
INSERT INTO ROLE (CART_ID, ROLE_TYPE, "USER_USER_ID") VALUES (2, 'ROLE_CLIENT', 2);
INSERT INTO ROLE (CART_ID, ROLE_TYPE, "USER_USER_ID") VALUES (3, 'ROLE_CLIENT', 3);

INSERT INTO PRODUCT (DESCRIPTION, PRICE, CATEGORY) VALUES ('Set weerstanden', 5.1, 'Weerstanden');
INSERT INTO PRODUCT (DESCRIPTION, PRICE, CATEGORY) VALUES ('Set condensatoren', 10.0, 'Componenten');
INSERT INTO PRODUCT (DESCRIPTION, PRICE, CATEGORY) VALUES ('Zenderdiode 12V 4A', 7.8, 'Componenten');
INSERT INTO PRODUCT (DESCRIPTION, PRICE, CATEGORY) VALUES ('Zenderdiode 14,4V 5A', 20.0, 'Componenten');
INSERT INTO PRODUCT (DESCRIPTION, PRICE, CATEGORY) VALUES ('Ronde ferrietmagneet 10 mm', 10.0, 'Magneten');
INSERT INTO PRODUCT (DESCRIPTION, PRICE, CATEGORY) VALUES ('Ronde ferrietmagneet 20 mm', 4.4, 'Magneten');
INSERT INTO PRODUCT (DESCRIPTION, PRICE, CATEGORY) VALUES ('Ronde ferrietmagneet 50 mm', 5.7, 'Magneten');
INSERT INTO PRODUCT (DESCRIPTION, PRICE, CATEGORY) VALUES ('Ronde Neodymiummagneet 20 mm', 7.2, 'Magneten');

INSERT INTO STOCK_ITEM (MY_PRODUCT_ID, AMOUNT) VALUES (1, 250);
INSERT INTO STOCK_ITEM (MY_PRODUCT_ID, AMOUNT) VALUES (2, 500);
INSERT INTO STOCK_ITEM (MY_PRODUCT_ID, AMOUNT) VALUES (3, 10);
INSERT INTO STOCK_ITEM (MY_PRODUCT_ID, AMOUNT) VALUES (4, 15);
INSERT INTO STOCK_ITEM (MY_PRODUCT_ID, AMOUNT) VALUES (5, 50);
INSERT INTO STOCK_ITEM (MY_PRODUCT_ID, AMOUNT) VALUES (6, 100);
INSERT INTO STOCK_ITEM (MY_PRODUCT_ID, AMOUNT) VALUES (7, 200);
INSERT INTO STOCK_ITEM (MY_PRODUCT_ID, AMOUNT) VALUES (8, 250);

INSERT INTO CART_ITEM (CART_ID, AMOUNT, PRODUCT_ID, CART_ITEMS_KEY) VALUES (1, 2, 1, 1);
INSERT INTO CART_ITEM (CART_ID, AMOUNT, PRODUCT_ID, CART_ITEMS_KEY) VALUES (1, 5, 2, 2);
INSERT INTO CART_ITEM (CART_ID, AMOUNT, PRODUCT_ID, CART_ITEMS_KEY) VALUES (1, 8, 3, 3);
INSERT INTO CART_ITEM (CART_ID, AMOUNT, PRODUCT_ID, CART_ITEMS_KEY) VALUES (2, 9, 4, 4);

INSERT INTO CART_ITEM (CART_ID, AMOUNT, PRODUCT_ID, CART_ITEMS_KEY) VALUES (2,3,1,5);
INSERT INTO CART_ITEM (CART_ID, AMOUNT, PRODUCT_ID, CART_ITEMS_KEY) VALUES (3,20,1,6);