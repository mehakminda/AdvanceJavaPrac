create table tourist(
                        tId int(10)  Primary key,
                        tName varchar(50) ,
                        city varchar(50),
                        packageType varchar(100) ,
                        budget float
);
ALTER TABLE Tourist MODIFY tId BIGINT AUTO_INCREMENT;// this might be optional step.. check