/* Exercise 3. Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with 
   AdventureWorks. 
*/

SELECT TOP 5 SalesOrderID, OrderDate, AccountNumber, TotalDue AS 'Amount Spent'
FROM Sales.SalesOrderHeader
WHERE TotalDue > 70000
ORDER BY OrderDate DESC;


