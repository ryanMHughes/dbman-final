# dbman-final
Final project for CSCI 4370


Project Title :

	Lunar Reconaissance Orbiter (LRO) Image Storage

Project Description: 

The LRO satellite is a NASA spacecraft that has been orbiting the Moon since its launch in 2009. The mission of LRO was to capture images of the surface and reconstruct them into 3-D maps at 100-meter resolution. This mission was accomplished, as LRO has constructed these maps for upwards of 98% of the Moon’s surface. An issue arises when thinking about the storage of these images and their associated metadata. Users should be able to access data regarding images, targets (craters), metadata, and other information associated with the data products produced by the mapping mission. 

Solution:

Our solution to the issue is to create a web application that will allow users to view all images and craters, as well as individual images and craters. In this individual view more in depth information will be available, and users will have the ability to create their own datasets. Datasets will include images, craters, their bounding boxes, and metadata associated with images. There will also be a functionality that shows featured images, which are on a daily basis. 

ER Model : 


   The ER Model is included in the file 'CSCI 4370 Final Project'.


ER to Table Conversion :

   
   Todo: Constaints on each attrib

   Table Images (
   	  image_id int unique <pk>,
	  url varchar(200),
	  bounding_box_id int,
	  metadata_id int <fk>
   );	  	  	  

   Table LandingSites (
   	  landing_site_name int unique <pk>,
	  description varchar(300),
	  mission varchar(50),
	  bounding_box_id int <fk>
   );

   Table BoundingBox (
   	 bounding_box_id int unique <pk>,
	 min_lat int,
	 max_lat int,
	 min_long int,
	 max_long int
   );

   Table MetaData (
   	 metadata_id int unique <pk>,
	 metadata_data varchar(1000)
   );

   Table DataSet (
   	 dataset_id int unique <pk>
	 image_id int <fk>
   );

   Table DataSet_Data (
   	 dataset_data_id int unique <pk>
	 dataset_id int <fk>
   );

   Table FeaturedImages (
   	 featured_image_id int unique <pk>
	 image_id int <fk>
	 description varchar(300)
	 date datetime
   );

   Table Users (
   	 user_id int unique <pk>,
	 dataset_id int <fk>
   );

Normalizing Tables :

   Initial Functional Dependencies :

   	      F = {
   	      	image_id -> url, bounding_box_id
		bounding_box_id -> min_lat, max_lat, min_long, max_long
		landing_site_name -> description, mission, bounding_box_id
		metadata_id -> metadata_data
		dataset_data_id -> dataset_id
		dataset_id -> image_id
		featured_image_id -> image_id, description, date

		user_id -> data_set_id
		metadata_id -> image_id
		user_id, dataset_id -> image_id
	      }

   Performing 3NF Synthesis

   	      1) Finding minimal basis

	      a) Split RHS of each FD into single attribute

	      	 image_id -> url
		 image_id -> bounding_box_id

		 bounding_box_id -> min_lat
		 bounding_box_id -> max_lat
		 bounding_box_id -> min_long
		 bounding_box_id -> max_long

		 landing_site_name -> LS_description
		 landing_site_name -> mission
		 landing_site_name -> bounding_box_id

		 metadata_id -> metadata_data
		 
		 dataset_data_id -> dataset_id

		 featured_image_id -> image_id
		 featured_image_id -> FI_description
		 featured_image_id -> date

		 user_id -> data_set_id

	      b) Trying to remove one attribute at a time from LHS of each FD

	      c) Trying to remove each FD to see if remaining FDs can infer the deleted FD


	      2) Merge FDs with the same LHS


	      3) Form a table for each FD

	      4) If one table is a subset of the other, remove the subset table

	      5) Make sure at least one table has the global key. If not, add table with the global key.
	      
	

Planned Queries :

	Get
	  1) 
	  2)
	Delete
	  3)
	Update
	  5)
	Insert
	  6)

Technologies Used :
				
	Java, Spring Boot, JDBC Connection, Docker / mySQL, Maven
