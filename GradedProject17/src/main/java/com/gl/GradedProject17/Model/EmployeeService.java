package com.gl.GradedProject17.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;




@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo repo;
	
	public void addUpdate(Employee employee) {
		repo.save(employee);
	}
	public void delete(Employee employee) {
		repo.delete(employee);
	}
	public List<Employee> getall(){
		return repo.findAll();
	}
	public Employee FindById(int id) {
		if(repo.findById(id).isEmpty()) {
			return null;
		}else {
			return repo.findById(id).get();
		}
	}
	public List<Employee> getBySortOnly(String Columns, Direction direction ){
		return repo.findAll(Sort.by(direction, Columns));
	}
	//filter
		public List<Employee> filter (String searchKey){
			//1.create a dummy object based on the searchkey
			Employee dummy = new Employee();
				dummy.setFirstName(searchKey);
			//2.create Example JPA-where
			ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("firstName",ExampleMatcher.GenericPropertyMatchers.contains()).withIgnorePaths("id","lastName","email");
			
			//3.Combining Dummy  with where
			Example<Employee> example =Example.of(dummy,exampleMatcher);
			return repo.findAll(example);
		}
	
}
