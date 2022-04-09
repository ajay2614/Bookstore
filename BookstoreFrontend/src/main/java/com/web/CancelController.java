package com.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Books;

@Controller
public class CancelController {

	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public ModelAndView cancel(HttpServletRequest req, HttpServletResponse res)
			throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		String uri = "http://localhost:9090/getAllBooks";
		RestTemplate rTemplate = new RestTemplate();
		String result = rTemplate.getForObject(uri, String.class);

		List<Books> books = (List<Books>) mapper.readValue(result, new TypeReference<List<Books>>() {
		});
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("listbooks", books);
		return mav;
	}
}
