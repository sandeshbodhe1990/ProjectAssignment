Can run application using docker compose up
API uses API Key Authentication.
Key: X-API-KEY, value: abcde12345

PostMan Collection is attached

The Application has 4 apis
1) createNewCustomer
Create a new customer with basic contact info (name,Mobile number, email)
2) updateCustomerInfo
Updates customer info provided in body with the id as path variable
3) addOrders
Added Orders to Customer
4) getCustomerDetails
Gets customer contact info and order details

Note: 
1)Vaidations are not include din code
2) if the user is not present in DB while updating or adding order then will get UserNot Exception and Error message as API output.

