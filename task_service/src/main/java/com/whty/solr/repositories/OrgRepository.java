package com.whty.solr.repositories;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.whty.solr.model.OrgSolr;

public interface OrgRepository extends SolrCrudRepository<OrgSolr, String> {
	  @Query("orgaid:?0 AND type:?1")
	  public OrgSolr findByOrgaidAndType(String orgaid,String type);
		
}
