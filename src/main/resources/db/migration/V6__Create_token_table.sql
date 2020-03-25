create table token
(
	id int auto_increment,
	assess_token VARCHAR(100),
	expire_time BIGINT,
	constraint token_pk
		primary key (id)
);

