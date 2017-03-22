package com.soapws.repository;

import com.soapws.entity.EmplProxy;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmplProxy,Long> {
}
