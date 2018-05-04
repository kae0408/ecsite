set names utf8;
set foreign_key_checks = 0;
/*もしexistsというデータベースがあったら削除します*/
drop database if exists ecsite;
/*ecsiteデータベースを作成します*/
create database if not exists ecsite;
/*作成したecsiteデータベースを利用します*/
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
	id int not null primary key auto_increment,
	login_id varchar(16) unique,
	login_pass varchar(16),
	user_name varchar(50),
	insert_date datetime,
	updated_date datetime
);


drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
	id int not null primary key auto_increment,
	item_transaction_id int,
	total_price int,
	total_count int,
	user_master_id varchar(16),
	pay varchar(30),
	insert_date datetime,
	delete_date datetime
);


INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("Tシャツ",100,50);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("パーカー",200,60);
INSERT INTO login_user_transaction(login_id,login_pass,user_name)VALUES("internous","internous01","test");
