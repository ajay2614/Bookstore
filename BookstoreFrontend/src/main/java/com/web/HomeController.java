package com.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Authors;
import com.model.Books;

@Controller
public class HomeController {

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addBook(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonParseException {

		ObjectMapper mapper = new ObjectMapper();
		String uri = "http://localhost:9090/getAllAuthors";
		RestTemplate rTemplate = new RestTemplate();
		String result = rTemplate.getForObject(uri, String.class);

		System.out.println(result);
		List<Authors> authors = (List<Authors>) mapper.readValue(result, new TypeReference<List<Authors>>() {
		});

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
		String date = sdf.format(new Date());

		for (Authors a : authors) {
			System.out.println(a.getName());
		}
		ModelAndView mav = new ModelAndView();

		mav.setViewName("addbook");
		mav.addObject("listauthors", authors);
		mav.addObject("date", date);
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editBook(HttpServletRequest req, HttpServletResponse res)
			throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String uri = "http://localhost:9090/getAllAuthors";
		RestTemplate rTemplate = new RestTemplate();
		String result = rTemplate.getForObject(uri, String.class);

		System.out.println(result);
		List<Authors> authors = (List<Authors>) mapper.readValue(result, new TypeReference<List<Authors>>() {
		});

//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
//		String date = sdf.format(new Date());

		int bid = Integer.parseInt(req.getParameter("hid"));
		String date = req.getParameter("hdate");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("editbook");
		mav.addObject("listauthors", authors);
		mav.addObject("date", date);
		mav.addObject("bookid", bid);
		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deleteBook(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int bid = Integer.parseInt(req.getParameter("hid"));
		System.out.println(bid);
		ObjectMapper mapper = new ObjectMapper();
		String uri = "http://localhost:9090/getBook/" + bid;
		RestTemplate rTemplate = new RestTemplate();
		String result = rTemplate.getForObject(uri, String.class);

		Books book = mapper.readValue(result, Books.class);
		Authors author = book.getAuthor();
		URL url = new URL("http://localhost:9090/deleteBook/" + bid);
		System.out.println(url);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("DELETE");
		int rc = con.getResponseCode();
		System.out.println(rc);

		String jString = mapper.writeValueAsString(author);
		URL url2 = new URL("http://localhost:9090/addAuthor");
		HttpURLConnection connection = (HttpURLConnection) url2.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json; utf-8");
		connection.setRequestProperty("Accept", "application/json");
		connection.setDoOutput(true);
		try (OutputStream os = connection.getOutputStream()) {
			byte[] input = jString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
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

		List<Books> books = (List<Books>) mapper.readValue(result2, new TypeReference<List<Books>>() {
		});
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("listbooks", books);
		return mav;
	}
}
