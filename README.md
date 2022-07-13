# mendonca-mediaplay

Hi, this is the last version of the Mendonca Media Play that I develop. I created this project in order to demonstrate some concepts by using music files stored
Into the database with also security features and relation between music and users.

To set up the project fist you have to have the follow tools installed:
Java 11
MySQL database.

Once you have these two tools installed in your machine download the project in the machine export as maven project download the dependences run the project. 
Once the project is running in your machine. Open the database an search for the table called  tbl_user

![plot](https://raw.githubusercontent.com/gabriekq/mendonca-mediaplay/create-user-relation/src/main/resources/img/user-table.JPG)

This table (tbl_user) is going to be responsible for authenticate the user into the system.

Once you insert manually a row like the example above the project is going to be ready to work.  

Afther the login part you are going to be able to see this page.

![plot](https://raw.githubusercontent.com/gabriekq/mendonca-mediaplay/create-user-relation/src/main/resources/img/mendonca-media-play.JPG)

if you want to save an new music in the system you are going to acesses that page called /sendMusic and attached the music file.

![plot](https://raw.githubusercontent.com/gabriekq/mendonca-mediaplay/create-user-relation/src/main/resources/img/file-upload.JPG)

Observation to be able to save a music in the database I had to change some configuration in the database to allow inserting large amount
of data into a column.

At my case the configuration was to add the --max-allowed-packet flag at the docker configuration.

docker container run -d --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password mysql:5.7 --max-allowed-packet=67108864
