package com.bo.board.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bo.board.model.vo.Image;

@Mapper
public interface BoardMapper {

	int insertImg(Image img);

}
