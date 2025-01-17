package com.bo.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bo.board.model.service.UploadService;

@Controller
@RequestMapping("/api")
public class UploadController {
	private final UploadService uService;
	public UploadController(UploadService uService) {
		this.uService= uService;
	}
		
	@PostMapping("/upload")
	@ResponseBody
	public ResponseEntity<String> saveTemp(
			@RequestParam("image") MultipartFile file,
			@RequestParam(value="thumbnail", defaultValue="0") int thum
			) {
		String filename = uService.saveTemp(file, thum);
		
		return ResponseEntity.ok("/temp/"+filename);
	}
}
