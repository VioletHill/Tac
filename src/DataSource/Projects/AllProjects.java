package DataSource.Projects;

import java.util.Vector;

public class AllProjects 
{
	private Vector< Projects > projects=null;
	static private AllProjects instacne;
	
	static synchronized public AllProjects sharedAllProjects()
	{
		if (instacne==null)
		{
			instacne=new AllProjects();
			instacne.initProject();
		}
		return instacne;
	}
	
	public AllProjects() 
	{
		projects=new Vector<Projects>();
	}

	//初始化imageName 展示图片
	private void initProject()
	{
		projects.add(new Projects());
		projects.get(0).title="Project0";
		projects.get(0).description="第一个作品";
		projects.get(0).image.add("Projects/Project0/Project0_0.png");
		projects.get(0).image.add("Projects/Project0/Project0_1.png");
		projects.get(0).image.add("Projects/Project1/Project1_0.png");
		projects.get(0).image.add("Projects/Project1/Project1_1.png");
		projects.get(0).image.add("Projects/Project0/Project0_0.png");
		projects.get(0).image.add("Projects/Project0/Project0_1.png");
		projects.get(0).image.add("Projects/Project1/Project1_0.png");
		projects.get(0).image.add("Projects/Project1/Project1_1.png");
		projects.add(new Projects());
		projects.get(1).title="Project1";
		projects.get(1).description="第二个作品";
		projects.get(1).image.add("Projects/Project1/Project1_0.png");
		projects.get(1).image.add("Projects/Project1/Project1_1.png");
		
		projects.add(new Projects());
		projects.get(2).title="Project1";
		projects.get(2).description="第二个作品";
		projects.get(2).image.add("Projects/Project1/Project1_0.png");
		projects.get(2).image.add("Projects/Project1/Project1_1.png");
		
		projects.add(new Projects());
		projects.get(3).title="Project0";
		projects.get(3).description="第一个作品";
		projects.get(3).image.add("Projects/Project0/Project0_0.png");
		projects.get(3).image.add("Projects/Project0/Project0_1.png");
		projects.get(3).image.add("Projects/Project1/Project1_0.png");
		projects.get(3).image.add("Projects/Project1/Project1_1.png");
		
		projects.add(new Projects());
		projects.get(4).title="Project1";
		projects.get(4).description="第二个作品";
		projects.get(4).image.add("Projects/Project1/Project1_0.png");
		projects.get(4).image.add("Projects/Project1/Project1_1.png");
	}

	public Vector< Projects > getProject() 
	{
		return projects;
	}	
}
