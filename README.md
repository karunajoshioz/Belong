# Belong Coding Challenge

Application will  save phone number for a given customer

Technologies Used:

Spring Boot, JPA, Restful Webservices, Jackson Data format CSV, H2 IN-Memory Database .

Api Specifications:

1. Customer records will be saved to database when user hit URL localhost:8080/api/v1/customer/activate
Request Payload
{
	"customerId": "2",
	"customerName": "Samuel Gayed",
	"phoneDtls": [{
			"phoneNo": "0478944834"
		},
		{
			"phoneNo": "0403924549"
		}
	]
}


2. Customer records will be fetched from  database when user hit URL localhost:8080/api/v1/customer/2


Steps to run the code:

Maven  clean and build. 
The jar file will be available in the target file.
Copy jar and using cmd  type "java -jar CustomerAPI-0.0.1-SNAPSHOT.jar"

