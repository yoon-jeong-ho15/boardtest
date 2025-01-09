package com.bo.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api")
public class UploadController {
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(
			@RequestParam("file") MultipartFile file){
		
		return null;
	}
}
