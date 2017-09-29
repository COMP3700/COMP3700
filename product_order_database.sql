CREATE TABLE Products(

    productID int NOT NULL,
    name varchar(255) NOT NULL,
    price decimal(4,2) NOT NULL,
    quantity int NOT NULL,
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
