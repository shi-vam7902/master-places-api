create database masterappApi;
create table places (
	placeid integer primary key auto_increment,
	title varchar(100),
	location varchar(1024),
	speciality varchar(1024),
	best_time_to_visit varchar(500),
	approved boolean ,
	createdAt varchar(18),
	userid integer
);