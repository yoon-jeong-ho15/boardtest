package com.bo.board.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {
	private int boardId;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
}
