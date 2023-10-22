/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Calendar;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ICT_Common
 */
@Path("service")
public class RestService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestService
     */
    public RestService() {
    }

    /**
     * Retrieves representation of an instance of service.RestService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "<html><body>Hellow! Now server time is: "+Calendar.getInstance().getTime()+"</body></html>";
    }

    /**
     * PUT method for updating or creating an instance of RestService
     * @param name
     * @param content representation for the resource
     * @return 
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
        
    }
    @GET
    @Path("time")
    @Produces(MediaType.TEXT_HTML)
    public String getTime(@QueryParam("name")String name){
       return "<html><body>Hellow!"+name+"! Now server time is: "+Calendar.getInstance().getTime()+"</body></html>";
    }
}
