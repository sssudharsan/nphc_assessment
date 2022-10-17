package com.nphc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nphc.model.Employee;
import com.nphc.repository.EmployeeRepository;
import com.nphc.service.CSVService;

@ExtendWith(MockitoExtension.class)
public class ApplicationTests {

	@InjectMocks
	CSVService service;
	
	@Mock
	EmployeeRepository dao;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllEmployeesTest()
	{
		List<Employee> list = new ArrayList<Employee>();
		Employee empOne = new Employee();
		empOne.setId("emp001");
		empOne.setLogin("你好");
		empOne.setName("employee 1");
		empOne.setSalary(new BigDecimal(100));
		empOne.setStartDate(new Date());

		list.add(empOne);
		
		service.save(empOne);

		when(dao.findAll()).thenReturn(list);

		//test
		List<Employee> empList = service.getAllEmployees();

		assertEquals(1, empList.size());
		verify(dao, times(1)).findAll();
	}
	
}
