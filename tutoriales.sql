/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     7 jul. 2023 22:52:24                         */
/*==============================================================*/


drop index CLIENTE_PK;

drop table CLIENTE;

drop index RELATIONSHIP_1_FK;

drop index SEGUIMIENTO_PK;

drop table SEGUIMIENTO;

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   ID_CLIENTE           SERIAL               not null,
   CLI_CEDULA           VARCHAR(10)          null,
   CLI_NOMBRE           VARCHAR(150)         null,
   CLI_CONTACTO         VARCHAR(20)          null,
   CLI_DIRECCION        VARCHAR(150)         null,
   CLI_CORREO           VARCHAR(150)         null,
   constraint PK_CLIENTE primary key (ID_CLIENTE)
);

/*==============================================================*/
/* Index: CLIENTE_PK                                            */
/*==============================================================*/
create unique index CLIENTE_PK on CLIENTE (
ID_CLIENTE
);

/*==============================================================*/
/* Table: SEGUIMIENTO                                           */
/*==============================================================*/
create table SEGUIMIENTO (
   ID_SEGUIMIENTO       SERIAL               not null,
   ID_CLIENTE           INT4                 null,
   SEG_FECHA            DATE                 null,
   SEG_OBSERVACION      VARCHAR(250)         null,
   constraint PK_SEGUIMIENTO primary key (ID_SEGUIMIENTO)
);

/*==============================================================*/
/* Index: SEGUIMIENTO_PK                                        */
/*==============================================================*/
create unique index SEGUIMIENTO_PK on SEGUIMIENTO (
ID_SEGUIMIENTO
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_1_FK on SEGUIMIENTO (
ID_CLIENTE
);

alter table SEGUIMIENTO
   add constraint FK_SEGUIMIE_RELATIONS_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE)
      on delete restrict on update restrict;

