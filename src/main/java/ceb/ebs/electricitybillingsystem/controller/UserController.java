package ceb.ebs.electricitybillingsystem.controller;

import ceb.ebs.electricitybillingsystem.model.User;
import ceb.ebs.electricitybillingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Service
@Path("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User addUser(@Valid User user, @Context UriInfo uriInfo) {
        return userService.createUser(user);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User editUser(@Valid User user, @Context UriInfo uriInfo) {
        return userService.updateUser(user);
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User findUser(@PathParam("id") Long id) {
        return userService.findUser(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Iterable<User> listUsers() {
        return userService.listUsers();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteUser(@PathParam("id") Long id) {
        try {
            userService.deleteUser(id);
            return Response.status(HttpStatus.OK.value()).entity("User deleted successfully").build();
        } catch (EmptyResultDataAccessException e) {
            return Response.status(HttpStatus.NOT_FOUND.value()).entity("No user found with id: " + id).build();
        }
    }

}
