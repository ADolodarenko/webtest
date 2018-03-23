use test
go

if object_id('bunny') is not null
  drop table dbo.bunny
go
create table dbo.bunny(
  id int identity,
  name varchar(128) not null,
  password varchar(128) null,
  description varchar(255) null,
  image_file varchar(255) null,
  constraint pk_bunny primary key clustered (id)
)
go
create index idx_bunny_name on dbo.bunny (name)
go

insert bunny(name, password, description) values ('dolodarenko', 'luisiana969', 'Alex Dolodarenko')
go

