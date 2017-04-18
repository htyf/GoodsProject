CREATE TABLE table_goods(
	g_id number(6) primary key,
	g_name varchar2(50),
	g_count number(5),
	g_price number(7,2)
);
CREATE SEQUENCE table_goods_seq;