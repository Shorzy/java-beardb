package mjn.beardb.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mjn.beardb.facade.Facade;
import mjn.beardb.facade.FacadeLocal;
import mjn.beardb.ejb.Bear;
import mjn.beardb.ejb.Hat;
import mjn.beardb.ejb.Holiday;
import mjn.beardb.ejb.Location;
import mjn.beardb.ejb.Vacation;
import mjn.beardb.ejb.VacationId;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	FacadeLocal facade;

    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String url = "/SearchBear.jsp";

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request,  response);
		*/
		
		
		System.out.println("**Main Servlet**");
		
		Bear b = facade.findBearByName("Björne");
		if(b==null){
			b = new Bear();
			b.setName("Björne");
			facade.createBear(b);
			
			System.out.println("**Bear created**");
		}
		
		Holiday h = facade.findHolidayByName("Easter 2017");
		if(h==null){
			h = new Holiday();
			h.setName("Easter 2017");
			h.setDuration(5);
			facade.createHoliday(h);
			
			System.out.println("**Holiday created**");
		}
		
		Location l = facade.findLocationByName("Spain");
		if(l==null){
			l = new Location();
			l.setName("Spain");
			facade.createLocation(l);
			
			System.out.println("**Location created**");
		}

		VacationId vid = new VacationId();
		vid.setBear(b);
		vid.setHoliday(h);
		vid.setLocation(l);
		
		Vacation v = facade.findVacationByVacationId(vid);
		if(v==null){
			v = new Vacation();
			v.setVacationId(vid);
			facade.createVacation(v);
			
			System.out.println("**Vacation created**");
		}
		
		//System.out.println("MainServlet doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String url = null;
		
		String operation = request.getParameter("operation");
		if(operation.equals("showbear")){
			System.out.println("MainServlet-showbear");
			String name = request.getParameter("txtName");
			Bear b = facade.findBearByName(name);
			if(b==null){
				b = facade.createBear(name);
			}
			request.setAttribute("bear", b);
			url = "/ShowBear.jsp";
		}else if(operation.equals("searchbear")){
			System.out.println("MainServlet-searchbear");
			url="/SearchBear.jsp";
		}else if(operation.equals("ajax-createHat")){
			if(facade.findBearByName(request.getParameter("bearName")) != null){
				facade.createHat(request.getParameter("hatColour"), request.getParameter("bearName"));
				response.getWriter().append("Created Hat");
			} else {
				response.getWriter().append("Invalid Bear Name");
			}
		}else{
			url="/SearchBear.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request,  response);
	}

}
