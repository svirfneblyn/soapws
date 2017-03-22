package com.soapws.repositoryservice;

import com.soapws.entity.EmplProxy;
import com.soapws.entity.Employee;
import com.soapws.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeService {
/*Service*/
    private   EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        System.out.println(employeeRepository.toString());
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeById(Long id) {
        EmplProxy emplProxy = employeeRepository.findOne(id);
        Employee empl = buildEmploye(emplProxy);
        return empl;
    }

    public List<Employee> getAllEmployees() {
        Iterator<EmplProxy> allemplIterator = employeeRepository.findAll().iterator();
        List<Employee> emplList = new ArrayList<>();
        allemplIterator.forEachRemaining(eProxy->emplList.add(buildEmploye(eProxy)));
        return emplList;
    }
    private Employee buildEmploye(EmplProxy emplProxy) {
        Employee empl = new Employee();
        empl.setDepartment(emplProxy.getDepartment());
        empl.setFirstName(emplProxy.getDepartment());
        empl.setLastName(emplProxy.getLastName());
        empl.setManager(emplProxy.getManager());
        empl.setId(Integer.parseInt(String.valueOf(emplProxy.getId())));
        return empl;
    }
}
