drop table transaction;
drop table shopping_cart_item;
drop table product_category;
drop table product;
drop table category;
drop table shopping_cart;
drop table users;

create table users(
u_id serial primary key,
u_mail text UNIQUE,
u_pass text
);

create table product(
p_id serial primary key,
p_label text UNIQUE,
p_desc text,
p_image text,
p_hero text,
p_price integer
);

create table category(
c_id serial primary key,

c_label text UNIQUE
);

create table shopping_cart(
sc_id serial primary key,
u_id integer references users(u_id),
sc_cost integer
);

create table product_category(
p_id integer references product(p_id),
c_id integer references category(c_id),
primary key(p_id, c_id)
);


create table shopping_cart_item(
p_id integer references product(p_id),
sc_id integer references shopping_cart(sc_id),
quantity integer,
primary key(p_id, sc_id)
);

create table transaction(
t_id serial primary key,
u_id integer references users(u_id),
sc_id integer references shopping_cart(sc_id),
t_date timestamp with time zone
);

insert into users(u_pass,u_mail)
values('ch','chklavus@kth.se');
insert into users(u_pass,u_mail)
values('piggelin','eppi@peppi.com');
insert into category(c_label) values('Keys');
insert into category(c_label) values('Items');
insert into category(c_label) values('Sets');
insert into category(c_label) values('Heroes');
insert into category(c_label) values('Misc');

insert into product(p_label,p_desc,p_image,p_hero,p_price)
values('Dragonclaw Hook','so good!','/images/dragonclawhook.png','Pudge','2000000');
insert into product(p_label,p_desc,p_image,p_hero,p_price)
values('Scythe of vyse Hook','Sheep stick!','/images/sheepstick.png','Furion','1000');
insert into product_category(p_id,c_id) values(1,2);
insert into product_category(p_id,c_id) values(2,2);
insert into shopping_cart(u_id,sc_cost) values(1,10000);
insert into shopping_cart_item(p_id,sc_id,quantity) values(1,1,1);
insert into shopping_cart_item(p_id,sc_id,quantity) values(1,1,1);
insert into transaction(u_id,sc_id) values(1,1);



