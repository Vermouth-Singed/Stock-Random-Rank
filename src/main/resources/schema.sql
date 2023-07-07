DROP TABLE IF EXISTS stock_company_info CASCADE;

CREATE TABLE stock_company_info (
	id int(11) PRIMARY KEY AUTO_INCREMENT COMMENT '아이디',
	code int(7) NOT NULL COMMENT '코드',
	name varchar(30) NOT NULL COMMENT '이름',
	price int(11) NOT NULL COMMENT '가격',
	increase_rate int(5) NOT NULL DEFAULT 0 COMMENT '증가율',
	view_cnt int(11) NOT NULL DEFAULT 0 COMMENT '조회수',
	buy_cnt int(11) NOT NULL DEFAULT 0 COMMENT '거래량'
);