package ceb.ebs.electricitybillingsystem.controller;

import ceb.ebs.electricitybillingsystem.model.PaymentMethod;
import ceb.ebs.electricitybillingsystem.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
@Path("/payment-method")
public class PaymentMethodController {

    @Autowired
    PaymentMethodService paymentMethodService;

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addPaymentMethod(@Valid PaymentMethod paymentMethod, @Context UriInfo uriInfo) {
        try {
            return Response.status(HttpStatus.OK.value()).entity(paymentMethodService.addPaymentMethod(paymentMethod)).build();
        } catch (SQLIntegrityConstraintViolationException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity("No user found with id: " + paymentMethod.getUser().getId()).build();
        }
    }

    @POST
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response editPaymentMethod(@PathParam("id") Long id, @Valid PaymentMethod paymentMethod, @Context UriInfo uriInfo) {
        try {
            return Response.status(HttpStatus.OK.value()).entity(paymentMethodService.editPaymentMethod(id, paymentMethod)).build();
        } catch (EntityNotFoundException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity("No user found with id: " + paymentMethod.getUser().getId()).build();
        } catch (EmptyResultDataAccessException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity("No payment method found with id: " + id).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findPaymentMethod(@PathParam("id") Long id) {
        try {
            return Response.status(HttpStatus.OK.value()).entity(paymentMethodService.findPaymentMethod(id)).build();
        } catch (EmptyResultDataAccessException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity("No payment method found with id: " + id).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response listPaymentMethods() {
        return Response.status(HttpStatus.OK.value()).entity(paymentMethodService.listPaymentMethods()).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deletePaymentMethod(@PathParam("id") Long id) {
        try {
            return Response.status(HttpStatus.OK.value()).entity(paymentMethodService.deletePaymentMethod(id)).build();
        } catch (EmptyResultDataAccessException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity("No payment method found with id: " + id).build();
        }
    }

}
