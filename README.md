
This project has been done to test some Spring and Pivotal Cloudfoundry features


# Springboot overview 

[Quick Start](http://projects.spring.io/spring-boot/) [Documentation](http://docs.spring.io/spring-boot/docs/2.0.0.BUILD-SNAPSHOT/reference/htmlsingle/)


##### Spring data jpa 


1.  JPA based on `hibernate` implementation

     @Entity
     public class User {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long userId;
	  @Column(nullable = false, length = 20)
	  private String name;
	  @Column(nullable = false, length = 20)
	  private String firstName;
	  ...	 
2. provides a simple way to request database without code 


  * the `JpaRepository` interface provides all the commons methods to request a database
	
      List<T> findAll();
      List<T> findAll(Iterable<ID> ids);
      <S extends T> List < S > save(Iterable < S > entities);
      T getOne(ID id);
      ..		

  * developers can create custom queries based on naming [conventions](http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation) or on `JPQL` 
  
      public List<User> findByNameContainingIgnoreCase(final String name);
      public List<User> findAllByOrderByName();
      @Query("select u from User u where u.name not like %?1%")
      public List<User> findByNameContainingNot(final String name);

[Quick Start](http://projects.spring.io/spring-data-jpa/) [Documentation](http://docs.spring.io/spring-data/jpa/docs/1.11.0.M1/reference/html/)


##### Spring REST




# CloudFoundry integration using STS


##### Import project to STS


##### CloudFoundry settings


##### Deploy application


##### Continuous integration using Concourse.ci


##### Test application


