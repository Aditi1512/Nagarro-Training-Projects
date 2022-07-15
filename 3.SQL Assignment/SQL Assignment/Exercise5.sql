/* Exercise 5. Write a Procedure supplying name information from the Person.Person table and accepting a filter for 
               the first name. Alter the above Store Procedure to supply Default Values if user does not enter any value. 
*/

CREATE PROCEDURE spGetPersonInfo
@FirstName NVARCHAR(20) = 'Andy'
AS
BEGIN
     SELECT FirstName + SPACE(1) + LastName AS 'Name', BusinessEntityID, PersonType FROM Person.Person
	 WHERE FirstName = @FirstName
END

GO 

--Executing Procedure--
EXECUTE spGetPersonInfo
EXECUTE spGetPersonInfo 'James'
    