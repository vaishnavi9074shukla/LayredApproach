package com.vaishnavi.databases;

import java.util.HashSet;
import java.util.Set;

import com.vaishnavi.bean.Project;

public class ProjectDataSource {
		public static Set<Project> projectList = new HashSet<Project>();
		static {
			projectList.add(new Project(101, "biba"));
			projectList.add(new Project(102, "ATM"));
			projectList.add(new Project(103, ".net"));
			projectList.add(new Project(104, "banking"));
			projectList.add(new Project(105, "finance"));
			projectList.add(new Project(106, "Java"));
		}
		
		public static  Set<Project> getProjectList() {
			return projectList;
		}
		public static void setProjectList(Set<Project> projectList) {
			ProjectDataSource.projectList = projectList;
		}
}
