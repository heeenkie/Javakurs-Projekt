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
  "MENYID" INTEGER NOT NULL PRIMARY KEY,
  "DESCRIPTION" VARCHAR(64),
  "PRICE" DOUBLE
);

CREATE TABLE "STORAGE" (
    "STORAGEID" INTEGER NOT NULL PRIMARY KEY,
    "DRY" VARCHAR(15),
    "FROZEN" VARCHAR(15),
    "FRIDGE" VARCHAR(15)
);