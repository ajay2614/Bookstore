package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.dao.LoginDao;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Books;

@Controller
public class LoginController {

	@Autowired
	LoginDao lDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws IOException, JsonParseException {

		ObjectMapper mapper = new ObjectMapper();
		String uri = "http://localhost:9090/getAllBooks";
		RestTemplate rTemplate = new RestTemplate();
		String result = rTemplate.getForObject(uri, String.class);

		List<Books> books = (List<Books>) mapper.readValue(result, new TypeReference<List<Books>>() {
		});

//		Books books = new Books();
//		books.setId(502);
//		books.setName("ds");
//		books.setAuthor("ad");
//		books.setDate("29-July-2021");
//		String jString = mapper.writeValueAsString(books);
//		URL url = new URL("http://localhost:9090/addBook");
//		HttpURLConnection con = (HttpURLConnection) url.openConnection();
//		con.setRequestMethod("POST");
//		con.setRequestProperty("Content-Type", "application/json; utf-8");
//		con.setRequestProperty("Accept", "application/json");
//		con.setDoOutput(true);
//		try (OutputStream os = con.getOutputStream()) {
//			byte[] input = jString.getBytes("utf-8");
//			os.write(input, 0, input.length);
//		}
//
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
//			StringBuilder response = new StringBuilder();
//			String responseLine = null;
//			while ((responseLine = br.readLine()) != null) {
//				response.append(responseLine.trim());
//			}
//			System.out.println(response.toString());
//		}

		ModelAndView mav = new ModelAndView();
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		if (lDao.validate(userName, password)) {
			mav.setViewName("home");
			mav.addObject("username", userName);
			mav.addObject("listbooks", books);
			return mav;
		}
		mav.setViewName("loginunsuccess");
		return mav;
	}
}
