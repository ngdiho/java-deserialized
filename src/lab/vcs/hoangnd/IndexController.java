package lab.vcs.hoangnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexController() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String action = request.getParameter("action");
		
		if(action.equals("serialized")) {
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setEmail(request.getParameter("email"));
			user.setBirth(Integer.parseInt(request.getParameter("birth")));
			user.setPhone(request.getParameter("phone"));

			final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			final ObjectOutputStream objectOutputStream;
			try {
				objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
				objectOutputStream.writeObject(user);
				objectOutputStream.close();
				String serialiedObj = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
				
				request.setAttribute("serializedObj", serialiedObj);
				
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
			} catch (IOException e) {
				throw new Error(e);
			}
		}
		else if(action.equals("deserialized")) {
			byte[] decodeBase64 = Base64.getDecoder().decode(request.getParameter("strBase64"));
			
			 ByteArrayInputStream in = new ByteArrayInputStream(decodeBase64);
			 ObjectInputStream is = new ObjectInputStream(in);
			try {
				User user = (User)is.readObject();
				request.setAttribute("deserializedObj", user);
				
//				User user = new User();
//				FileInputStream file = new FileInputStream("E:\\ViettelCyberSecurity\\challenge11\\test.ser");
//	            ObjectInputStream in = new ObjectInputStream(file);
//
//	            // Deserialization of the object to file
//
//	            // System.out.println("Deserializing from " + filename);
//	            user = (User)in.readObject();
//
//	            in.close();
//	            file.close();
				
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				throw new Error(e);
			}
			
		}
	}
}
