package br.com.esdrasferreira.model.dao;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import br.com.esdrasferreira.model.entity.Produto;

@WebServlet({ "/Nomes", "/nomes-imagens" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 5, // 5mb
		maxFileSize = 1024 * 1024 * 20, // 20mb
		maxRequestSize = 1024 * 1024 * 40 // 40mb

)

public class Nomes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession(true);
		RequestDispatcher requestDispatcher = null;
		String caminhoDoUsuario = System.getProperty("user.home");
		List<Produto> produtos2 = new ArrayList<Produto>();
		List<Produto> produtos = (List<Produto>) request.getAttribute("produtoList");
		
		for (Iterator<Produto> list = produtos.iterator(); list.hasNext();) {

			Produto prod = (Produto) list.next();
			String nomeProduto = prod.getImagem();
			String caminhoDaImagem = "imagens" + File.separator + nomeProduto;
			prod.setImagem(caminhoDaImagem);
			System.out.println(caminhoDaImagem);
			produtos2.add(prod);

		}

//				caminhoDaImagem = caminhoDoUsuario + File.separator +
//				 "appservers" + File.separator
//				 + "arquivos" + File.separator + "imagens"+File.separator + nomeProduto;

		request.setAttribute("produtos2", produtos2);

		requestDispatcher = request.getRequestDispatcher("galeria.jsp");

		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
