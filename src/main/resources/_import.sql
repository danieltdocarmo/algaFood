insert into state values ('1ad932c9-6552-48b1-a845-c30f99a923b1', 'Ceara')
insert into city values ('1ad932c9-6552-48b1-a845-c30f99a923a1', 'Fortaleza', '1ad932c9-6552-48b1-a845-c30f99a923b1')

insert into kitchen (id, name) values ('1ad932c9-6552-48b1-a845-c30f99a923d0', 'Brasileira');
insert into kitchen (id, name) values ('1ad932c9-6552-48b1-a845-c30f99a923d1', 'Japonesa');

insert into restaurant (id, delivery_tax, name, kitchen_id, created_at, updated_at) values ('6b4bc2ca-ccdc-4789-a21a-91d6887732a1', '1.0', 'Coco Bambu', '1ad932c9-6552-48b1-a845-c30f99a923d0', current_timestamp, current_timestamp);
insert into restaurant (id, delivery_tax, name, kitchen_id, created_at, updated_at) values ('3c9f0e9c-9a3c-479d-843c-51a965351efc', '2.0', 'Manga', '1ad932c9-6552-48b1-a845-c30f99a923d1', current_timestamp, current_timestamp);

insert into payment_form (id, description) values ('1ad932c9-6552-48b1-a845-c30f99a923d9', 'C');
insert into payment_form (id, description) values ('1ad932c9-6552-48b1-a845-c30f99a923d5', 'D');

insert into restaurant_payment_forms (restaurant_id, payment_forms_id) values ('6b4bc2ca-ccdc-4789-a21a-91d6887732a1', '1ad932c9-6552-48b1-a845-c30f99a923d9')
insert into restaurant_payment_forms (restaurant_id, payment_forms_id) values ('3c9f0e9c-9a3c-479d-843c-51a965351efc', '1ad932c9-6552-48b1-a845-c30f99a923d5')

insert into product (id, name, description, price, is_active, restaurant_id) values ('1ad932c9-6552-48b1-a845-c30f99a923c1', 'Camarao Internacional', 'Arroz Cremoso', 100.0, true, '6b4bc2ca-ccdc-4789-a21a-91d6887732a1')