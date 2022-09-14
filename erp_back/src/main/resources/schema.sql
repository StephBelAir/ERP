CREATE TABLE lot
(
    id INT PRIMARY KEY,
    quantity INT NOT NULL,
    length INT NOT NULL,
    productId INT NOT NULL,
    processId INT NOT NULL
);
CREATE TABLE product
(
    productId INT PRIMARY KEY,
    width INT NOT NULL,
    type INT NOT NULL,
    specialType DATETIME NOT NULL,
    startDate DATETIME NOT NULL,
    endDate DATETIME NOT NULL,
    actualEndDate DATETIME NOT NULL
);
CREATE TABLE process
(
    processId INT PRIMARY KEY
);
CREATE TABLE machine
(
    machineId INT PRIMARY KEY,
    productionTime DATETIME NOT NULL,
    processOrder INT NOT NULL
);


INSERT INTO lot VALUES(1, 2, 3, 4, 5);