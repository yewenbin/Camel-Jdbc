package com.nirakar.jdbc.camel;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RowProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        Map<String, Object> row = exchange.getIn().getBody(Map.class);
        System.out.println("Processing " + row);
        Employee employee = new Employee();
        BigDecimal empId=(BigDecimal)row.get("EMPID");
        employee.setEmpId(Integer.valueOf(empId.intValue()));
        employee.setEmpName((String) row.get("EMPNAME"));
        
        
        exchange.getOut().setBody(employee);
    }

}
