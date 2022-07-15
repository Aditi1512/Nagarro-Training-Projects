/*Exercise 1*/


/*  1. Display the number of records in the [SalesPerson] table. (Schema(s) involved: Sales)*/

SELECT * FROM Sales.SalesPerson;

SELECT COUNT(*) FROM Sales.SalesPerson;


/*  2. Select both the FirstName and LastName of records from the Person table where the FirstName begins with the letter ‘B’. 
    (Schema(s) involved: Person) */

SELECT FirstName,LastName FROM Person.Person WHERE FirstName LIKE 'B%';


/*  3. Select a list of FirstName and LastName for employees where Title is one of Design Engineer, Tool Designer or Marketing 
    Assistant. (Schema(s) involved: HumanResources, Person */

SELECT Person.Person.FirstName, Person.Person.LastName, HumanResources.Employee.JobTitle
FROM Person.Person INNER JOIN HumanResources.Employee 
ON Employee.BusinessEntityID = Person.BusinessEntityID 
WHERE HumanResources.Employee.JobTitle IN ('Design Engineer', 'Tool Designer', 'Marketing Assistant');


/*  4. Display the Name and Color of the Product with the maximum weight. (Schema(s) involved: Production) */

SELECT Name, Color FROM Production.Product 
WHERE Weight = (SELECT MAX(Weight) FROM Production.Product);


/*  5. Display Description and MaxQty fields from the SpecialOffer table. Some of the MaxQty values are NULL, in this case display 
    the value 0.00 instead. (Schema(s) involved: Sales) */

SELECT Description, COALESCE(MaxQty, 0.00) AS MaxQty FROM Sales.SpecialOffer;


/*  6. Display the overall Average of the [CurrencyRate].[AverageRate] values for the exchange rate ‘USD’ to ‘GBP’ for the year 2005 
    i.e. FromCurrencyCode = ‘USD’ and ToCurrencyCode = ‘GBP’. Note: The field [CurrencyRate].[AverageRate] is defined as 
   'Average exchange rate for the day.' (Schema(s) involved: Sales) */

SELECT AVG(CurrencyRate.AverageRate) AS 'Average exchange rate for the day'
FROM Sales.CurrencyRate
WHERE FromCurrencyCode = 'USD' OR ToCurrencyCode = 'GBP' OR CurrencyRateDate = 2005;


/*  7. Display the FirstName and LastName of records from the Person table where FirstName contains the letters ‘ss’. Display an 
    additional column with sequential numbers for each row returned beginning at integer 1. (Schema(s) involved: Person) */

SELECT ROW_NUMBER() OVER(ORDER BY Title) AS 'S_No', FirstName, LastName
FROM Person.Person
WHERE FirstName LIKE '%ss%';


/*  8. Sales people receive various commission rates that belong to 1 of 4 bands. (Schema(s) involved: Sales)
    CommissionPct Commission Band
    0.00 Band 0
    Up To 1% Band 1
    Up To 1.5% Band 2
    Greater 1.5% Band 3
    Display the [SalesPersonID] with an additional column entitled ‘Commission Band’ indicating the 
	appropriate band as above.*/

SELECT BusinessEntityID AS 'SalesPersonID',
CASE
    WHEN SalesPerson.CommissionPct = 0.0 THEN 'Band 0'
	WHEN SalesPerson.CommissionPct > 0.0 AND SalesPerson.CommissionPct <= 0.01 THEN 'Band 1'
	WHEN SalesPerson.CommissionPct > 0.01 AND SalesPerson.CommissionPct <= 0.015 THEN 'Band 2'
	ELSE 'Band 3'
END AS 'Commission Band'
FROM Sales.SalesPerson
ORDER BY [Commission Band];


/* 9. Display the managerial hierarchy from Ruth Ellerbrock (person type – EM) up to CEO Ken Sanchez. Hint: use 
      [uspGetEmployeeManagers] (Schema(s) involved: [Person], [HumanResources]) */

DECLARE @BusinessID INT;
SELECT @BusinessID = BusinessEntityID
FROM Person.Person
WHERE FirstName = 'Ruth' AND LastName = 'Ellerbrock' AND PersonType = 'EM';
EXEC dbo.uspGetEmployeeManagers @BusinessEntityID = @BusinessID;


/* 10. Display the ProductId of the product with the largest stock level. Hint: Use the Scalar-valued 
       function [dbo].[UfnGetStock]. (Schema(s) involved: Production) */SELECT MAX(dbo.ufnGetStock(ProductID)) AS 'Product ID with largest stock level' FROM Production.Product
