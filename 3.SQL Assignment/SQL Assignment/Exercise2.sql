
/* Exercise 2. Write separate queries using a join, a subquery, a CTE, and then an EXISTS to list all AdventureWorks customers who have not placed 
   an order. */

-- Using Join --

SELECT FirstName + SPACE(1) + LastName AS 'Customer Name', SalesOrderID
FROM Person.Person INNER JOIN Sales.Customer ON BusinessEntityID = CustomerID LEFT JOIN Sales.SalesOrderHeader ON
Sales.Customer.CustomerID = Sales.SalesOrderHeader.CustomerID
WHERE Sales.SalesOrderHeader.SalesOrderID IS NULL;

-- Using SubQuery --
SELECT FirstName + SPACE(1) + LastName AS 'Customer Name'
FROM Person.Person 
WHERE BusinessEntityID IN ( SELECT CustomerID FROM Sales.Customer 
                           WHERE CustomerID NOT IN ( SELECT CustomerID FROM Sales.SalesOrderHeader));


-- CTE --
WITH CustomerName (CustomerID)
AS (
SELECT Sales.Customer.CustomerID
FROM Sales.Customer LEFT JOIN Sales.SalesOrderHeader
ON Sales.Customer.CustomerID = Sales.SalesOrderHeader.CustomerID
WHERE Sales.SalesOrderHeader.SalesOrderID IS NULL
)
SELECT FirstName + SPACE(1) + LastName AS 'Customer Name'
FROM Person.Person JOIN CustomerName
ON CustomerID = BusinessEntityID;


-- EXISTS --

SELECT FirstName + SPACE(1) + LastName AS 'Customer Name'
FROM Person.Person WHERE EXISTS (SELECT CustomerID FROM Sales.Customer WHERE BusinessEntityID = CustomerID
AND NOT EXISTS (SELECT CustomerID FROM Sales.SalesOrderHeader 
              WHERE Customer.CustomerID = SalesOrderHeader.CustomerID));


