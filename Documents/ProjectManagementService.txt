Project Management Service (Goutham)

REST Endpoint Documentation




### Request handler methods for  POST operations on Project Management
POST
http://172.23.238.190:8890/Project/addproject
{
	 adds a project to the list of projects in mongoDb else shows Customexception
	
}
### Request handler methods for  PUT operations on Project Management
PUT
http://172.23.238.190:8890/Project/updateproject
{
updates a project to the list of projects in mongoDb else shows Customexception
	
	
}


### Request handler methods for  GET operations on Project Management
GET
http://172.23.238.190:8890/Project/list
{
	Retrives Projects from mongoDb and shows a list of projects else shows Customexception
	
	
}
GET
http://172.23.238.190:8890/Project/show/{Id}
{
	Retrives Data from mongoDb and shows the project with matching id from the list of projects else shows Projectnotfoundexception
	
	
}

GET
http://172.23.238.190:8890/Project/show/productid/{ProductId}
{
	Retrives Data from mongoDb and shows the project with matching productid from the list of projects  shows Projectnotfoundexception
}


### Request handler methods for  d operations on Project Management
DELETE
http://172.23.238.190:8890/Project//delete/{id}
{
	Delete a  Project details from the list of projects
	
}

