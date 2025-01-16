package com.bo.board.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Image {
	private int imageId;
	private String originalName;
	private String renameName;
	private int refBoardId;
	private int thumbnail;
}
