package com.bemore.dao;

import com.bemore.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Bmo
 * @date 2020/1/30 13:29
 */
@Repository
public interface PostDao {

    /** 根据条件查询公告
     *
     * @return
     */
    public List<Post> findPosts(Map<String, Object> map);

    /** 根据条件查询公告数量
     *
     * @param map
     * @return
     */
    public Integer getCount(Map<String, Object> map);

    /** 添加公告
     *
     * @param post
     * @return
     */
    public Integer addPost(Post post);

    /** 修改公告
     *
     * @param post
     * @return
     */
    public Integer updatePost(Post post);

    /** 删除公告
     *
     * @param id
     * @return
     */
    public Integer deletePost(Integer id);

    /** 根据 ID 查询公告信息
     *
     * @param id
     * @return
     */
    public Post getPostById(Integer id);
}