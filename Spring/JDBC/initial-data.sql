CREATE TABLE region.jc_region
(
  region_id bigserial NOT NULL,
  region_name character varying(255),
  CONSTRAINT jc_region_pkey PRIMARY KEY (region_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE region.jc_region
  OWNER TO postgres;



CREATE TABLE region.jc_city
(
  city_id bigserial NOT NULL,
  city_name character varying(255),
  region_id bigint NOT NULL,
  CONSTRAINT jc_city_pkey PRIMARY KEY (city_id),
  CONSTRAINT jc_city_fkey_region FOREIGN KEY (region_id)
      REFERENCES region.jc_region (region_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE region.jc_city
  OWNER TO postgres;



INSERT INTO region.jc_region(region_name) VALUES ('Moscow');
INSERT INTO region.jc_region(region_name) VALUES ('Leningrad');
INSERT INTO region.jc_region(region_name) VALUES ('Voronezh');


INSERT INTO region.jc_city(city_name, region_id) VALUES ('Moscow', 1);
INSERT INTO region.jc_city(city_name, region_id) VALUES ('Dmitrov', 1);
INSERT INTO region.jc_city(city_name, region_id) VALUES ('Stupino', 1);
INSERT INTO region.jc_city(city_name, region_id) VALUES ('Himki', 1);
INSERT INTO region.jc_city(city_name, region_id) VALUES ('Shatura', 1);
INSERT INTO region.jc_city(city_name, region_id) VALUES ('Saint-Petersburg', 2);
INSERT INTO region.jc_city(city_name, region_id) VALUES ('Luga', 2);
INSERT INTO region.jc_city(city_name, region_id) VALUES ('Boksitogorsk', 2);
INSERT INTO region.jc_city(city_name, region_id) VALUES ('Viborg', 2);
INSERT INTO region.jc_city(city_name, region_id) VALUES ('Svetogorsk', 2);
INSERT INTO region.jc_city(city_name, region_id) VALUES ('Voronezh', 3);
INSERT INTO region.jc_city(city_name, region_id) VALUES ('Bobrov', 3);
INSERT INTO region.jc_city(city_name, region_id) VALUES ('Liski', 3);
