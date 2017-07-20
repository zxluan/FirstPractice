package com.cm.practice.servlet2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetChargeRecordServlet
 */
@WebServlet("/GetChargeRecordServlet")
public class GetChargeRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetChargeRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String phone = request.getParameter("userPhone");
		String password = request.getParameter("userPass");
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray();
		JSONObject one = new JSONObject();
		
		if(phone.equals(password)){
			for(int i=1;i<5;i++){
				one.put("chargeTime","2017-03-0"+i);
				one.put("chargeValue", i+"00");
				arr.add(one);
			}
			json.put("msg", true);
			json.put("chargeInfo", arr);
		}else{
			json.put("msg",false);
			json.put("chargeInfo", arr);
		}
		
		response.getWriter().write(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
