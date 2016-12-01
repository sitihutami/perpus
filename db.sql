create database perpus;use perpus;
create table buku(
kode varchar(20)primary key,
judul text not null,
pengarang varchar(40),
penerbit varchar(30),
pakai boolean not null,
masuk date not null
);create table member(
kode varchar(20)primary key,
nama varchar(40)not null,
alamat text not null,
telp varchar(20),
jk varchar(9)not null,
cekal boolean not null
);create table pinjam(
member varchar(20)not null,
buku varchar(20)not null,
ket text not null,
pinjam date not null,
kembali date,
target date not null
);alter table pinjam add foreign key(member)references member(kode)on update cascade on delete cascade;
alter table pinjam add foreign key(buku)references buku(kode)on update cascade on delete cascade;
create table denda(
member varchar(20)not null,
dari date not null,
ke date not null,
bayar int not null
);alter table denda add foreign key(member)references member(kode)on update cascade on delete cascade;
