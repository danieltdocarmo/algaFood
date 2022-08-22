insert into kitchen (id, name) values ('1ad932c9-6552-48b1-a845-c30f99a923d0', 'Brasileira');
insert into kitchen (id, name) values ('1ad932c9-6552-48b1-a845-c30f99a923d1', 'Japonesa');

insert into restaurant  values ('1ad932c9-6552-48b1-a845-c30f99a923d3', '1.0', 'Coco Bambu', '1ad932c9-6552-48b1-a845-c30f99a923d0');
insert into restaurant values ('1ad932c9-6552-48b1-a845-c30f99a923d4', '2.0', 'Manga', '1ad932c9-6552-48b1-a845-c30f99a923d1');

insert into payment_form (id, description) values ('1ad932c9-6552-48b1-a845-c30f99a923d9', 'C');
insert into payment_form (id, description) values ('1ad932c9-6552-48b1-a845-c30f99a923d5', 'D');

insert into restaurant_payment_forms (restaurant_id, payment_forms_id) values ('1ad932c9-6552-48b1-a845-c30f99a923d3', '1ad932c9-6552-48b1-a845-c30f99a923d9')
insert into restaurant_payment_forms (restaurant_id, payment_forms_id) values ('1ad932c9-6552-48b1-a845-c30f99a923d4', '1ad932c9-6552-48b1-a845-c30f99a923d5')