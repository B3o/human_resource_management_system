package com.bemore.service.impl;

import com.bemore.dao.EmployeeDao;
import com.bemore.domain.Employee;
import com.bemore.domain.Post;
import com.bemore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Bmo
 * @date 2020/2/5 16:39
 */

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findEmployees(Map<String, Object> map) {
        return employeeDao.findEmployees(map);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return employeeDao.getCount(map);
    }

    @Override
    public Integer addEmployee(Employee employee) {
        Integer flag = null;
        try {
            //如果插入主键重复，抛出异常
            flag =  employeeDao.addEmployee(employee);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return flag;
    }

    @Override
    public Integer updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public Integer deleteEmployee(String id) {
        return employeeDao.deleteEmployee(id);
    }
}
