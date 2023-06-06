SELECT JobTitle, Gender, VacationHours FROM HumanResources.Employee WHERE VacationHours > 50 and (Gender = 'f' or Gender = 'm') ORDER BY Gender;

SELECT Name, SafetyStockLevel FROM Production.Product 
WHERE Color = 'Black' and SafetyStockLevel >= 100 
ORDER BY SafetyStockLevel asc;

SELECT * FROM HumanResources.Employee ORDER BY BirthDate desc;

SELECT Name, ListPrice, Color FROM Production.Product WHERE (ListPrice > 10 and ListPrice < 500 and  Color = 'Black') or Color = 'White' ORDER BY ListPrice;

Select Name, Color FROM Production.Product WHERE Color like 'b%' or Color like 'y%';

SELECT FirstName, LastName, (FirstName + ' ' + LastName) as Razem FROM Person.Person WHERE LastName like 'B%' and FirstName like '%a%' ORDER BY LastName asc, FirstName desc;

SELECT BirthDate, JobTitle FROM HumanResources.Employee  WHERE (JobTitle like '%Engineer%' or JobTitle like '%Manager%') and OrganizationLevel >= 3;

SELECT AddressLine1, City FROM Person.Address WHERE AddressLine2 is null;
 
SELECT Name, Size, ListPrice, ISNULL (Size, 'BrakDanych') as NewSize FROM Production.Product WHERE ListPrice BETWEEN 5 and 10;

SELECT Name, Color FROM Production.Product WHERE Color = 'Black' and Name like 'HL%road%';

SELECT max( BirthDate) as Najmlodszy, min (BirthDate) as najstarszy FROM HumanResources.Employee;

SELECT min(ListPrice) as Minimal, max(ListPrice) as Maximal FROM Production.Product;



SELECT COUNT(*) as AllRaws, COUNT(*) - COUNT(COLOR) as NullColorsRaws, COUNT(Color) as NotNULLColorRaws FROM Production.Product;
