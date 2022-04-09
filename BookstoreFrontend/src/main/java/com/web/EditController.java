package com.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Authors;
import com.model.Books;

@Controller
public class EditController {

	@RequestMapping(value = "/editbook", method = RequestMethod.POST)
	public ModelAndView postBook(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonParseException {

		int id = Integer.parseInt(req.getParameter("bookid"));
		String title = req.getParameter("bookname");
		Integer a = Integer.parseInt(req.getParameter("authors"));
		String date = req.getParameter("bookdate");

		ObjectMapper mapper = new ObjectMapper();
		String uri = "http://localhost:9090/getAuthor/" + a;
		RestTemplate rTemplate = new RestTemplate();
		String result = rTemplate.getForObject(uri, String.class);

		Authors author = mapper.readValue(result, Authors.class);
		Books books = new Books();
		books.setId(id);
		books.setName(title);
		books.setAuthor(author);
		books.setDate(date);
		String jString = mapper.writeValueAsString(books);
		URL url = new URL("http://localhost:9090/updateBook");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("PUT");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
		}
		String uri2 = "http://localhost:9090/getAllBooks";
		RestTemplate rTemplate2 = new RestTemplate();
		String result2 = rTemplate2.getForObject(uri2, String.class);

		List<Books> books2 = (List<Books>) mapper.readValue(result2, new TypeReference<List<Books>>() {
		});
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("listbooks", books2);
		return mav;
	}
}
