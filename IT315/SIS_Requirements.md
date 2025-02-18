<header>

<!--
  <<< Author notes: Course header >>>
 
-->

# IT 315 Student Information System Requirements Definitions

## Nonfunctional Requirements:
-	The student information system (SIS) should be accessible as both a website and a mobile app.
-	The SIS users are students and enrollment staff.
-	The SIS should enforce appropriate security privileges to its uses.

## Functional Requirements:

### Maintain Student Records:
The SIS should maintain records of basic information about students such as:
- First name
-	Middle initials
-	Last name
-	Date of birth
-	Student ID
-	Department (e.g., psychology)
-	Cumulative GPA (on a scale of 1.0 to 4.0)
-	These records are updated by the enrollment staff who has the permissions to add, modify, and/or delete any student record.
•	Maintain Course Records
o	The SIS should maintain records of all the courses offered by the college.
o	The system should maintain the following fields for each course:
a)	Course ID
b)	Course name
c)	Credit hours
d)	Description
e)	Prerequisite course
o	These records are updated by the enrollment staff who has the permissions to add, modify, and/or delete any course record.
•	Maintain Class Records
o	Classes are offered each semester of the above courses.
o	There are two kinds of classes: Online classes offered over the internet are accessible via a web browser and face-to-face classes are offered on campus at the college.
o	A class cannot exist without an associated course in the system.
o	The basic information to maintain for all kinds of classes include the following:
a)	Course ID
b)	Class begin date
c)	Class end date
o	In addition, online classes also maintain the following information:
a)	Class URL
b)	Class browser
o	Similarly, face-to-face classes should maintain this additional information about them:
a)	Class building
b)	Class room
o	These records are updated by the enrollment staff who has the permissions to add, modify, and/or delete any class record (either online or face-to-face).

•	Register a Student for Classes
o	Both students and enrollment staff should be able to register a student (either online or face-to-face) for a class offering for a course. The registration process should proceed as follows:
a)	The student information is entered to identify the registering student.
b)	The course information for which to register is entered to identify the course.
c)	All future classes with start dates after the current date for this course are displayed.
d)	The enrollment staff enter future classes for only one semester out.
e)	A selection of one class for which to register is then made.
f)	The selected class registration is then validated against the following registration rules:
i.	There is no duplicate registration for the same class in one semester.
ii.	Online class registration requires students to acknowledge that they have the required hardware and software to access online classes.
iii.	No more than three class registrations are allowed for one student in one semester unless the student’s GPA is greater than 3.5. (In this case, there is no limit on number of class registrations.)
o	When the class registration is validated against the above rules, a confirmation is then displayed to confirm registration. Otherwise, a message explaining the violation of the associated rule is displayed.
o	The process continues, starting from item b), until the user ends the session.


...

</header>

<!--
  <<< Author notes: Finish >>>
  Review what we learned, ask for feedback, provide next steps.
-->



...


<footer>

<!--
  <<< Author notes: Footer >>>
  Add a link to get support, GitHub status page, code of conduct, license link.
-->

---

