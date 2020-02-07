package com.bemore.util;

import com.bemore.domain.Department;
import com.bemore.domain.Employee;
import com.bemore.domain.Position;

/**
 * 由于部门和职位在Employee中是对象关联映射
 * 所以不能直接接受参数，需要创建Department对象和Position对象
 * @author Bmo
 * @date 2020/2/6 14:25
 */
public class IntegrateObject {
    public static void genericAssociation(Integer dept_id, Integer pos_id, Employee employee) {
        Department department = new Department();
        department.setId(dept_id);
        Position position = new Position();
        position.setId(pos_id);
        employee.setDepartment(department);
        employee.setPosition(position);
    }
}
