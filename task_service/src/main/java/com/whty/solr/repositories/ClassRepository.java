package com.whty.solr.repositories;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.whty.solr.model.ClassSolr;

public interface ClassRepository extends SolrCrudRepository<ClassSolr, String> {
	  @Query("classid:?0")
	  public ClassSolr findByClassid(String classid);
		
}
