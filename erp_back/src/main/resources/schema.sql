CREATE TABLE lot
(
    id          INT PRIMARY KEY,
    quantity    INT        NOT NULL,
    length      INT        NOT NULL,
    width       INT        NOT NULL,
    productName VARCHAR(3) NOT NULL,
    type        VARCHAR(2),
    specialType INT        NOT NULL,
    processId   INT        NOT NULL
);
CREATE TABLE process
(
    processId     INT PRIMARY KEY,
    processName   VARCHAR(11),
    startDate     DATETIME,
    endDate       DATETIME,
    actualEndDate DATETIME
);
CREATE TABLE machine
(
    machineId      INT PRIMARY KEY,
    productionTime DATETIME NOT NULL,
    processOrder   INT      NOT NULL
);
INSERT INTO lot
VALUES (0, 20, 3000, 45, 'HSR', 'LK', 1, 1);
INSERT INTO lot
VALUES (1, 100, 2000, 20, 'SHS', '', 0, 2);
INSERT INTO process
VALUES (0, 'Festo', '2004-05-23T14:25:10', '2004-05-23T14:25:10', '2004-05-23T14:25:10');
INSERT INTO process
VALUES (1, 'SKF Cherel', '2004-05-23T14:25:10', '2004-05-23T14:25:10', '2004-05-23T14:25:10');

