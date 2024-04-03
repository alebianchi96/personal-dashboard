select bc."name" , sum(bs.annual_amount)  from bgt_subcategories bs 
	inner join bgt_categories bc on bs.fk_category = bc.id 
where bs.annual_amount is not null and bs.annual_amount > 0
group by bc."name";

select sum(bs.annual_amount), sum(bs.annual_amount)/12  from bgt_subcategories bs 
	inner join bgt_categories bc on bs.fk_category = bc.id 
where bs.annual_amount is not null and bs.annual_amount > 0;