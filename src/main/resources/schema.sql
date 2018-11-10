create table if not exists INGREDIENT (
  ID   varchar(4)  not null,
  NAME varchar(25) not null,
  TYPE varchar(10) not null
);

create table if not exists TACO (
  ID         varchar(36),
  NAME       varchar(50) not null,
  CREATED_AT timestamp   not null
);

create table if not exists TACO_INGREDIENTS (
  TACO_ID       varchar(36) not null,
  INGREDIENT_ID varchar(4)  not null
);

alter table TACO_INGREDIENTS
  add foreign key (TACO_ID) references TACO (ID);

alter table TACO_INGREDIENTS
  add foreign key (INGREDIENT_ID) references INGREDIENT (ID);

alter table TACO_INGREDIENTS
  add unique (TACO_ID, INGREDIENT_ID) check;

create table if not exists TACO_ORDER (
  ID                           identity,
  RECIPIENT_NAME               varchar(50) not null,
  RECIPIENT_STREET             varchar(50) not null,
  RECIPIENT_CITY               varchar(50) not null,
  RECIPIENT_STATE              varchar(2)  not null,
  RECIPIENT_ZIP                varchar(10) not null,
  CREDIT_CARD_NUMBER           varchar(16) not null,
  CREDIT_CARD_EXPIRATION_DATE  varchar(5)  not null,
  CREDIT_CARD_VALIDATION_VALUE varchar(3)  not null,
  PLACED_AT                    timestamp   not null
);

create table if not exists TACO_ORDER_TACOS (
  ORDER_ID bigint not null,
  TACO_ID  bigint not null
);

alter table TACO_ORDER_TACOS
  add foreign key (ORDER_ID) references TACO_ORDER (ID);

alter table TACO_ORDER_TACOS
  add foreign key (TACO_ID) references TACO (ID);
