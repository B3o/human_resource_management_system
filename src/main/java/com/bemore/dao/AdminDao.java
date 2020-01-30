package com.bemore.dao;

import com.bemore.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Bmo
 * @date 2020/1/28 22:30
 */
@Repository
public interface AdminDao {
    /** 登录
     *
     * @param admin
     * @return
     */
    Admin login(Admin admin);

    /** 根据条件查询管理员
     *
     * @param map
     * @return
     */
    List<Admin> findAdmins(Map<String, Object> map);

    /** 根据条件查询管理员人数
     *
     * @param map
     * @return
     */
    Integer getCount(Map<String, Object> map);

    /** 添加管理员
     *
     * @param admin
     * @return
     */
    Integer addAdmin(Admin admin);

    /** 修改管理员
     *
     * @param admin
     * @return
     */
    Integer updateAdmin(Admin admin);

    /** 删除管理员
     *
     * @param id
     * @return
     */
    Integer deleteAdmin(Integer id);
}
