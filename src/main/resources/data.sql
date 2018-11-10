delete
from TACO_ORDER_TACOS;

delete
from TACO_INGREDIENTS;

delete
from TACO;

delete
from TACO_ORDER;

delete
from INGREDIENT;

insert into INGREDIENT (ID, NAME, TYPE)
values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into INGREDIENT (ID, NAME, TYPE)
values ('COTO', 'Corn Tortilla', 'WRAP');
insert into INGREDIENT (ID, NAME, TYPE)
values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into INGREDIENT (ID, NAME, TYPE)
values ('CARN', 'Carnitas', 'PROTEIN');
insert into INGREDIENT (ID, NAME, TYPE)
values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into INGREDIENT (ID, NAME, TYPE)
values ('LETC', 'Lettuce', 'VEGGIES');
insert into INGREDIENT (ID, NAME, TYPE)
values ('CHED', 'Cheddar', 'CHEESE');
insert into INGREDIENT (ID, NAME, TYPE)
values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into INGREDIENT (ID, NAME, TYPE)
values ('SLSA', 'Salsa', 'SAUCE');
insert into INGREDIENT (ID, NAME, TYPE)
values ('SRCR', 'Sour Cream', 'SAUCE');
