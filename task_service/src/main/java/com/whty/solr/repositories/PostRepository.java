package com.whty.solr.repositories;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.whty.solr.model.PostSolr;

public interface PostRepository extends SolrCrudRepository<PostSolr, String> {
}
