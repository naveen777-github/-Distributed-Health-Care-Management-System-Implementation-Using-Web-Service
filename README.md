# Distributed-Health-Care-Management-System-Implementation-Using-WebService

## Overview


They are three separate servers, each situated in a different city, make up the distributed health care management system (DHMS):
	Montreal(MTL)
	Quebec(QUE)
	Sherbrooke(SHE)


There are two categories of agents for this system:

	Admin
	Patient 

We need to ensure that these agents are using Webservices to communicate with the other servers using SOAP.


Functions exclusive to admin:

	addAppointment(): By using this function admin can add an appointment to the server. The admin cannot add an appointment for the same appointment type if one already exists.

	removeAppointment(): This allows the administrator to remove a booked appointment. No deletion has been made if there is no appointment. In the unlikely event that a patient has made an appointment and it is confirmed, cancel the appointment and make the patient's next available appointment.

	listAppointmentAvailability(): It returns the available spaces for appointment to the patient.


### Functions exclusive to Patient:

book appointment(): The function schedules the patient's appointment and modifies the available capacity in that appointment.


getAppointmentSchedule(): By using this function we able to get appointments from all the cities, Montreal, Quebec and Sherbrooke, should be displayed.


cancelAppointment():To locate the appointment ID and delete the appointment, it searches the hash map.

swapAppointment(): To swap the patient ID from one appointment ID to another appointment ID.


A unique adminID and patientID, respectively, are used to identify administrators and patients.

Both admin and client maintain log records stored in a file.

Admin able to perform patient operations but patient not able to perform admin operations.

There are three types of appointments dental, surgeon, and physician.

The appointment ID is a combination of four characters and six integers.

For example: ”MTLA120324” represents Montreal(MTL),Afternoon(A)
,120324(day/month/year).


## Implementation

	In this project, I created the main server file and publish the endpoint using the Endpoint class.

	In publish method I pass the url on port 8081which I want to host my three services.

	I removed the CORBA implementation and replaced the code with @web service, and @SoapBinding annotations in services,@webmethod in the interface.

	In the client, used URL, and QName objects to call the web services.

	This project includes the usage of concurrent hash maps where the content from the client will be arranged like key and value.

	Also, includes ArrayList where the patientID will be stored.

	 After implementing servers to access the methods in servers I built an interface where all the functions are arranged.

	By using the functions in the interface can call them in the client.

	The admin and patient fetch the information from the user and the process will be done by the respective server according to input.

	Here the admin can perform both patient and admin operations while the patient can only perform the patient operations.

	The three servers were communicating with the SOAP.

	At the end of every execution, the result will be returned in the form of logs to a text file named adminfile.txt, patientfile.txt, and server.txt.

	The most important part of this project implementation is establishing SOAP Binding. Because without using this we can’t implement the communication between servers.

	The hardest part of the implementation for me in this project is the swap appointment. Because to fetch the appointment from another server we have to establish intercommunication between them which it requires UDP/IP sockets.

## Class Diagram

![image](https://github.com/naveen777-github/-Distributed-Health-Care-Management-System-Implementation-Using-Web-Service/assets/85072641/23a76737-0c84-43b7-8c5e-1656606c0a64)

![image](https://github.com/naveen777-github/-Distributed-Health-Care-Management-System-Implementation-Using-Web-Service/assets/85072641/337ae482-0475-44e3-b5c6-65c6bd5abb88)

## Data Structures

Outer Hash Map: This is the primary data structure, implemented using a concurrent hash map. It associates appointment types (strings) with appointment IDs and details. The appointment type serves as the key, and the value associated with each type is another concurrent hash map.

Inner Hash Map: The value associated with each appointment type in the outer concurrent hash map is itself a concurrent hash map. This inner concurrent hash map contains appointment IDs as keys and appointment details as values.


Appointment Details: For each appointment ID in the inner concurrent hash map, the associated details include:

•	Patient ID List: This is an array list containing the IDs of patients scheduled for the appointment. It is a list of strings.

•	Capacity: This is an integer representing the maximum number of patients that can be scheduled for an appointment.

![image](https://github.com/naveen777-github/-Distributed-Health-Care-Management-System-Implementation-Using-Web-Service/assets/85072641/0dac795d-ca55-4d34-8a91-8a2abda58a6f)

![image](https://github.com/naveen777-github/-Distributed-Health-Care-Management-System-Implementation-Using-Web-Service/assets/85072641/69cbccfd-57c8-4c03-af57-cb96a674ba86)

### Working of Data structure:

	You can access the inner concurrent hash map by first looking up the appointment type in the outer concurrent hash map.

	Once you have the inner concurrent hash map for a particular appointment type, you can access specific appointment details by looking up the appointment ID within that inner concurrent hash map.

	With the appointment ID, you can retrieve both the patient ID list and the capacity for that appointment.

## Test Cases

### 1)Admin
   #### Do's:
        Admin able to perform both   patient and admin operations
        Admin can add an appointment
        Admin can remove an appointment
        Admin can list appointment's availability
        Admin can fetch appointment availabilities from other cities as well
  #### Don't's:
        Admin is unable to add an appointment for the same appointment type if one already exists
        Admin is unable to perform deletion if there is no appointment
        Admin was unable to book an appointment on the same day
        Admin was unable to book an appointment if it reached the capacity of the appointment type
        Admin was unable to book an appointment if the patient ID already exists
        Admin was unable to cancel the appointment if there was no appointment ID and patient ID
### 2)Patient
     #### Do's:    
        Patients can book an appointment  
        Patients can get an appointment schedule
        Patients can cancel an appointment
        Patients can swap an appointment
     #### Don't's:	
        Patients were unable to book an appointment on the same day
        Patients were unable to book an appointment if it reached the capacity of the appointment type
	Patients were unable to book an appointment if the patient ID already exists
        Patients were unable to book an appointment if the patient ID, Appointment Type, or Appointment ID was Null	
        Patients were unable to cancel the appointment if there was no appointment ID and patient ID
        Patients can’t do every operation like admin.
        Patients can swap an appointment
	Do not swap if you cannot insert the patient into a new appointment.
        Do not swap if you cannot cancel an old appointment.		
        Do not swap if there is no availability to book.		
        Do not swap if the patient has booked an old appointment.













