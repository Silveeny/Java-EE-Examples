Lab 5 JSF
=========

* Requirements can be found here: https://profs.info.uaic.ro/~acf/tj//labs/lab_05.html
* I attempted to do all the steps required in the lab.
* I re-wrote the persistance layer to be JB complaint - look into `dao.impl.jpa`
* I re-wrote the `persistance.xml` so that it uses the datasource configured in the previous laboratory (connection pool in payara5) 
* I used JPQL `JAPExamDAO.java`, for example to retrieve all the elements from the table
* I wrote the unit tests `src/test/java/dao/impl/jpa/JPAExamDAOTest.java`
* I added `@MappedSuperclass` annotation to the Exam class so it can be used in inheritance mapping for the classes `WrittenTest` and `ProjectPresentation` 
* Finally created an exam-search-page (check `SearchBin` class) that uses the JPA Criteria API