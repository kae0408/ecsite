set names utf8;
set foreign_key_checks = 0;
/*もしexistsというデータベースがあったら削除します*/
drop database if exists ecsite;
/*ecsiteデータベースを作成します*/
create database if not exists ecsite;
/*作成したecsiteデータベースを利用します*/
use ecsite;

/*ユーザーログイン情報テーブル*/

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
user_address varchar(50),
user_sex varchar(10),
user_tell varchar(13),
user_mail varchar(50),
insert_date datetime,
update_date datetime
);


/*商品情報テーブル*/

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
item_category varchar(50),
item_description varchar(255),
img_file_path varchar(100),
insert_date datetime,
update_date datetime
);

/*商品購入テーブル*/

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
item_stock int,
insert_date datetime,
delete_date datetime
);

/*問い合わせテーブル*/
drop table if exists inquiry;

create table inquiry(
inquiry_name varchar(50),
inquiry_mail varchar(50),
qtype varchar(50),
body varchar(255),
master_id varchar(50)
);


INSERT INTO item_info_transaction(item_name, item_price, item_stock, item_category,item_description, img_file_path) VALUES
("生チョコケーキ", 200, 10,"cake","チョコレートのケーキです。","./img/cake1.jpg"),
("チーズケーキ",170,50,"cake","チーズのコクが濃厚なケーキです。","./img/cake4.jpg"),
("ラズベリーパイ",250,50,"cake","数種類のベリーが入ったパイです。","./img/pie1.jpg"),
("フルーツロール",150,50,"cake","季節の果物がたくさん入ったケーキです。","./img/roll1.jpg"),
("チョコロール",150,50,"cake","甘さ控えめのロールケーキです。","./img/roll2.jpg"),
("キャラメルロール",150,50,"cake","見た目もかわいいロールケーキです。","./img/roll3.jpg"),
("クリームマフィン",100,50,"bake","ラズベリー風味のクリームがたっぷりのったマフィンです。","./img/muffin2.jpg"),
("チョコクリームマフィン",100,50,"bake","チョコクリームがたっぷりのったマフィンです。","./img/muffin3.jpg"),
("シュークリーム",80,50,"bake","カスタードクリームたっぷりのシュークリームです。","./img/bake1.jpg"),
("星型クッキー",100,50,"bake","星型のアイシングクッキーです。","./img/cookie1.jpg"),
("クッキー詰め合わせ",800,50,"bake","クッキーの詰め合わせです。","./img/cookie2.jpg"),
("アップルクッキー",800,50,"bake","アップルジャム入りのクッキーです。","./img/cookie3.jpg"),
("タイ焼き",120,50,"wagashi","粒あんが入ったタイ焼きです。","./img/wagashi1.jpg"),
("桜餅",80,50,"wagashi","食べやすいサイズの桜餅です。","./img/wagashi2.jpg"),
("金魚の水菓子",190,50,"wagashi","見た目も涼しげなお菓子です。","./img/wagashi3.jpg");

INSERT INTO login_user_transaction(login_id, login_pass, user_name, user_address, user_sex, user_tell, user_mail) VALUES
("kanri", "123", "kanrisya","岡山","男","090-0000-1111","kanri@yahoo.co.jp"),
("kae", "123", "taro","東京都","男","090-0000-0000","taro@yahoo.co.jp"),
("hanako","789","hanako","北海道","女","080-0000-0000","hanako@gmail");

