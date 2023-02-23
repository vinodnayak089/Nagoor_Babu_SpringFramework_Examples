create table tiles_img_table(
design_no varchar(20) primary key,
tile_img blob
);
commit;
clear screen;

select * from tiles_img_table;

create table tiles_docs(
doc_no varchar(20) primary key,
doc_conf clob
);

select * from tiles_docs;

create table customer_tiles_table(
cid number  primary key,
cname varchar(20),
cus_Img blob,
cus_Resume clob
);

 select *from customer_tiles_table;






