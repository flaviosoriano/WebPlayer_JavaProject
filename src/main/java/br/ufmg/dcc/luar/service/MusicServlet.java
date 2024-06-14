package br.ufmg.dcc.luar.service;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufmg.dcc.luar.model.Track;

/**
 * Servlet implementation class MusicServlet
 */
@WebServlet("/MusicServlet")
public class MusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EntityManagerFactory factory;
	Track playedTrack;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String trackId = request.getParameter("trackId");
		int id = Integer.valueOf(trackId);
		factory = Persistence.createEntityManagerFactory("WebPlayer_JavaProject");
		EntityManager manager = factory.createEntityManager();
		playedTrack = manager.find(Track.class, id);
		manager.close();
		
		System.out.println("funcionou");
		
		response.setContentType("audio/mpeg");
		response.getOutputStream().write(playedTrack.getAudioFile());
		response.getOutputStream().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
