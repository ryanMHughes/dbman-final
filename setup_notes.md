

move the csv to /var/lib/mysql-files/
move the sql file to /data_files

run:

soure /data_files/sql_code.sql

then insert into featured images:

insert into FeaturedImages (title, description, feature_date, image_id) values ('awesome image', 'very fun cool thing!', '01-02-03 03:33:53', 'M101017944RC');
