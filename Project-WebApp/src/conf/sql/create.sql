/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  andreashenriksson
 * Created: 2019-nov-15
 */

CREATE TABLE CUSTOMER (
  CUSTOMERID INT(4) NOT NULL,
  NAME VARCHAR(30),
  ADRESS VARCHAR(30),
  CITY VARCHAR(20),
  STATE VARCHAR(20),
  ZIPCODE INT(5) NOT NULL,
  PN INT(15),
  FAX INT(8)
);

