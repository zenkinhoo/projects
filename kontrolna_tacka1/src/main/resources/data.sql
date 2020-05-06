
INSERT INTO KORISNIK (password,name,surname,contact_tel,email,Date,role,active,user_name,dtype) 
VALUES ('12345', 'Lazar','Mitrovic','555-333','asd@gmail.com','12.02.1995',1,true,'zenki',1);
INSERT INTO KORISNIK (password,name,surname,contact_tel,email,Date,role,active,user_name,dtype) 
VALUES ('asdff5', 'Mitar','Lazarevic','333-333','asggsa@gmail.com','12.05.1991',3,false,'kinez',1);
INSERT INTO KORISNIK (password,name,surname,contact_tel,email,Date,role,active,user_name,dtype) 
VALUES ('ff15', 'Milos','Mitrovic','066931','asdf@gmail.com','22.02.1925',2,true,'nadimak',1);

INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena) 
VALUES ('Apsolutnih 100', 'Strelac','Drama',1.5,8.8);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena) 
VALUES ('Memento', 'Gubitak pamcenja','Triler',2.1,9.0);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena) 
VALUES ('Kum', 'Mafija','Drama',3,9.5);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena) 
VALUES ('Conjuring', 'Lutka','Horror',2,8.4);

INSERT INTO BIOSKOP (naziv,adresa,br_centrale,email,manager_id) 
VALUES ('Kvart', 'Omladinska','12345','asd@gmail.com',3);
INSERT INTO BIOSKOP (naziv,adresa,br_centrale,email,manager_id) 
VALUES ('Skopbio', 'Dunavska','54321','ff@gmail.com',3);

INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (2000,'A',1);
INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (1000,'B',1);
INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (400,'C',2);

INSERT INTO PROJEKCIJA (dan,cena) 
VALUES ('27.05.2020',300);
INSERT INTO PROJEKCIJA (dan,cena) 
VALUES ('27.06.2020',450);
INSERT INTO PROJEKCIJA (dan,cena) 
VALUES ('22.05.2020',700);
