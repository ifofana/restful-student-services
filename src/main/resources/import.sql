
--insert into Course (id,name,description,start_date,end_date) values(1,'Spring JPA/Hibernate','Spring JPA/Hibernatein 10 Steps',sysdate(),sysdate());
--insert into Student (id, course_id, first_name, last_name, email) values(1,1,'Lionel','Messi','messi.lionel@fi.com');
--insert into Student (id, course_id, first_name, last_name, email) values(2,1,'Andreas','Inniesta','inniesta.andreas@fi.com');
--insert into Student (id, course_id, first_name, last_name, email) values(3,1,'Pique','Bosh','bosh.pique@fi.com');

insert into users(id,username,password,enabled) values(1,'admin','$2a$10$OqQGqcVxiSDuw4qyn0sIUeBi5T69r1Ux.o.0HbIRIIV2tEV8bh9tW',true);
insert into AUTHORITIES(AUTHORITY,USER_ID) values('ROLE_ADMIN',1);

insert into users(id,username,password,enabled) values(2,'user','$2a$10$ONKYdbchPld/sLcIOfg18elUOdgHGt5.zvlnXto/zJrlSA6KjKyWS',true);
insert into AUTHORITIES(AUTHORITY,USER_ID) values('ROLE_USER',2);

insert into users(id,username,password,enabled) values(3,'fofana','$2a$10$H1dGU.URxRAdhu4OTBgvHOphxH8X.1lxvVXvKtjZSkLVVGKkASTBm',true);
insert into AUTHORITIES(AUTHORITY,USER_ID) values('ROLE_STUDENT',3);
insert into AUTHORITIES(AUTHORITY,USER_ID) values('ROLE_TEACHER',3);
