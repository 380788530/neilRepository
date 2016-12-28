package com.neil.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.dao.DemoDao;
import com.neil.domain.FUsers;
import com.neil.domain.Module;
import com.neil.service.DemoService;

@Service(value = "demoService")
public class DemoServiceImpl implements DemoService{

	@Autowired
	private DemoDao demoDao;
	
	@Override
	public List<Module> queryModuleAll() {
		return  demoDao.queryModuleAll();
		
	}

	@Override
	public List<FUsers> queryFuserAll() {
		return demoDao.queryFuserAll();
	}

}
