# Basic SpringBoot CRUD operation with MongoDB cloud - ATLAS.

- First go to given URL, and signup for creating your mongodb atlas account(at least Try Free Version) : https://cloud.mongodb.com/

- After creating free(upto 512MB free)/paid account and provide username/password, create your own clustor(or leave the default Clustor0). 
Then go to database -> connect -> connect your application -> set the driver as JAVA and version of mongodb you want. 
Now copy the URL from "Add your connection string into your application code" and paste it to your application.properties
file with amending your own mongodb username/passcode in that URL.

- Now create your spring boot mongodb CRUD operation, and test it with POSTMAN tool.

- For example, here we created a TASK entity for Agile process, with taskId, taskName, description, severity, assignee, storyPoint.
Now write your corresponding Controller(to handle all Web Request), Service(to write logic of Create, Read, Update, Delete of Task entity)
and Repository(to save our data in mongoDB).

- CREATE :
 ![](https://github.com/AadityaUoHyd/SpringBoot-MongoDb/blob/master/springBoot-Atlas-MongoDb-Crud/createTask.jpg)
 
- GET All Tasks :
![](https://github.com/AadityaUoHyd/SpringBoot-MongoDb/blob/master/springBoot-Atlas-MongoDb-Crud/grtAll.jpg)

- GET one Task by providing its taskId : 
![](https://github.com/AadityaUoHyd/SpringBoot-MongoDb/blob/master/springBoot-Atlas-MongoDb-Crud/get_by_id.jpg)

- GET List of Tasks by providing its assignee name :
![](https://github.com/AadityaUoHyd/SpringBoot-MongoDb/blob/master/springBoot-Atlas-MongoDb-Crud/assignee.jpg)

- GET List of Tasks by based on story-point :
![](https://github.com/AadityaUoHyd/SpringBoot-MongoDb/blob/master/springBoot-Atlas-MongoDb-Crud/story-point.jpg)

- UPDATE your Task :
![](https://github.com/AadityaUoHyd/SpringBoot-MongoDb/blob/master/springBoot-Atlas-MongoDb-Crud/update.jpg)

- DELETE the Task you want by providing its taskId :
![](https://github.com/AadityaUoHyd/SpringBoot-MongoDb/blob/master/springBoot-Atlas-MongoDb-Crud/delete.jpg)

- View your ATLAS CLOUD MONGODB :
![](https://github.com/AadityaUoHyd/SpringBoot-MongoDb/blob/master/springBoot-Atlas-MongoDb-Crud/mongodb-atlas.jpg)
