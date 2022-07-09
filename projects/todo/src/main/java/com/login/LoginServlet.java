package com.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.loggeduser.User;
import com.todo.ServicesImpl;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            System.out.println(payLoad);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();
            Object picture = payLoad.get("picture");
            String hash = payLoad.getSubject();
            System.out.println(picture);
            System.out.println("User name: " + name);
            System.out.println("User email: " + email);

            HttpSession session = req.getSession(true);
            session.setAttribute("userName", name);
            session.setAttribute("userEmail",email);
            session.setAttribute("pic", picture);
            session.setAttribute("hash", hash);
            
            System.out.println(hash);
            User u = new User();
            u.setId(hash);
            u.setUemail(email);
            u.setUname(name);
            u.setImg(picture.toString());
            String res = new ServicesImpl().getuser(u);
            if(res.equals(u.getId())) {
		            	resp.sendRedirect("welcome-page.jsp");
		    }
            else{
            boolean result = new ServicesImpl().saveuser(u);
                if(result == true) {
                	System.out.println("saving....");
                	resp.sendRedirect("welcome-page.jsp");
            }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}
