package com.telusko.demorests;



import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("timetable")
public class TimetableResource 
{
	
	TimetableRepository repo = new TimetableRepository();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
	 public List<Timetable> getTimetables()
	 {  
		System.out.println("getAlian called..");
		 
		 return repo.getTimetables();
	 }
	
	@GET
	@Path("timetabl/{areacode}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	 public Timetable getTimetable(@PathParam("areacode") String areacode)
	 {  
		
		 
		 return repo.getTimetable(areacode);
	 }

	@POST
	@Path("timetabl")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public Timetable creatTimetable(Timetable t1 )
	{
		System.out.println(t1);
		repo.create(t1);
		return t1;
	}
	

	@PUT
	@Path("timetabl")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public Timetable updateTimetable(Timetable t1 )
	{
		System.out.println(t1);
		if(repo.getTimetable(t1.getAreacode()).getAreacode()==null)
		{
			repo.create(t1);
		}
		else
		{
			repo.update(t1);
		}
		
		
	return t1;
	}
	
	
	@DELETE
	@Path("timetabl/{areacode}")
	 public Timetable killTimetable(@PathParam("areacode") String areacode)
	 {  
		
		 
		Timetable a = repo.getTimetable(areacode);
		
		if(a.getAreacode()!=null)
			repo.delete(areacode);
		
		return a;
	 }
}
