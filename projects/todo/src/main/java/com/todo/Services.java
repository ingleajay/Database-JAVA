package com.todo;


import java.util.List;

import com.loggeduser.User;

interface Services {

	public boolean savetask(Todo t);
	public boolean deletetask(int id);
	public boolean updatetask(int id,Todo t);
	public boolean saveuser(User u);
	public String getuser(User u);
}
