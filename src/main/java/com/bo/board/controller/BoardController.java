package com.bo.board.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bo.board.model.exception.BoardException;
import com.bo.board.model.service.BoardService;
import com.bo.board.model.vo.Board;
import com.bo.board.model.vo.Image;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService bService;
	public BoardController(BoardService bService) {
		super();
		this.bService = bService;
	}

	
	@GetMapping("/list")
	public String toList(Model model) {
		ArrayList<Board> blist = bService.selectList();
		model.addAttribute("blist",blist);
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
		bService.insertBoard(b, content);
		
		
		return String.format("redirect:/board/detail/%d", b.getBoardId());
	}
	
	@GetMapping("/detail/{bid}")
	public String selectBoard(@PathVariable("bid") int bid,
			Model model) {
		Board b = bService.selectBoard(bid);
		model.addAttribute("b",b);
		return "views/detail";
	}
	
}
