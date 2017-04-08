DBMS Project Proposal


* Aayushi Malik (2015003)
* Shaan Chopra (2015090)


OBJECTIVE: To design an interactive Hostel Room Allocation System for the institute.


FEATURES:
* There are 2 types of users of the system: Admin, Students. 
* There is one admin. Multiple students can register.
* At one time, only 1 user can be logged in.
* A student can apply for one hostel at a time in one of the hostels, if he/she already doesn’t have a room.
* The admin can accept or reject hostel room applications. If admin rejects an application, he/she can give a reason why the application was rejected.
* If rejected, the student can apply for a different room in the hostel and wait for the response.
* A student can cancel a hostel request application if it is yet to be responded to by the admin. Can send a request again, for the same room as well. 
* Each hostel has different rooms on different floors and different blocks (A, B, C). No 2 rooms in a hostel can have the same room number.
* There are 3 types of rooms: Single, Double sharing, Triple sharing. Each room is of exactly one type. Each type of room has a different fees.
* A room is either available(capacity of room is not full. For example, 2 spaces in a triple sharing room are occupied but one is still vacant) or unavailable. A student can file an application for a room that is available.
* Each hostel has at least 1 mess. Each room is served by a mess of that hostel. A room is served by exactly 1 mess.
        
        Student
* A student first needs to register to be part of the student database. A student can’t register twice. 
* Once registered, a student can login with his/her roll number and a password.
* A student entity includes: Roll number(student ID), name, sex, address, phone number, course, email ID.
* Once logged in, a student can:
   * Update registered information, that is, change student details and save the changes. These changes get reflected in the student database.
   * Check rooms available in a particular hostel. Can view their fees (type), description and other details individually. Can also view if any other occupants of the room.
   * Filter rooms in a hostel, by type, fees, availability, floor and block.
   * File an application for a room. If a student already has an application that is waiting for the response of the admin or already has a room allotted, he she cannot file another application.
   * Can check room status.
      * If status is approved, then can see details of own room.
      * If status is rejected, (if given any) reason why application was rejected is shown and asks student to file another application.
      * If status is pending, asks student to wait for response or cancel application.
      * If no application filed yet, asks student to file a new application.
   * Once done, a student can logout.


        Admin
* There is only one admin of the system and doesn’t need to register. Also, we cannot register a new admin. Registration is only for students.
* Admin entity contains: Admin name, Admin ID
* Once logged in, the admin can:
   * Approve or reject hostel room applications. If rejects an application, can also state a reason why application was rejected. Can leave applications in pending state as well.
   * Once an application is accepted or rejected, its status changes in the database.  
   * Admin can also check the availability of rooms in hostels, their details and names of occupants.
* Once done, the admin can logout.


        Room
* Room entity contains: Room number (room ID), floor, block, description, status (available or unavailable), hostel ID, mess ID, type. 
* The room can have 3 types: Single, double sharing, triple sharing. From each type we can estimate the fees of the room.
* A room can be part of only 1 hostel.


        Hostel
* Hostel entity contains: Hostel ID, Hostel name, gender and hostel phone number(s).
* Each hostel has multiple rooms.


        Mess
* Mess entity contains: Mess ID, Hostel ID
* Each hostel has at least 1 mess.
* A mess serves at least 1 room in the hostel.
* Each room is served by exactly 1 mess.


        Application
* Application entity contains: Application ID, Room ID, Hostel ID
* An application can approved or rejected by the admin. When filed, the application is in pending state.
* Depending on the response of the admin, the application goes through.
* A student can file only 1 application for only 1 room at a time. 


QUERIES TO IMPLEMENT:
* Add/Update a tuple in the student database.
* Add/delete an application from database. File application for a room in the hostel.
* Check availability of rooms in a hostel.
* Filter rooms in a hostel according to availability, type, fees, floor and block.
* View details of a particular room.
* Check status of hostel application.
* Approve/ Reject an application for a room and accordingly update the database.


Complex Queries:
* Find the mess that serves students living in a triple sharing/double sharing/single room in a particular hostel.
* Find the list of room pricing of the rooms applied for (application not accepted) by all female students. 
* Find the increase in number of students associated with a particular mess if all pending applications were accepted.
* Find the hostel name(s) which has more number of completely filled double sharing rooms than completely filled triple sharing rooms.
* Find the names of students served by the mess that serves maximum number of rooms.