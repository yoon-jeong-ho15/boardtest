package com.bo.board.model.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.bo.board.model.vo.Board;
import com.bo.board.model.vo.Image;

@Mapper
public interface BoardMapper {

	int insertImg(Image img);

	ArrayList<Board> selectList();

	int insertBoard(Board b);

}
