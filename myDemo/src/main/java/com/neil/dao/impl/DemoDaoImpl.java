package com.neil.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.neil.dao.DemoDao;
import com.neil.domain.FUsers;
import com.neil.domain.Module;


@Repository(value="demoDao")
public class DemoDaoImpl  extends SqlSessionDaoSupport implements DemoDao{

	private static final String MODULE="module.";
	private static final String FUSER="f_users.";
	
	
	@Override
	public List<Module> queryModuleAll() {
		return this.getSqlSession().selectList(MODULE+"queryModuleAll");
		 
	}

	@Override
	public List<FUsers> queryFuserAll() {
		return this.getSqlSession().selectList(FUSER+"queryFuserAll");
	}
	

}
