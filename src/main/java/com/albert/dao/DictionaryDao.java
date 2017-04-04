package com.albert.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.albert.domain.table.Dictionary;

public interface DictionaryDao extends CrudRepository<Dictionary, Long>{
	 @Query("from Dictionary u where u.name=:name")
	 Dictionary findByName(@Param("name") String name);

}
