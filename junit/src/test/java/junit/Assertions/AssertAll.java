package junit.Assertions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class AssertAll {
	@Test
	void test1() {
		Student student1 = new Student(1,"Krishna",(byte)18);
		Student student2 = new Student(1,"Ram",(byte)18);
		
		//----------- assertAll(String heading, Executables) 		
		assertAll("Object Test",() -> assertEquals("Krishna", student1.name),
				()->assertEquals(18, student1.age),
				()->assertEquals(1, student1.id)
				);
		
		assertAll("Student",() -> assertEquals("Ram", student2.name),
				()->assertEquals(18, student2.age),
				()->assertEquals(2, student2.id)
				);
	}
	
	@Test
	void test2(){
		//------------assertAll(Collection<Executables?)
		List executables=new ArrayList();
		Executable a = ()->assertEquals(true, 2%2==0);
		Executable b = ()->assertEquals(true, 3%2==1);
		executables.add(a);
		executables.add(b);
		
		assertAll(executables);

	}
	
	@Test
	void test3(){
		//------------assertAll(Collection<Executables?)
		List executables=new ArrayList();
		Executable a = ()->assertEquals(true, 2%2==0);
		Executable b = ()->assertEquals(true, 3%2==0);
		executables.add(a);
		executables.add(b);
		
		assertAll("My Heading", executables.stream());

	}
}


class Student{
	String name;
	byte age;
	int id;
	
	Student(int id,String name,byte age){
		this.id= id;
		this.name = name;
		this.age =age;
	}
	
}
