package com.example.peliculas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestApplicationController {
	
	//Declaramos la api-key del servicio TMDB 
	private String api_keyTMDB = "2834fa987cc8f747814f76c216fc9d36";
	
	@GetMapping("/peliculas")
	public String getPeliculasByTitle(@RequestParam(required = true) String title) {

		RestTemplate restTemplate = new RestTemplate();
		String URL = "https://api.themoviedb.org/3/search/movie?api_key="+api_keyTMDB+"&query="+title;
		
		ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
		return response.getBody();
	}
	
	
}


