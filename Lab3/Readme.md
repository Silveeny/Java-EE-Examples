Lab 3 JSF
=========

* Lab used primefaces 11
* Covered all the bullets in the assignment - https://profs.info.uaic.ro/~acf/tj/labs/lab_03.html
* This was done using an AWS RDS database (MariaDB) for persistence layer (MariaDB is the only option eligible for free tier)
* Followed the recommended guidelines and wrote unit tests for some parts of the code (The Data layer of the exams functionality)
* Used a custom converter in order to process the choices of the student when checked the exams in `selectManyCheckbox`
* The scheduling algorithm first sorts the list of available exams by starting date asc, then sorts the same list of exams by starting date
to end date (we used lambdas from course / java 8 here) then places each exam in a bucket (a session is formed of 7 buckets of 3 exams capacity each) - 7 days / 3 exams per day max (`DefaultExamScheduler.java` + `Bucket.java`)
* Used a datatable for displaying the results of the timetable
* `ExamSessionInputGenerator.java` - random generator of an exam list
* Lecture notes can be found here: https://profs.info.uaic.ro/~acf/tj/slides/jsf_slide_en.pdf