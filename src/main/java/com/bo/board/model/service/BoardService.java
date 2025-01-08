package com.bo.board.model.service;

import org.springframework.stereotype.Service;

import com.bo.board.model.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardMapper mapper;
}
