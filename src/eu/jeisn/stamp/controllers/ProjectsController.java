package eu.jeisn.stamp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eu.jeisn.stamp.dao.ParticipationDAO;
import eu.jeisn.stamp.dao.ProjectDAO;
import eu.jeisn.stamp.dao.TaskDAO;
import eu.jeisn.stamp.dao.UserDAO;
import eu.jeisn.stamp.json.projectpost.ProjectPost;
import eu.jeisn.stamp.json.projectpost.TaskPost;
import eu.jeisn.stamp.json.projectpost.UserPost;
import eu.jeisn.stamp.json.projects.ProjectView;
import eu.jeisn.stamp.models.Participation;
import eu.jeisn.stamp.models.ParticipationId;
import eu.jeisn.stamp.models.Project;
import eu.jeisn.stamp.models.Task;
import eu.jeisn.stamp.models.User;

@Path("/Projects")
public class ProjectsController {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProjects() {
		List<ProjectView> projects = new ArrayList<>();  
		new ProjectDAO().getStream()
			.forEach(x -> projects.add(new ProjectView(x)));;
		return Response.status(200).entity(projects).build();
	}
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON) 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postProject(ProjectPost data) {
		Project project = new Project(data.name, data.toDate, data.fromDate);
		project = new ProjectDAO().create(project);
		System.out.println(data.users);
		if(data.users != null && data.users.size() > 0) {
			for(UserPost usr : data.users) {
				User u = new UserDAO().read(usr.userName);
				ParticipationId id = new ParticipationId(project.getId(), u.getUserName());
				new ParticipationDAO().create(new Participation(id, u, project));
			}
		} else {
			return Response.status(400).build();
		}
		
		if(data.tasks != null && data.tasks.size() > 0) {
			for(TaskPost tsk : data.tasks) {
				User u = new UserDAO().read(tsk.userName);
				new TaskDAO().create(new Task(tsk.fromDate, tsk.toDate, u, project));
			}
		} else {
			return Response.status(400).build();
		}
		
		List<ProjectView> projects = new ArrayList<>();
		new ProjectDAO().getStream()
			.forEach(x -> projects.add(new ProjectView(x)));
		
		return Response.status(200).entity(projects).build();
	}
}
