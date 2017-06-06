-- Table: minususer

-- DROP TABLE minususer;

CREATE TABLE minususer
(
  id bigserial NOT NULL,
  email character varying(255) NOT NULL,
  firstname character varying(255) NOT NULL,
  image character varying(255),
  lastname character varying(255) NOT NULL,
  password character varying(255) NOT NULL,
  username character varying(255) NOT NULL,
  CONSTRAINT minususer_pkey PRIMARY KEY (id),
  CONSTRAINT uk_as7to1hpsoqtgprmgs362ko1s UNIQUE (email),
  CONSTRAINT uk_e7e7l66jtubtrs04qrevp8bp3 UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE minususer
  OWNER TO postgres;
  
-- Table: item

-- DROP TABLE item;

CREATE TABLE item
(
  id bigserial NOT NULL,
  name character varying(255),
  price numeric(19,2),
  quantity integer,
  CONSTRAINT item_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE item
  OWNER TO postgres;

-- Table: bill

-- DROP TABLE bill;

CREATE TABLE bill
(
  id bigserial NOT NULL,
  date character varying(255),
  issuer character varying(255),
  location character varying(255),
  name character varying(255),
  price numeric(19,2),
  minususer bigint,
  CONSTRAINT bill_pkey PRIMARY KEY (id),
  CONSTRAINT fk9ckmbmxxycwvw0tpsx3nnfqv0 FOREIGN KEY (minususer)
      REFERENCES minususer (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bill
  OWNER TO postgres;

-- Table: bill_items

-- DROP TABLE bill_items;

CREATE TABLE bill_items
(
  bill_id bigint NOT NULL,
  items_id bigint NOT NULL,
  CONSTRAINT fk8n7p8k20phsuio26712mqj7vn FOREIGN KEY (items_id)
      REFERENCES item (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkcuivl4revwmd0iy4kjkpb94vk FOREIGN KEY (bill_id)
      REFERENCES bill (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_icvk8usl48c4jqqn14s998svu UNIQUE (items_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bill_items
  OWNER TO postgres;
