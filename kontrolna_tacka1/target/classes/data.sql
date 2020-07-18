
INSERT INTO GLEDALAC (password,name,surname,email,role,user_name,active,Date,contact_tel) 
VALUES ('12345', 'Lazar','Mitrovic','asd@gmail.com','gledalac','znk',true,'12.5.2005','1234556');
INSERT INTO GLEDALAC (password,name,surname,email,role,user_name,active,Date,contact_tel) 
VALUES ('ninja', 'Naruto','Uzumaki','naruto@gmail.com','gledalac','nar',true,'21.12.2012','1234556');

INSERT INTO GLEDALAC (password,name,surname,email,role,user_name,active,Date,contact_tel) 
VALUES ('1231', 'Kinez','Mitrovic','kinez@gmail.com','gledalac','knz',true,'21.12.2022','060001123');


INSERT INTO MENADZER (user_name,password,name,surname,Role,active,Date,email,contact_tel) 
VALUES ('zen','kinez','mitar','mitvic','Menadzer',true,'12.02.2002.','ggg@gmail.com','555123');
INSERT INTO MENADZER (user_name,password,name,surname,Role,active,Date,email,contact_tel) 
VALUES ('zenki','1234','lazar','tarmic','Menadzer',true,'12.02.2006.','wp@gmail.com','333555');

INSERT INTO ADMINISTRATOR (user_name,password,name,surname,Role,active,Date,email,contact_tel) 
VALUES ('zenkux','1223','miljan','mitrovic','Administrator',true,'12.02.2004.','miljanus@gmail.com','666333');

INSERT INTO BIOSKOP (naziv,adresa,br_centrale,email,manager_id) 
VALUES ('Kvart', 'Omladinska','12345','asd@gmail.com',1);
INSERT INTO BIOSKOP (naziv,adresa,br_centrale,email,manager_id) 
VALUES ('Skopbio', 'Dunavska','54321','ff@gmail.com',2);
INSERT INTO BIOSKOP (naziv,adresa,br_centrale,email,manager_id) 
VALUES ('Sinepleks', 'Centarska','4455','surr@gmail.com',2);
INSERT INTO BIOSKOP (naziv,adresa,br_centrale,email,manager_id) 
VALUES ('Skopbio', 'Dunavska','54321','ff@gmail.com',2);
INSERT INTO BIOSKOP (naziv,adresa,br_centrale,email,manager_id) 
VALUES ('Sinepleks', 'Centarska','4455','surr@gmail.com',1);


INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Kum', 'Mafija','Drama',3,9.5,true);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Apsolutnih 100', 'Strelac','Drama',1.5,8.8,false);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Memento', 'Gubitak pamcenja','Triler',2.1,9.0,true);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Conjuring', 'Lutka','Horror',2,8.4,true);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Mi nismo andjeli 2', 'Andjeli','Komedija',2,0,true);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Phone booth', 'phone','Thriller',1.5,0,false);


INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (1,10,'27.05.2020',300,'18:00',true);
INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (2,25,'22.05.2020',200,'17:00',false);
INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (3,100,'27.09.2010',400,'19:00',false);
INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (4,150,'12.05.2015',380,'20:00',true);
INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (5,22,'7.7.2014',750,'18:00',true);
INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (6,258,'17.11.2020',555,'18:00',true);

INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (2000,'A',1);

INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (400,'C',2);
INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (1000,'D',3);
INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (1000,'AH',4);
INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (1000,'A4',5);


