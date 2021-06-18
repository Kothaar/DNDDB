-- tables
-- table: weapon
CREATE SEQUENCE public.weapon_id_seq;
CREATE TABLE weapon (
	id bigint NOT NULL DEFAULT nextval('weapon_id_seq') PRIMARY KEY,
	name varchar(50) NOT NULL,
	cost int,
	number_dice int,
	dice_type int,
	damage_type varchar(16),
	weight int
);

-- table: property
CREATE SEQUENCE public.property_id_seq;
CREATE TABLE property (
	id bigint NOT NULL DEFAULT nextval('property_id_seq') PRIMARY KEY,
	name varchar(32) NOT NULL,
	description varchar(MAX)
);

-- table: weapon_property
CREATE TABLE weapon_property (
	weaponid bigint NOT NULL REFERENCES public.weapon(id),
	propertyid bigint NOT NULL REFERENCES public.property(id),
    constraint weapon_property_pkey PRIMARY KEY (weaponid, propertyid)
);