SELECT Name, Size, ISNULL() FROM Production.Product ORDER BY Name DESC;

SELECT Gender, COUNT(Gender)  FROM HumanResources.Employee GROUP BY Gender;

SELECT Color, COUNT(Name) as CountProducts  FROM Production.Product WHERE Color like 'b%' or Color like 's%'  GROUP BY Color;

SELECT City, COUNT(*) as Population FROM Person.Address GROUP BY City HAVING COUNT(*) > 200 ORDER BY Population DESC;

SELECT ListPrice, Name  FROM Production.Product WHERE ListPrice = (SELECT MAX(ListPrice) FROM Production.Product);

SELECT JobTitle, BirthDate FROM HumanResources.Employee WHERE BirthDate = (SELECT MIN(BirthDate) FROM HumanResources.Employee);

SELECT PP.FirstName, pp.LastName, PE.EmailAddress FROM Person.Person as PP  inner join Person.EmailAddress as PE on PP.BusinessEntityID = PE.BusinessEntityID;

SELECT P.Name, S.Name FROM Production.Product as P inner join Production.ProductSubcategory as S on P.rowguid = S.rowguid;

SELECT * FROM Production.ProductSubcategory;
SELECT * FROM Production.Product;
