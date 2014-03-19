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
p_label text UNIQUE,
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
insert into product(p_label,p_desc,p_image,h_id,p_price)
values('Dragonclaw Hook','so good!','/images/dragonclawhook.png',68,'2000000');
insert into product(p_label,p_desc,p_image,h_id,p_price)
values('Shadowblade','Shadowblade!','/images/shadowblade.png',57,'1000');

insert into product_category(p_id,c_id) values(1,2);
insert into product_category(p_id,c_id) values(2,2);
insert into shopping_cart(u_id,sc_cost) values(1,10000);
insert into shopping_cart_item(p_id,sc_id,quantity) values(1,1,1);
insert into shopping_cart_item(p_id,sc_id,quantity) values(2,1,1);
insert into transaction(u_id,sc_id) values(1,1);



