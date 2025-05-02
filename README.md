# dbman-final
Final project for CSCI 4370


Project Title :

	Lunar Reconaissance Orbiter (LRO) Image Storage

Project Description: 

	The LRO satellite is a NASA spacecraft that has been orbiting the Moon since its launch in 2009. The mission of LRO was to capture images of the surface and reconstruct
	them into 3-D maps at 100-meter resolution. This mission was accomplished, as LRO has constructed these maps for upwards of 98% of the Moon’s surface. An issue arises when
	thinking about the storage of these images and their associated data (time, location, etc). It is important that the data itself and its metadata are properly stored such that
	researchers and users alike can access images, and know which location on the Moon they are associated with. 

Solution:

	Our solution for this problem is to create a database that will store the image data (through references to file urls?) and metadata that is associated with each image. This
	metadata will include information about what time each image was collected, what instrument type was used, the associated location on the lunar surface, and more. Users will be
	able to interact with the database via a web application. 

ER Model : 





ER to Table Conversion :

	Instruments(instrument_id, instrument_type, instrument_desc)
	Images(image_id, image_file_name, image_file_size, instrument_id)
	Target(target_id, target_name, target_lat, target_long, target_alt)
	MetaData(product_id, observation_time, product_creation_time, image_id  target_id)

Functional Dependencies :


	  
3NF Decomposed Relations and Functional Dependencies :


Database Schema

	 create Table Instruments (
	 	int instrument_id,
		char(30) instrument_type not null,
		char(300) instrument_desc,
		primary key(instrument_id)
	);

	create Table Images (
	       int image_id,
	       char(50) image_file_name,
	       int image_file_size,
	       int instrument_id,
	       primary key(image_id),
	       foreign key(instrument_id) references Instrument	       
	);

	create Table Target (
	       int target_id,
	       char(30) target_name,
	       int target_lat not null,
	       int target_long not null,
	       int target_alt not null,
	       primary key(target_id)
	);

	create Table MetaData (
	       int product_id,
	       datetime observation_time,
	       datetime product_creation_time,
	       int target_id,
	       int image_id,
	       primary key(product_id),
	       foreign key(target_id) references Targets,
	       foreign key(image_id) references Images
	);

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
