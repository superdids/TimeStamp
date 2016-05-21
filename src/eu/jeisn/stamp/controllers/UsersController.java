package eu.jeisn.stamp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eu.jeisn.stamp.dao.UserDAO;
import eu.jeisn.stamp.json.UserView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="/Users")
@Path("/Users")
public class UsersController {

	@ApiOperation(
			value="Get all users, passwords are omitted",
			response = UserView.class)
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success")
	})
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		List<UserView> users = new ArrayList<>();
		new UserDAO().getStream()
			.forEach(x -> users.add(new UserView(x)));
		return Response.status(200).entity(users).build();
	}
}
