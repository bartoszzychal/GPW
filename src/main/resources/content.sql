insert into client(account_number,account_password) value (2000,4567);
insert into account(id_client, account_number,account_password) value (1,2000,4567);
insert into broker(account_number,account_password) value (1000,1234);
insert into account(id_client, account_number,account_password) value (1,1000,1234);
insert into funds(currency,fund,account_id) value (1,5000,1);
insert into funds(currency,fund,account_id) value (0,1250,1);
insert into funds(currency,fund,account_id) value (1,100000,2);
LOAD DATA LOCAL INFILE 'src/main/resources/dane.csv' INTO TABLE `company` FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' (`name`, @dummy, @dummy);
LOAD DATA LOCAL INFILE 'src/main/resources/dane.csv' INTO TABLE `stock_quotation` FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' (`company`, `date`,`quotation` );
INSERT INTO `currency` (`currency`, `date`, `rate`) SELECT 0, tmp.date, round(rand(4)/5,6)+3.9 as rate FROM (SELECT distinct stock_quot.date FROM `stock_quotation` as stock_quot)tmp;
INSERT INTO `currency` (`currency`, `date`, `rate`) SELECT 1, tmp.date, 1 as rate FROM (SELECT distinct stock_quot.date FROM `stock_quotation` as stock_quot)tmp;
INSERT INTO `daily` (`date`) SELECT tmp.date FROM (SELECT distinct stock_quot.date FROM `stock_quotation` as stock_quot)tmp;