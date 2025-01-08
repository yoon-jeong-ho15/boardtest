package com.bo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bo.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private final BoardService service;
	
	@GetMapping("/list")
	public String toList() {
		return "views/list";
	}
	
	@GetMapping("/write")
	public String toWrite() {
		return "views/write";
	}
}
