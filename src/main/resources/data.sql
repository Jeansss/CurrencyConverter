CREATE TABLE "users" (
  "id" SERIAL PRIMARY KEY,
  "ip" varchar,
  "origin_currency" varchar,
  "currency_destination" varchar,
  "value" bigint,
  "converted_value" bigint
);