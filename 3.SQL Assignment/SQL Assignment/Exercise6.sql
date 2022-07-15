/* Exercise 6. Write a trigger for the Product table to ensure the list price can never be raised more than 15 Percent 
               in a single change. Modify the above trigger to execute its check code only if the ListPrice column is 
			   updated (Use AdventureWorks Database) */


CREATE TRIGGER trCheckListPriceUpdate 
ON Production.Product 
INSTEAD OF UPDATE
AS
BEGIN
DECLARE @oldListPrice FLOAT, @newListPrice FLOAT, @productID as int
SELECT @oldListPrice = deleted.ListPrice, @newListPrice = inserted.ListPrice, @productID = deleted.ProductID
FROM deleted,inserted


      IF UPDATE(ListPrice)
	        IF(@newListPrice > (@oldListPrice + (0.15 * @oldListPrice)))
			   BEGIN
			       RAISERROR ('Price may not be greater than 15 PERCENT', 16, 0)
				   RETURN

			   END
			ELSE
			   BEGIN 
			      UPDATE Product SET ListPrice = @newListPrice
				  WHERE ProductID = @productID
			   END
END


--Query to Update--

SELECT ProductID, ListPrice FROM Production.Product
WHERE ListPrice <> 0

--Query to update productID 514 and ListPrice 133.34
UPDATE Production.Product SET ListPrice = 170 WHERE ProductID = 514


--checking new listPrice
Select ProductID, ListPrice FROM Production.Product
WHERE ProductID = 514


