/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  andreashenriksson
 * Created: 2019-nov-15
 */

CREATE TABLE "MENY" (
  "MENYID" INT NOT NULL,
  "DESCRIPTION" VARCHAR(30),
  "PRICE" INTEGER
);

CREATE TABLE "STORAGE" (
    "ID" INTEGER,
    "DRY" VARCHAR(15),
    "FROZEN" VARCHAR(15),
    "FRIDGE" VARCHAR(15)
);