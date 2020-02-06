package com.bemore.service.impl;

import com.bemore.dao.DepartmentDao;
import com.bemore.domain.Department;
import com.bemore.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Bmo
 * @date 2020/2/5 16:30
 */

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> findDepartments(Map<String, Object> map) {
        return departmentDao.findDepartments(map);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return departmentDao.getCount(map);
    }

    @Override
    public Integer addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    @Override
    public Integer updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }

    @Override
    public Integer deleteDepartment(Integer id) {
        Integer flag = null;
        try {
            flag = departmentDao.deleteDepartment(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return flag;
    }
}
