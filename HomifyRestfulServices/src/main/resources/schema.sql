create table contact
(
  contactid integer not null,
  phone varchar(250) not null,
  email varchar(250),
  website varchar(250),
  city varchar(250),
  country varchar(250),
  
  primary key(contactid)
);

create table professional
(
  professionalid integer not null,
  firstname varchar(250) not null,
  lastname varchar(250),
  header varchar(250),
  username varchar(250),
  companyname varchar(250),
  latitude integer,
  longitude integer,
  updateddate timestamp,
  prof_contactid integer,
  types varchar(250),
  
  primary key(professionalid)

);

ALTER TABLE PROFESSIONAL ADD FOREIGN KEY (prof_contactid) REFERENCES CONTACT(contactid);

create table project
(
  projectid integer not null,
  header varchar(250) not null,
  title varchar(250),
  description varchar(250),
  duration varchar(250),
  types varchar(250),
  project_ownerid integer,
  
  primary key(projectid),

  CONSTRAINT FK_PROJOWN  FOREIGN KEY (project_ownerid) REFERENCES PROFESSIONAL(professionalid)
);
