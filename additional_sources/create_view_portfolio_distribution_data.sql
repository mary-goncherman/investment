CREATE VIEW portfolio_distribution_data
AS
SELECT
P.id as portfolio_id,
P.name as portfolio_name,
PD.criteria_id as criteria_id,
C.name as criteria_name,
PD.per_cent as per_cent,
PD.deleted as deleted
FROM [TestMasha].[dbo].[portfolio] P
	LEFT JOIN [TestMasha].[dbo].[portfolio_distribution] PD on P.id = PD.portfolio_id
	LEFT JOIN [TestMasha].[dbo].[criteria] C on C.id = PD.criteria_id;