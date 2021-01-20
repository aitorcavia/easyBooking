/* DELETE 'easyBookingDB' database*/
DROP SCHEMA easybookingdb;
/* DELETE USER 'sd' AT LOCAL SERVER*/
DROP USER 'bookings_user'@'%';


/* CREATE ''easyBookingDB' DATABASE */
CREATE SCHEMA easyBookingDB;
/* CREATE THE USER 'bookings_user' AT LOCAL SERVER WITH PASSWORD 'password' */
CREATE USER 'bookings_user'@'%' IDENTIFIED BY 'password';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'bookings_user' AT LOCAL SERVER*/
GRANT ALL ON easyBookingDB.* TO 'bookings_user'@'%';