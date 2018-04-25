package com.whty.mongodb.dao.impl;

import org.springframework.stereotype.Repository;

import com.whty.mongodb.dao.PostDao;
import com.whty.mongodb.model.Post;

@Repository("postDao")
public class PostDaoImpl extends BaseMongoDaoImpl<Post> implements PostDao {

 
}
