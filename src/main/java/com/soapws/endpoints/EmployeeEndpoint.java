package com.soapws.endpoints;

import com.soapws.entity.GetAllEmployeeRequest;
import com.soapws.entity.GetAllEmployeeResponse;
import com.soapws.entity.GetEmployeeByIdRequest;
import com.soapws.entity.GetEmployeeByIdResponse;
import com.soapws.repositoryservice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndpoint {
 /*EndPoint*/
    private static final String NAMESPACE_URI = "http://soapws.com/entity";
    @Autowired
    private EmployeeService employeeService;
    public EmployeeEndpoint() {
    }

   @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
    @ResponsePayload
    public GetEmployeeByIdResponse getEmployeeByIdResponse(@RequestPayload GetEmployeeByIdRequest request) {
        GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
        response.setEmployee(employeeService.getEmployeById(Long.parseLong(request.getId())));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmployeeRequest")
    @ResponsePayload
    public GetAllEmployeeResponse getAllEmployeeResponse(@RequestPayload GetAllEmployeeRequest request) {
        GetAllEmployeeResponse response = new GetAllEmployeeResponse();
        response.getEmployee().addAll(employeeService.getAllEmployees());
        return response;
    }
}
