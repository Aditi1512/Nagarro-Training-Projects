/* Exercise 4. Create a function that takes as inputs a SalesOrderID, a Currency Code, and a date, and returns a 
   table of all the SalesOrderDetail rows for that Sales Order including Quantity, ProductID, UnitPrice, and the 
   unit price converted to the target currency based on the end of day rate for the date provided. Exchange rates 
   can be found in the Sales.CurrencyRate table. 
*/

CREATE FUNCTION  fn_FindTargetCurrency( @SalesOrderID AS INT, @CurrencyCode AS NVARCHAR(3), @date AS DATE)
RETURNS TABLE
AS
RETURN
(
SELECT OrderQty AS 'Quantity', ProductID, UnitPrice * EndOfDayRate AS 'Target Currency' 
FROM Sales.SalesOrderDetail, Sales.CurrencyRate
WHERE SalesOrderID = @SalesOrderID AND
      ToCurrencyCode = @CurrencyCode AND
	  CurrencyRateDate = @date
)
GO
SELECT * FROM fn_FindTargetCurrency(43659, 'CAD', '2008-06-09');