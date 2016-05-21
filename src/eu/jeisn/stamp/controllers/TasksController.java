package eu.jeisn.stamp.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eu.jeisn.stamp.dao.UserDAO;
import eu.jeisn.stamp.models.User;
import io.swagger.annotations.Api;

@Api(value="/Tasks")
@Path("/Tasks")
public class TasksController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> msg() {

		UserDAO dao = new UserDAO();
		List<User> projects = dao.readAll();
		if(projects != null && projects.size() > 0) {
			for(User project : projects) {
				System.out.println(project.getName());
			}
			System.out.println("found somehting!");
		} else {
			System.out.println("nothing");
			System.out.println(projects);
		}

		return projects;
	}

	@GET
	@Path("/Us")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> asd() {
		UserDAO dao = new UserDAO();
		List<User> users = dao.getStream()
				.where(x -> x.getName().toLowerCase().contains("ro"))
				.toList();

		return users;
	}
}
