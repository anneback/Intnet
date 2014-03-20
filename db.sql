drop table transaction;
drop table shopping_cart_item;
drop table product_category;
drop table product;
drop table category;
drop table shopping_cart;
drop table users;
drop table heroes;


create table users(
u_id serial primary key,
u_mail text UNIQUE,
u_pass text
);

create table heroes(
h_id serial primary key,
h_name text,
h_image text
);

create table product(
p_id serial primary key,
p_label text,
p_desc text,
p_image text,
h_id integer references heroes(h_id),
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
values('ch','ch');
insert into users(u_pass,u_mail)
values('piggelin','eppi@peppi.com');
insert into category(c_label) values('Keys');
insert into category(c_label) values('Items');
insert into category(c_label) values('Sets');
insert into category(c_label) values('Heroes');
insert into category(c_label) values('Misc');




insert into heroes(h_name,h_image) values('Abaddon','abaddon');
insert into heroes(h_name,h_image) values('Alchemist','alchemist');
insert into heroes(h_name,h_image) values('Ancient Apparition','ancient_apparition');
insert into heroes(h_name,h_image) values('Anti-Mage','anti_mage');
insert into heroes(h_name,h_image) values('Axe','axe');
insert into heroes(h_name,h_image) values('Bane','bane');
insert into heroes(h_name,h_image) values('Batrider','batrider');
insert into heroes(h_name,h_image) values('Beastmaster','beastmaster');
insert into heroes(h_name,h_image) values('Bloodseeker','bloodseeker');
insert into heroes(h_name,h_image) values('Bounty Hunter','bounty_hunter');
insert into heroes(h_name,h_image) values('Brewmaster','brewmaster');
insert into heroes(h_name,h_image) values('Bristleback','bristleback');
insert into heroes(h_name,h_image) values('Broodmother','broodmother');
insert into heroes(h_name,h_image) values('Centaur Warrunner','centaur_warrunner');
insert into heroes(h_name,h_image) values('Chaos Knight','chaos_knight');
insert into heroes(h_name,h_image) values('Chen','chen');
insert into heroes(h_name,h_image) values('Clinkz','clinkz');
insert into heroes(h_name,h_image) values('Clockwerk','clockwerk');
insert into heroes(h_name,h_image) values('Crystal Maiden','crystal_maiden');
insert into heroes(h_name,h_image) values('Dark Seer','dark_seer');
insert into heroes(h_name,h_image) values('Dazzle','dazzle');
insert into heroes(h_name,h_image) values('Death Prophet','death_prophet');
insert into heroes(h_name,h_image) values('Disruptor','disruptor');
insert into heroes(h_name,h_image) values('Doom Bringer','doom_bringer');
insert into heroes(h_name,h_image) values('Dragon Knight','dragon_knight');
insert into heroes(h_name,h_image) values('Drow Ranger','drow_ranger');
insert into heroes(h_name,h_image) values('Earth Spirit','earth_spirit');
insert into heroes(h_name,h_image) values('Earthshaker','earthshaker');
insert into heroes(h_name,h_image) values('Elder Titan','elder_titan');
insert into heroes(h_name,h_image) values('Ember Spirit','ember_spirit');
insert into heroes(h_name,h_image) values('Enchantress','enchantress');
insert into heroes(h_name,h_image) values('Enigma','enigma');
insert into heroes(h_name,h_image) values('Faceless Void','faceless_void');
insert into heroes(h_name,h_image) values('Gyrocopter','gyrocopter');
insert into heroes(h_name,h_image) values('Huskar','huskar');
insert into heroes(h_name,h_image) values('Invoker','invoker');
insert into heroes(h_name,h_image) values('Io','io');
insert into heroes(h_name,h_image) values('Jakiro','jakiro');
insert into heroes(h_name,h_image) values('Juggernaut','juggernaut');
insert into heroes(h_name,h_image) values('Keeper of the Light','keeper_of_the_light');
insert into heroes(h_name,h_image) values('Kunkka','kunkka');
insert into heroes(h_name,h_image) values('Legion Commander','legion_commander');
insert into heroes(h_name,h_image) values('Leshrac','leshrac');
insert into heroes(h_name,h_image) values('Lich','lich');
insert into heroes(h_name,h_image) values('Lifestealer','lifestealer');
insert into heroes(h_name,h_image) values('Lina','lina');
insert into heroes(h_name,h_image) values('Lion','lion');
insert into heroes(h_name,h_image) values('Lone Druid','lone_druid');
insert into heroes(h_name,h_image) values('Luna','luna');
insert into heroes(h_name,h_image) values('Lycan','lycan');
insert into heroes(h_name,h_image) values('Magnus','magnus');
insert into heroes(h_name,h_image) values('Medusa','medusa');
insert into heroes(h_name,h_image) values('Meepo','meepo');
insert into heroes(h_name,h_image) values('Mirana','mirana');
insert into heroes(h_name,h_image) values('Morphling','morphling');
insert into heroes(h_name,h_image) values('Naga Siren','naga_siren');
insert into heroes(h_name,h_image) values(E'Nature\'s Prophet','natures_prophet');
insert into heroes(h_name,h_image) values('Necrophos','necrophos');
insert into heroes(h_name,h_image) values('Night Stalker','night_stalker');
insert into heroes(h_name,h_image) values('Nyx Assassin','nyx_assassin');
insert into heroes(h_name,h_image) values('Ogre Magi','ogre_magi');
insert into heroes(h_name,h_image) values('Omniknight','omniknight');
insert into heroes(h_name,h_image) values('Outworld Devourer','outworld_devourer');
insert into heroes(h_name,h_image) values('Phantom Assassin','phantom_assassin');
insert into heroes(h_name,h_image) values('Phantom Lancer','phantom_lancer');
insert into heroes(h_name,h_image) values('Phoenix','phoenix');
insert into heroes(h_name,h_image) values('Puck','puck');
insert into heroes(h_name,h_image) values('Pudge','pudge');
insert into heroes(h_name,h_image) values('Pugna','pugna');
insert into heroes(h_name,h_image) values('Queen of Pain','queen_of_pain');
insert into heroes(h_name,h_image) values('Razor','razor');
insert into heroes(h_name,h_image) values('Riki','riki');
insert into heroes(h_name,h_image) values('Rubick','rubick');
insert into heroes(h_name,h_image) values('Sand King','sand_king');
insert into heroes(h_name,h_image) values('Shadow Demon','shadow_demon');
insert into heroes(h_name,h_image) values('Shadow Fiend','shadow_fiend');
insert into heroes(h_name,h_image) values('Shadow Shaman','shadow_shaman');
insert into heroes(h_name,h_image) values('Silencer','silencer');
insert into heroes(h_name,h_image) values('Skywrath Mage','skywrath_mage');
insert into heroes(h_name,h_image) values('Slardar','slardar');
insert into heroes(h_name,h_image) values('Slark','slark');
insert into heroes(h_name,h_image) values('Sniper','sniper');
insert into heroes(h_name,h_image) values('Spectre','spectre');
insert into heroes(h_name,h_image) values('Spirit Breaker','spirit_breaker');
insert into heroes(h_name,h_image) values('Storm Spirit','storm_spirit');
insert into heroes(h_name,h_image) values('Sven','sven');
insert into heroes(h_name,h_image) values('Templar Assassin','templar_assassin');
insert into heroes(h_name,h_image) values('Terrorblade','terrorblade');
insert into heroes(h_name,h_image) values('Tidehunter','tidehunter');
insert into heroes(h_name,h_image) values('Timbersaw','timbersaw');
insert into heroes(h_name,h_image) values('Tinker','tinker');
insert into heroes(h_name,h_image) values('Treant Protector','treant_protector');
insert into heroes(h_name,h_image) values('Troll Warlord','troll_warlord');
insert into heroes(h_name,h_image) values('Tusk','tusk');
insert into heroes(h_name,h_image) values('Undying','undying');
insert into heroes(h_name,h_image) values('Ursa','ursa');
insert into heroes(h_name,h_image) values('Vengeful Spirit','vengeful_spirit');
insert into heroes(h_name,h_image) values('Venomancer','venomancer');
insert into heroes(h_name,h_image) values('Viper','viper');
insert into heroes(h_name,h_image) values('Visage','visage');
insert into heroes(h_name,h_image) values('Warlock','warlock');
insert into heroes(h_name,h_image) values('Weaver','weaver');
insert into heroes(h_name,h_image) values('Windranger','windranger');
insert into heroes(h_name,h_image) values('Witch Doctor','witch_doctor');
insert into heroes(h_name,h_image) values('Wraith King','wraith_king');
insert into heroes(h_name,h_image) values('Zeus','zeus');

insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',1,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',2,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',3,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',4,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',5,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',6,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',7,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',8,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',9,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',10,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',11,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',12,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',13,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',14,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',15,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',16,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',17,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',18,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',19,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',20,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',21,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',22,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',23,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',24,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',25,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',26,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',27,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',28,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',29,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',30,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',31,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',32,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',33,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',34,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',35,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',36,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',37,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',38,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',39,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',40,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',41,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',42,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',43,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',44,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',45,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',46,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',47,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',48,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',49,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',50,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',51,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',52,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',53,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',54,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',55,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',56,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',57,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',58,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',59,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',60,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',61,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',62,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',63,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',64,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',65,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',66,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',67,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',68,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',69,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',70,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',71,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',72,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',73,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',74,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',75,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',76,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',77,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',78,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',79,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',80,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',81,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',82,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',83,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',84,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',85,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',86,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',87,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',88,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',89,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',90,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',91,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',92,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',93,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',94,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',95,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',96,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',97,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',98,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',99,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',100,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',101,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',102,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',103,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',104,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',105,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 100%','/images/all_100_exp.png',106,1500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',1,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',2,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',3,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',4,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',5,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',6,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',7,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',8,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',9,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',10,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',11,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',12,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',13,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',14,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',15,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',16,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',17,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',18,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',19,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',20,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',21,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',22,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',23,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',24,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',25,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',26,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',27,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',28,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',29,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',30,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',31,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',32,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',33,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',34,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',35,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',36,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',37,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',38,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',39,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',40,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',41,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',42,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',43,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',44,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',45,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',46,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',47,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',48,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',49,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',50,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',51,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',52,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',53,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',54,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',55,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',56,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',57,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',58,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',59,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',60,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',61,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',62,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',63,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',64,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',65,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',66,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',67,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',68,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',69,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',70,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',71,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',72,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',73,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',74,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',75,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',76,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',77,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',78,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',79,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',80,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',81,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',82,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',83,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',84,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',85,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',86,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',87,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',88,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',89,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',90,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',91,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',92,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',93,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',94,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',95,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',96,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',97,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',98,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',99,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',100,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',101,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',102,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',103,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',104,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',105,4500);
insert into product(p_label,p_image,h_id,p_price) values('Boost 400%','/images/all_400_exp.png',106,4500);
insert into product(p_label,p_desc,p_image,h_id,p_price)
values('Dragonclaw Hook','so good!','/images/dragonclawhook.png',68,'2000000');
insert into product(p_label,p_desc,p_image,h_id,p_price)
values('Shadowblade','Shadowblade!','/images/shadowblade.png',57,'1000');

-- Bloodseeker 9
insert into product(p_label,p_image,h_id,p_price)
values('Bloodseeker Bonehunter Skullguard','/images/bloodseeker_bonehunter_skullguard.png',9,5600);
insert into product(p_label,p_image,h_id,p_price)
values('Bloodseeker Chest','/images/bloodseeker_chest.png',9,300);
insert into product(p_label,p_image,h_id,p_price)
values('Bloodseeker Spinal Slicer','/images/bloodseeker_spinal_slicer.png',9,5600);

-- Chaos Knight 15
insert into product(p_label,p_image,h_id,p_price)
values('Chaos Knight Key','/images/chaos_knight_key.png',15,2000);

-- Dragon Knight 25
insert into product(p_label,p_image,h_id,p_price)
values('Dragon Knight Chest','/images/dragon_knight_chest.png',25,3000);
insert into product(p_label,p_image,h_id,p_price)
values('Dragon Knight Key','/images/dragon_knight_key.png',25,2000);

-- Earth Spirit 27
insert into product(p_label,p_image,h_id,p_price)
values('Earth Spirit Key','/images/earth_spirit_key.png',27,3000);

-- Ember Spirit 30
insert into product(p_label,p_image,h_id,p_price)
values('Ember Spirit Key','/images/ember_spirit_key.png',30,3000);

-- Enchantress 31
insert into product(p_label,p_image,h_id,p_price)
values('Enchantress Key','/images/enchantress_key.png',31,3000);

-- Faceless Void 33
insert into product(p_label,p_image,h_id,p_price)
values('Faceless Void Chest','/images/faceless_void_chest.png',33,3000);

-- Bounty Hunter 10
insert into product(p_label,p_image,h_id,p_price)
values('Creepers Cruel Shuriken','/images/gondar_creepers_cruel_shuriken.png',10,12000);
insert into product(p_label,p_image,h_id,p_price)
values('Harvester of the Hidden Hunter','/images/gondar_harvester_of_the_hidden_hunter.png',10,13000);
insert into product(p_label,p_image,h_id,p_price)
values('Shuriken of the Hidden Hunter','/images/gondar_shuriken_of_the_hidden_hunter.png',10,31000);

-- Juggernaut 39
insert into product(p_label,p_image,h_id,p_price)
values('Juggernaut Chest','/images/juggernaut_chest.png',39,3000);

-- KOTL 40
insert into product(p_label,p_image,h_id,p_price)
values('Keeper of the Light Key','/images/keeper_of_the_light_key',40,3000);

-- Natures proh 57
insert into product(p_label,p_image,h_id,p_price)
values(E'Nature\'s Prophet Key','/images/natures_prophet_key.png',57,3000);

-- Omniknight 62
insert into product(p_label,p_image,h_id,p_price)
values('Omniknight Key','/images/omniknight_key.png',62,3000);

-- Shadow Demon 75
insert into product(p_label,p_image,h_id,p_price)
values('Shadow Demon Key','/images/shadow_demon_key.png',75,3000);

-- Sven 86
insert into product(p_label,p_image,h_id,p_price)
values('Sven Chest','/images/sven_chest.png',86,3000);
insert into product(p_label,p_image,h_id,p_price)
values('Fluted Guard of the Swordmaster','/images/sven_fluted_guard_of_the_swordmaster.png',86,3000);
insert into product(p_label,p_image,h_id,p_price)
values('Girth of the Swordmaster','/images/sven_girth_of_the_swordmaster.png',86,3000);
insert into product(p_label,p_image,h_id,p_price)
values('Tayrnhelm of the Swordmaster','/images/sven_tayrnhelm_of_the_swordmaster.png',86,312000);
insert into product(p_label,p_image,h_id,p_price)
values('Wuldastron the TwinBlade of Giants','/images/sven_wuldastron_the_twin_blade_of_giants.png',86,133000);
insert into product(p_label,p_image,h_id,p_price)
values('Courier Dearless Badger','/images/cour_dearless_badger.png',86,30000);
insert into product(p_label,p_image,h_id,p_price)
values('Courier Enduring War Dog','/images/cour_enduring_war_dog.png',86,30000);
insert into product(p_label,p_image,h_id,p_price)
values('Courier Mighty Boar','/images/cour_mighty_boar.png',86,3000);
insert into product(p_label,p_image,h_id,p_price)
values('Courier Moroks Mechanical Mediary','/images/cour_moroks_mechanical_mediary.png',86,312000);
insert into product(p_label,p_image,h_id,p_price)
values('Courier Skip the Delivery Frog','/images/cour_skip_the_delivery_frog.png',86,133000);
insert into product(p_label,p_image,h_id,p_price)
values('Courier Speed Demon','/images/cour_speed_demon.png',86,133000);

insert into product_category(p_id,c_id) values(1,2);
insert into product_category(p_id,c_id) values(107,2);
insert into product_category(p_id,c_id) values(213,2);
insert into product_category(p_id,c_id) values(214,2);
insert into product_category(p_id,c_id) values(215,2);
insert into product_category(p_id,c_id) values(216,2);
insert into product_category(p_id,c_id) values(217,2);
insert into product_category(p_id,c_id) values(218,2);
insert into product_category(p_id,c_id) values(219,2);
insert into product_category(p_id,c_id) values(220,2);
insert into product_category(p_id,c_id) values(221,2);
insert into product_category(p_id,c_id) values(222,2);
insert into product_category(p_id,c_id) values(223,2);
insert into product_category(p_id,c_id) values(224,2);
insert into product_category(p_id,c_id) values(225,2);
insert into product_category(p_id,c_id) values(226,2);
insert into product_category(p_id,c_id) values(227,2);
insert into product_category(p_id,c_id) values(228,2);
insert into product_category(p_id,c_id) values(229,2);
insert into product_category(p_id,c_id) values(230,2);
insert into product_category(p_id,c_id) values(231,2);
insert into product_category(p_id,c_id) values(232,2);
insert into product_category(p_id,c_id) values(233,2);
insert into product_category(p_id,c_id) values(234,2);
insert into product_category(p_id,c_id) values(235,2);
insert into product_category(p_id,c_id) values(236,2);
insert into product_category(p_id,c_id) values(237,2);
insert into product_category(p_id,c_id) values(238,2);
insert into product_category(p_id,c_id) values(239,2);
insert into product_category(p_id,c_id) values(240,2);
insert into product_category(p_id,c_id) values(241,2);
insert into product_category(p_id,c_id) values(242,2);
insert into product_category(p_id,c_id) values(243,2);

insert into shopping_cart(u_id,sc_cost) values(1,10000);
insert into shopping_cart_item(p_id,sc_id,quantity) values(1,1,1);
insert into shopping_cart_item(p_id,sc_id,quantity) values(2,1,1);
insert into transaction(u_id,sc_id) values(1,1);



