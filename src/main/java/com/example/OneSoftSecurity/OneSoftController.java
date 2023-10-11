package com.example.OneSoftSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneSoftController {
	@GetMapping("/student")
	public String getName() {
		return "this is Mani";
	}
	@GetMapping("/trainer")
	public String getTrainer() {
		return "This is Trainer : Aravind";
	}
	@GetMapping("/manager")
	public String getManager() {
		return "This is Manager : Sekar/Ajay";
	}


}
