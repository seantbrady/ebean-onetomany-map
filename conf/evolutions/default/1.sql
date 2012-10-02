# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table role (
  id                        bigint not null,
  user_id                   bigint not null,
  organization_id           bigint,
  constraint pk_role primary key (id))
;

create table user (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_user primary key (id))
;

create sequence role_seq;

create sequence user_seq;

alter table role add constraint fk_role_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_role_user_1 on role (user_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists role;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists role_seq;

drop sequence if exists user_seq;

