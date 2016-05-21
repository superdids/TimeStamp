package eu.jeisn.stamp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eu.jeisn.stamp.dao.ProjectDAO;
import eu.jeisn.stamp.dao.UserDAO;
import eu.jeisn.stamp.json.ProjectView;
import eu.jeisn.stamp.json.ProjectsView;
import eu.jeisn.stamp.json.UserLoginView;
import eu.jeisn.stamp.json.UserView;
import eu.jeisn.stamp.models.Project;
import eu.jeisn.stamp.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="/Login")
@Path("/Login")
public class LoginController {

	@ApiOperation(
			value = "Post user information to log in",
			response = ProjectsView.class)
	@ApiResponses(value= {
			@ApiResponse(code=404, message="Username does not exist"),
			@ApiResponse(code=400, message="Invalid password"),
			@ApiResponse(code=200, message="Success")
	})
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(@ApiParam(
			value="User credentials",
			required=true) UserLoginView user) {
		UserDAO userDAO = new UserDAO();
		User dbUser = userDAO.read(user.userName);
		if(dbUser == null) {
			return Response.status(404).build();
		} else if(dbUser.getPassword() == null || !dbUser.getPassword().equals(user.password)) {
			return Response.status(400).build();
		}
		
		List<Project> dbProjects = new ProjectDAO().readAllByUser(dbUser.getName());
	
		List<ProjectView> projects = new ArrayList<>();
		if(dbProjects != null && dbProjects.size() > 0) {
			for(Project project : dbProjects) {
				projects.add(new ProjectView(project));
			}
		}
		
		List<UserView> users = new ArrayList<>(); 
		new UserDAO().getStream()
				.forEach(x -> users.add(new UserView(x)));

				
		ProjectsView projectsView = new ProjectsView();
		projectsView.projects = projects;
		projectsView.user = new UserView(dbUser);
		projectsView.users = users;
		
		return Response.status(200).entity(projectsView).build();
	}
}
