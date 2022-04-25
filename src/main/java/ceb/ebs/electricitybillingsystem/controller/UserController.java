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
    public Response addUser(@Valid User user, @Context UriInfo uriInfo) {
        return Response.status(HttpStatus.OK.value()).entity(userService.createUser(user)).build();
    }

    @POST
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response editUser(@PathParam("id") Long id, @Valid User user, @Context UriInfo uriInfo) {
        try {
            return Response.status(HttpStatus.OK.value()).entity(userService.updateUser(id, user)).build();
        } catch (EmptyResultDataAccessException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity("No user found with id:" + id).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findUser(@PathParam("id") Long id) {
        try {
            return Response.status(HttpStatus.OK.value()).entity(userService.findUser(id)).build();
        } catch (EmptyResultDataAccessException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity("No user found with id: " + id).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response listUsers() {
        return Response.status(HttpStatus.OK.value()).entity(userService.listUsers()).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteUser(@PathParam("id") Long id) {
        try {
            return Response.status(HttpStatus.OK.value()).entity(userService.deleteUser(id)).build();
        } catch (EmptyResultDataAccessException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity("No user found with id: " + id).build();
        }
    }

}
