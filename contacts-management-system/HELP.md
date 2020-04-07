# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.training.spring.event-management' is invalid and this project uses 'com.training.spring.eventmanagement' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#using-boot-devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

Usage of @Componentscan
-----------------------

If your other package hierarchies are below your main app with the @SpringBootApplication annotation, you’re covered by the implicit Component Scan.
If there are beans/components in other packages that are not sub-packages of the main package, you should manually add them as @ComponentScan

the @ComponentScan should be added in the application file in the following way..

Consider the class below:

package com.training.springboot.basics.springbootin10steps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class SpringbootIn10StepsApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
            SpringApplication.run(SpringbootIn10StepsApplication.class, args);
        for (String name: applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
}

@SpringBootApplication is defined in the SpringbootIn10StepsApplication class which is in the package com.training.springboot.basics.springbootin10steps

@SpringBootApplication defines an automatic Component Scan on the package com.training.springboot.basics.springbootin10steps.

You are fine if all your components are defined in the above package or a sub-package of it.

However, let’s say one of the components is defined in package com.training.springboot.somethingelse

In this case, you would need to add the new package into Component Scan.

You have two options:

Define @ComponentScan(“com.training.springboot”) 
This would scan the entire parent tree of com.training.springboot.
Or define two specific Component Scans by using an array. 
@ComponentScan({“com.training.springboot.basics.springbootin10steps”,”com.training.springboot.somethingelse”})
Option 1:

@ComponentScan(“com.training.springboot”)
@SpringBootApplication
public class SpringbootIn10StepsApplication {

Option 2:

@ComponentScan({"com.training.springboot.basics.springbootin10steps","com.training.springboot.somethingelse"})
@SpringBootApplication
public class SpringbootIn10StepsApplication {




----------------------

Syntax for all the CURD methods

GET
@RequestMapping("basepath")


value = "/list", 
produces = "application/json",
 method = { RequestMethod.GET }


@RequestMapping(value = "/list", produces = "application/json", method = { RequestMethod.GET })
	public List<ContactsModel> getContactsList() {
		return contactsService.getContactsList();

	}
	
	
	
	POST

value = "/list", 
produces = "application/json",
consumes="application/json",
 method = { RequestMethod.POST}


@RequestMapping(value = "/list", consumes="application/json",produces = "application/json", method = { RequestMethod.GET })
	public List<ContactsModel> getContactsList() {
		return contactsService.getContactsList();

	}
	
	
	
	--------------------------
	
	
	localhost:12345/networks/list
	
---------------------------------------------------------

@SqlResultSetMapping(name = "mapppinNativeQuery", // same as resultSetMapping
		// above in NativeQuery
		classes = {
				@ConstructorResult(targetClass = com.training.spring.contactsmanagementsystem.entities.Networks.class, columns = {
						@ColumnResult(name = "network_id", type = Integer.class),
						@ColumnResult(name = "network_name", type = String.class)
				}) })	
				
				@SqlResultSetMapping(name = "1", // same as resultSetMapping
		// above in NativeQuery
		classes = {
				@ConstructorResult(targetClass = com.training.spring.contactsmanagementsystem.entities.Networks.class, columns = {
						@ColumnResult(name = "network_id", type = Integer.class),
						@ColumnResult(name = "network_name", type = String.class)
						@ColumnResult(name = "network_id", type = Integer.class),
						@ColumnResult(name = "network_name", type = String.class)
						@ColumnResult(name = "network_id", type = Integer.class),
						@ColumnResult(name = "network_name", type = String.class)
						@ColumnResult(name = "network_id", type = Integer.class),
						@ColumnResult(name = "network_name", type = String.class)
						@ColumnResult(name = "network_id", type = Integer.class),
						@ColumnResult(name = "network_name", type = String.class)
				}) })	
	
	
	

	