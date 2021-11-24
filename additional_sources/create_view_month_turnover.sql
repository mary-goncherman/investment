CREATE VIEW month_turnover
AS
SELECT
	DATEFROMPARTS(YEAR(operation_time),MONTH(operation_time),1) as period,
	operation_type,
    SUM(operation_price) as sum,
    SUM(commission) as commission
FROM
	dbo.operation_history
group by
	DATEFROMPARTS(YEAR(operation_time),MONTH(operation_time),1),
	operation_type
order by
	DATEFROMPARTS(YEAR(operation_time),MONTH(operation_time),1),
	operation_type