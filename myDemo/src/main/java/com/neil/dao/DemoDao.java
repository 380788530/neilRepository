package com.neil.dao;

import java.util.List;

import com.neil.domain.FUsers;
import com.neil.domain.Module;

public interface DemoDao {

	public List<Module> queryModuleAll();

	public List<FUsers> queryFuserAll();

}
