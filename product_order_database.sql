CREATE TABLE Products(

    productID int NOT NULL,
    name varchar(255) NOT NULL,
    price decimal(4,2) NOT NULL,
    quantity int NOT NULL,
    experationDate varchar() NOT NULL,
    providerName varchar(255) NOT NULL,
    providerInfo varchar(255) NOT NULL,
    PRIMARY KEY (productID)
);

CREATE TABLE Orders(

    orderID int NOT NULL,
    total decimal(4,2) NOT NULL,
    custName varchar(255) NOT NULL,
    productsBoughtIDs int NOT NULL,
    amountOfProducts int NOT NULL,
    formOfPayment varchar(255) NOT NULL,
    itemPrice decimal(4,2) NOT NULL,
    PRIMARY KEY (orderID)
);

CREATE TABLE Users (
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    isAdmin BOOLEAN,
    profilePic varbinary(255),
    PRIMARY KEY (username)
);

/*Code for inserting items into the database*/
INSERT INTO product (productID, name, price, quantity, experationDate, providerName, providerInfo)
VALUES (1, "Apple", 0.99, 60, "9/3/2017", "Farmer John", "334-695-4921");

INSERT INTO product (productID, name, price, quantity, experationDate, providerName, providerInfo)
VALUES (2, "Orange", 1.99, 60, "9/6/2017", "Farmer John", "334-695-4921");

INSERT INTO product (productID, name, price, quantity, experationDate, providerName, providerInfo)
VALUES (3, "Milk", 2.99, 60, "9/9/2017", "Farmer John", "334-695-4921");

INSERT INTO product (productID, name, price, quantity, experationDate, providerName, providerInfo)
VALUES (4, "Bacon", 2.99, 60, "9/19/2017", "Farmer John", "334-695-4921");

INSERT INTO product (productID, name, price, quantity, experationDate, providerName, providerInfo)
VALUES (5, "Cheese", 3.99, 60, "9/20/2017", "Farmer John", "334-695-4921");
