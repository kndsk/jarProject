package com.whty.solr.repositories;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.whty.solr.model.UserSolr;

public interface UserRepository extends SolrCrudRepository<UserSolr, String> {
	
	  @Query("personid:?0 AND usertype:?1")
	  public UserSolr findByPersonidAndUsertype(String personid,String usertype);
	  
	  @Query("personid:?0")
	  public UserSolr findByPersonid(String personid);
		
}
