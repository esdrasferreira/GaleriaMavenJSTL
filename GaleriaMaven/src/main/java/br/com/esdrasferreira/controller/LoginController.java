package br.com.esdrasferreira.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.model.dao.UsuarioDao;
import br.com.esdrasferreira.model.entity.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet({ "/LoginController", "/login-controller" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession(true);

		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String parametro = request.getParameter("parametro");

		

		if (parametro.equals("login")) {

			

				

				try {
					Usuario user = new Usuario();
					UsuarioDao dao = new UsuarioDao();

					user = dao.login(usuario, senha);
					
					
					

					sessao.setAttribute("usuario", user.getUsuario());
					sessao.setAttribute("idUsuario", user.getId());

					request.getRequestDispatcher("/produto-controller").forward(request, response);
					

				} catch (Exception e) {

					e.printStackTrace();

				}

			

			

			

		} else if (parametro.equals("logout")) {

			sessao.setAttribute("id", null);

			response.sendRedirect("index.html");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
