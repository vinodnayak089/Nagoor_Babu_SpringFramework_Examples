package com.gtmarttiles.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;
import com.gtmarttiles.factory.TilesServiceFactory;
import com.gtmarttiles.service.TilesService;

@WebServlet("*.do")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			TilesService tilesService= TilesServiceFactory.getTilesService();
			String req_path = request.getRequestURI();
			String button_Label = request.getParameter("button");
			String status = "";
			if (req_path.endsWith("add.do")) {
				Tiles tiles = new Tiles();
				Quantity quantity = new Quantity();
				RequestDispatcher rd = null;
				tiles.setBoxSize(request.getParameter("boxSize"));
				tiles.setDesignNo(request.getParameter("designNo"));
				quantity.setL(Integer.parseInt(request.getParameter("l")));
				quantity.setHl(Integer.parseInt(request.getParameter("hl")));
				quantity.setD(Integer.parseInt(request.getParameter("d")));
				quantity.setF(Integer.parseInt(request.getParameter("f")));
				tiles.setPrize(Integer.parseInt(request.getParameter("prize")));
				tiles.setQuantity(quantity);
				status = tilesService.add(tiles);
				if (status.equals("success")) {
					rd = request.getRequestDispatcher("./success.html");
					rd.forward(request, response);
				} else if (status.equals("failure")) {
					rd = request.getRequestDispatcher("./failure.html");
					rd.forward(request, response);
				} else if (status.equals("existed")) {
					rd = request.getRequestDispatcher("./existed.html");
					rd.forward(request, response);
				}
			}
			if(req_path.endsWith("search.do")) {
                 String designNo=request.getParameter("designNo");
                 Tiles tiles=new Tiles();
                 tiles=tilesService.searchtiles(designNo);
     			RequestDispatcher rd = null;
     			if(tiles==null)
     			{
     				rd=request.getRequestDispatcher("./notexisted.html");
					rd.forward(request, response);
     			}
     			else {
     				request.setAttribute("tiles", tiles);
     				rd=request.getRequestDispatcher("./dispaly.jsp");
					rd.forward(request, response);
     			}
			}
			if(req_path.endsWith("checkToUpdate.do")) {
                String designNo=request.getParameter("designNo");
                Tiles tiles=new Tiles();
                tiles=tilesService.searchtiles(designNo);
    			RequestDispatcher rd = null;
    			if(tiles==null)
    			{
    				rd=request.getRequestDispatcher("./notexisted.html");
					rd.forward(request, response);
    			}
    			else {
    				request.setAttribute("tiles", tiles);
    				rd=request.getRequestDispatcher("./dispalyUpdate.jsp");
					rd.forward(request, response);
    			}
			}
			if(req_path.endsWith("update.do")) {
                Tiles tiles = new Tiles();
				Quantity quantity = new Quantity();
				RequestDispatcher rd = null;
				tiles.setBoxSize(request.getParameter("boxSize"));
				tiles.setDesignNo(request.getParameter("designNo"));
				quantity.setL(Integer.parseInt(request.getParameter("l")));
				quantity.setHl(Integer.parseInt(request.getParameter("hl")));
				quantity.setD(Integer.parseInt(request.getParameter("d")));
				quantity.setF(Integer.parseInt(request.getParameter("f")));
				tiles.setPrize(Integer.parseInt(request.getParameter("prize")));
				tiles.setQuantity(quantity);
				status = tilesService.update(tiles);
				if (status.equals("success")) {
					rd = request.getRequestDispatcher("./success.html");
					rd.forward(request, response);
				} else if (status.equals("failure")) {
					rd = request.getRequestDispatcher("./failure.html");
					rd.forward(request, response);
				} else if (status.equals("existed")) {
					rd = request.getRequestDispatcher("./existed.html");
					rd.forward(request, response);
				}
			}
			if(req_path.endsWith("delete.do")) {
                String designNo=request.getParameter("designNo");
                status=tilesService.delete(designNo);
    			RequestDispatcher rd = null;
    			if (status.equals("success")) {
    				System.out.println("success page in delete");
					rd = request.getRequestDispatcher("./success.html");
					rd.forward(request, response);
				} else if (status.equals("failure")) {
					rd = request.getRequestDispatcher("./failure.html");
					rd.forward(request, response);
				} else if (status.equals("notexisted")) {
					rd = request.getRequestDispatcher("./notexisted.html");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
