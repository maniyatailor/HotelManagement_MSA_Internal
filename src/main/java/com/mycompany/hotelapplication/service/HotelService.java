package com.mycompany.hotelapplication.service;
import entity.HotelRoom;
import entity.Hotelmaster;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Collection;

@Path("/hotel")
public class HotelService {
    
    @PersistenceContext(unitName="mypu")
    EntityManager em;
    
    @GET
    @Path("searchhotel")
    @RolesAllowed("OWNER")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Collection<HotelRoom> getHotels(@QueryParam("city")String city,@QueryParam("roomType")String roomType)
    {
        String jpql="SELECT h\n" +
"FROM HotelRoom h\n" +
"WHERE h.hotelid.city = :city\n" +
"AND h.roomtypeid.rtname = :rtname";  
        return em.createQuery(jpql,HotelRoom.class).setParameter("city",city).setParameter("rtname", roomType).getResultList();   
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok("Hello, world!").build();
    }

}
