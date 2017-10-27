Workflow Engine Service (Shekhar Prasad Rajak)

REST Endpoint Documentation

#### to trigger the clone the git url, generate JenkinsFile and put it into cloned_repo 
GET
172.23.238.154:8101/v1/workflow/returnToKafka
{
	Shows msg if successful otherwise Error msg from the ExceptionHandlerController
}

### To trigger the individual methods: 

#### to trigger the clone method 
GET
172.23.238.154:8101/v1/workflow/clone
{
	Just return the git clone returning msg.
}

#### to trigger the generate Jenkinsfile method 
GET
172.23.238.154:8101/v1/workflow/generateJenkinsfile
{
	Just return the created path of the jenkinsfile.
}

Micro Service Kafka Documentation

Publishing Data Into Kafka
{
	172.23.238.154:8101/v1/workflow/returnToKafka will send the model object to Kafka
	for trigger  jenkins services. 	
}

Consuming Data Into Kafka
{
	Not consuming from kafka as of now. but consumer methods are defined in messenger package.
}