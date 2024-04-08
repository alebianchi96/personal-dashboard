/* bgt_view_budgets_total
 * 
 * */
CREATE OR REPLACE VIEW public.bgt_view_budgets_total
AS
select 
	sum(bs.annual_amount) as amount_budget_year, 
	sum(bs.annual_amount)/12 as amount_budget_month
from bgt_subcategories bs ;

/* bgt_view_number_periods_year
 * 
 * */
CREATE OR REPLACE VIEW public.bgt_view_number_periods_year
AS
select 
	year, 
	count(month) as periods_recorded
from bgt_period bp
where exists (select 1 from bgt_period_amount bpa where bpa.fk_period = bp.id)
group by "year" 
order by "year";

/* bgt_view_total_year_nature -> totali per anno-natura
 * 
 * */
CREATE OR REPLACE VIEW public.bgt_view_total_year_nature
AS
select bp."year" as "year" , bc.nature as nature, sum(bpa.amount) as amount
from bgt_period_amount bpa 
	inner join bgt_period bp on bpa.fk_period = bp.id 
	inner join bgt_subcategories bs on bs.id = bpa.fk_subcategory 
	inner join bgt_categories bc on bc.id = bs.fk_category 
group by bp."year" , bc.nature
order by bp."year", bc.nature;

/* bgt_view_total_month_year_nature -> totali per mese-anno-natura
 * 
 * */
CREATE OR REPLACE VIEW public.bgt_view_total_month_year_nature
AS
select bp."month" as "month" , bp."year" as "year" , bc.nature as nature, sum(bpa.amount) as amount
from bgt_period_amount bpa 
	inner join bgt_period bp on bpa.fk_period = bp.id 
	inner join bgt_subcategories bs on bs.id = bpa.fk_subcategory 
	inner join bgt_categories bc on bc.id = bs.fk_category 
group by bp."month" , bp."year" , bc.nature
order by bp."year", bc.nature;

/* bgt_view_total_month_year_category -> totali per mese-anno-categoria
 * 
 * */
CREATE OR REPLACE VIEW public.bgt_view_total_month_year_category
AS
select bp."month" as "month", bp."year" as "year", bc.name as category, bc.nature as nature, sum(bpa.amount) as amount
from bgt_period_amount bpa 
	inner join bgt_period bp on bpa.fk_period = bp.id 
	inner join bgt_subcategories bs on bs.id = bpa.fk_subcategory 
	inner join bgt_categories bc on bc.id = bs.fk_category 
group by bp."month" , bp."year" , bc.name, bc.nature
order by bp."year", bc.name;

/*	bgt_view_total_year_category -> totali per anno-categoria
 * 
 * */
CREATE OR REPLACE VIEW public.bgt_view_total_year_category
AS
select 
	T.year,
	T.nature,
	T.category,
	T.amount_recorded,
	T.amount_budget,
	(T.amount_budget/12*(12-vnpy.periods_recorded)) as amount_budget_remaining,
	(T.amount_budget-T.amount_recorded) as amount_to_use,
	(T.amount_budget-T.amount_recorded-(T.amount_budget/12*(12-vnpy.periods_recorded))) as delta_amount
from (
	select 
		bp."year" as "year" , 
		bc.nature as "nature", 
		bc.name as "category", 
		sum(bpa.amount) as amount_recorded,
		(select sum(bs1.annual_amount) from bgt_subcategories bs1 where bs1.fk_category = bc.id) as amount_budget
	from bgt_period_amount bpa 
		inner join bgt_period bp on bpa.fk_period = bp.id 
		inner join bgt_subcategories bs on bs.id = bpa.fk_subcategory 
		inner join bgt_categories bc on bc.id = bs.fk_category 
	group by bp."year" , bc.nature, bc.name, bc.id
	order by bp."year", bc.nature, bc.name
) T inner join bgt_view_number_periods_year vnpy on vnpy."year" = T.year;