CREATE TABLE product.t_product (
   id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   article_name VARCHAR(255),
   quantity VARCHAR(255),
   category VARCHAR(255),
   material VARCHAR(255),
   carat VARCHAR(255),
   hallmark_id VARCHAR(255),
   weight DOUBLE PRECISION,
   material_cost_price DOUBLE PRECISION,
   article_cost_price DOUBLE PRECISION,
   material_sell_price DOUBLE PRECISION,
   article_sell_price DOUBLE PRECISION,
   article_making_cost_price DOUBLE PRECISION,
   article_making_sell_price DOUBLE PRECISION,
   article_material_percentage DOUBLE PRECISION,
   hallmark BOOLEAN,
   CONSTRAINT pk_t_product PRIMARY KEY (id)
);