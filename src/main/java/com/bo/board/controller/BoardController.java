package com.bo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bo.board.model.service.BoardService;
import com.bo.board.model.vo.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService bService;
	
	public BoardController(BoardService bService) {
		super();
		this.bService = bService;
	}

	
	@GetMapping("/list")
	public String toList() {
		return "views/list";
	}
	
	@GetMapping("/write")
	public String toWrite() {
		return "views/write";
	}
	
	@PostMapping("/insert")
	public String insertBoard(@ModelAttribute Board b,
			@RequestParam("editor") String content,
			Model model) {
		
		model.addAttribute(b);
		model.addAttribute(content);
		
		return "/views/detail";
	}
}
