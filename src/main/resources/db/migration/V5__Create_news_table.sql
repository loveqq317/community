create table news
(
	id BIGINT auto_increment,
	user_name VARCHAR(100),
	head_url VARCHAR(500),
	is_focus BOOLEAN,
	news_title VARCHAR(500),
	is_video BOOLEAN,
	video_url VARCHAR(500),
	news_text LONGTEXT,
	news_abstrack VARCHAR(500),
	is_original BOOLEAN,
	create_time DATETIME,
	constraint news_pk
		primary key (id)
);

