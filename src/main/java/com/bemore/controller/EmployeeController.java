package com.bemore.controller;

import com.bemore.domain.Employee;
import com.bemore.service.EmployeeService;
import com.bemore.util.IntegrateObject;
import com.bemore.util.JsonDateValueProcessor;
import com.bemore.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 该类下所有响应方法都被映射到/empl路径下
 * @author Bmo
 * @date 2020/2/7 15:04
 */
@Controller
@RequestMapping("/empl")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 处理查询员工请求
     * @param employee
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public String list(Employee employee, HttpServletRequest request,
                       HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<>();
        if (employee.getId() != null && !"".equals(employee.getId().trim())) {
            map.put("id", "%" + employee.getId() + "%");
        }
        if (employee.getName() != null && !"".equals(employee.getName().trim())) {
            map.put("name", "%" + employee.getName() + "%");
        }
        if (employee.getSex() != null && !"".equals(employee.getSex().trim())) {
            map.put("sex", "%" + employee.getSex() + "%");
        }
        if (employee.getDepartment() != null) {
            if (employee.getDepartment().getName() != null
                    && !"".equals(employee.getDepartment().getName().trim())) {
                map.put("department_name", "%"
                        + employee.getDepartment().getName() + "%");
            }
        }
        if (employee.getPosition() != null) {
            if (employee.getPosition().getName() != null
                    && !"".equals(employee.getPosition().getName().trim())) {
                map.put("position_name", "%" + employee.getPosition().getName()
                        + "%");
            }
        }
        List<Employee> employeeList = employeeService.findEmployees(map);
        Integer total = employeeService.getCount(map);
        // 处理日期使之能在easyUI的datagrid中正常显示
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(employeeList, jsonConfig);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 处理保存员工请求
     * @param dept_id
     * @param pos_id
     * @param updateFlag
     * @param employee
     * @param request
     * @param response
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(@RequestParam(value = "dept_id") Integer dept_id,
                       @RequestParam(value = "pos_id") Integer pos_id, @RequestParam("updateFlag") String updateFlag,
                       Employee employee, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        int resultTotal = 0;
        //完成Department 和 Position 在 Employee中的关联映射
        IntegrateObject.genericAssociation(dept_id, pos_id, employee);
        JSONObject result = new JSONObject();
        //根据updateFlag的值，判断保存的方式，如果值为no 则添加员工，如果值为yes 则修改员工
        if ("no".equals(updateFlag)) {
            try {
                resultTotal = employeeService.addEmployee(employee);
                if (resultTotal > 0) {
                    result.put("success", true);
                } else {
                    result.put("success", false);
                }
            }catch (Exception e) {
                result.put("success", false);
            }
        }else if ("yes".equals(updateFlag)){
            resultTotal = employeeService.updateEmployee(employee);
            if (resultTotal > 0) {
                result.put("success", true);
            } else {
                result.put("success", false);
            }
        }
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 处理员工删除请求
     * @param ids
     * @param response
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids") String ids,
                         HttpServletResponse response, HttpSession session) throws Exception {
        JSONObject result = new JSONObject();
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; ++i) {
            employeeService.deleteEmployee(idsStr[i]);
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * spring mvc 日期绑定
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(sdf, true);
        binder.registerCustomEditor(Date.class, editor);
    }
}
