package com.bemore.service.impl;

import com.bemore.dao.PostDao;
import com.bemore.domain.Post;
import com.bemore.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Bmo
 * @date 2020/2/5 16:27
 */

@Service("postService")
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> findPosts(Map<String, Object> map) {
        return postDao.findPosts(map);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return postDao.getCount(map);
    }

    @Override
    public Integer addPost(Post post) {
        return postDao.addPost(post);
    }

    @Override
    public Integer updatePost(Post post) {
        return postDao.updatePost(post);
    }

    @Override
    public Integer deletePost(Integer id) {
        return postDao.deletePost(id);
    }

    @Override
    public Post getPostById(Integer id) {
        return postDao.getPostById(id);
    }
}
