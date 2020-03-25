create table wxtoken
(
	id int auto_increment,
	assess_token VARCHAR(100),
	expire_time BIGINT,
	constraint wxtoken_pk
		primary key (id)
);

