package com.bo.board.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.bo.board.model.mapper.BoardMapper;
import com.bo.board.model.vo.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardMapper mapper;

	public ArrayList<Board> selectList() {
		return mapper.selectList();
	}

	public int insertBoard(Board b) {
		return mapper.insertBoard(b);
	}
}
