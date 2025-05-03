
create Table BoundingBox (
       bounding_box_id int unique,
       min_lat int,
       max_lat int,
       min_long int,
       max_long int,
       primary key (bounding_box_id)
);

create Table Images (
       image_id int unique,
       url varchar(300),
       bounding_box_id int,
       metadata_data varchar(1000),
       primary key (image_id),
       foreign key (bounding_box_id) References BoundingBox
);

create Table LandingSites (
       landing_site_name varchar(50) unique,
       LS_description varchar(300),
       mission varchar(50),
       bounding_box_id int,
       primary key (landing_site_name),
       foreign key (bounding_box_id) references BoundingBox
);

create Table FeaturedImages(
       featured_image_id int unique,
       FI_description varchar(300),
       date datetime,
       image_id int,
       primary key (featured_image_id),
       foreign key (image_id) references Images
);
