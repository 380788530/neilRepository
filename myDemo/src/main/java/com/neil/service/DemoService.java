package com.neil.service;

import java.util.List;

import com.neil.domain.FUsers;
import com.neil.domain.Module;

public interface DemoService {

	public List<Module> queryModuleAll();

	public List<FUsers> queryFuserAll();

	
}
