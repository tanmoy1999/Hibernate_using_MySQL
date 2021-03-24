package com.hibernate.sample;

import java.util.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class App {
	
	public static void create(Session session) {
//		System.out.println("Creating Employee records...");
//		Employee emp1 = new Employee();
//		emp1.setName("Tanny");
//		emp1.setPosition("Manager");
//		emp1.setSalary("1000000");
//		emp1.setDept("Operations");
//		
//		Employee emp2 = new Employee();
//		emp2.setName("Sammy");
//		emp2.setPosition("Analyst");
//		emp2.setSalary("800000");
//		emp2.setDept("Development");
//		
//		Employee emp3 = new Employee();
//		emp3.setName("Spidey");
//		emp3.setPosition("Analyst");
//		emp3.setSalary("850000");
//		emp3.setDept("Maintenance");
//
//		session.beginTransaction();
//		session.save(emp3);
//		session.save(emp2);
//		session.save(emp1);
//		session.getTransaction().commit();
		
		
		System.out.println("Hibernate using MySQL database.");
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Number of data you want to insert");
		int n = input.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Name: ");
			String name = input.next();
			System.out.println("Position: ");
			String position = input.next();
			System.out.println("Salary: ");
			String salary = input.next();
			System.out.println("Department: ");
			String dept = input.next();
			
			Employee emp = new Employee(name,dept,salary,position);
			empList.add(emp);
			
			session.beginTransaction();
			session.save(emp);
		}
		session.getTransaction().commit();
		
	}
	
	public static void read(Session session) {
		Query q = session.createQuery("select _employee from Employee _employee");
		List<Employee> emp = q.list();
		
		System.out.println("Reading employee records....");
		System.out.printf("%-30.30s  %-30.30s  %-30.30s  %-30.30s%n", "Name", "Position", "Salary", "Dept.");
		for (Employee e : emp) {
			System.out.printf("%-30.30s  %-30.30s  %-30.30s  %-30.30s%n", e.getName(), e.getPosition(), e.getSalary(), e.getDept());
			
		}
	}

	public static void main(String[] args) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
         
        create(session);
        read(session);
         
       
        session.close();
	}

}
