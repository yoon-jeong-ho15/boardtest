package com.bo.board.model.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.bo.board.model.exception.BoardException;
import com.bo.board.model.mapper.BoardMapper;
import com.bo.board.model.vo.Board;
import com.bo.board.model.vo.Image;

@Service
public class BoardService {
	private final BoardMapper mapper;
	public BoardService(BoardMapper mapper) {
		this.mapper = mapper;
	}

	public ArrayList<Board> selectList() {
		return mapper.selectList();
	}

	public void insertBoard(Board b, String content) {
		int result1 = mapper.insertBoard(b);
		int bid = b.getBoardId();
		StringBuilder newContent = new StringBuilder(content);
		if(result1 ==1) {
			Pattern pattern = Pattern.compile(
					"<img[^>]+?src=\"([^\"]+)\"[^>]*?"
					+ "alt=\"([^\"]*?)\"[^>]*>");
			Matcher matcher = pattern.matcher(content);
			
			while(matcher.find()) {
				String imgPath =matcher.group(1);
				System.out.println(imgPath);
				String imgAlt = matcher.group(2);
				System.out.println(imgAlt);
				
				newContent = processImage(imgPath, imgAlt, bid, newContent);
			}
		}else {
			throw new BoardException("failed : insert board");
		}
		b.setBoardContent(newContent.toString());
		updateBoard(b);
	}
			
			
	private StringBuilder processImage(String imgPath, String imgAlt,
			int bid, StringBuilder newContent) {
		if (imgPath.startsWith("../temp/")) {
			String fileName = imgPath.substring(imgPath.lastIndexOf("/")+1);
			String tempPath = "C:/boardTest/temp/"+fileName;
			String permanentPath = "C:/boardTest/upload/"+fileName;
			try {
				Files.move(Paths.get(tempPath), Paths.get(permanentPath));
				newContent.replace(
		                newContent.indexOf(imgPath),
		                newContent.indexOf(imgPath) + imgPath.length(),
		                "/upload/" + fileName
		            );
				
				Image img = new Image();
				img.setRenameName(fileName);
				img.setImageAlt(imgAlt);
				img.setRefBoardId(bid);
				int result2 = insertImg(img);
				if(result2 != 1) {
					throw new BoardException("failed : insert 1 image each");
				}
				return newContent;
			} catch (IOException e) {
				throw new BoardException("failed : insert all image");
			}	
		}else {
			throw new BoardException("failed : path not ../temp/");
		}
	}
			
	public Board selectBoard(int bid) {
		return mapper.selectBoard(bid);
	}

	public int insertImg(Image img) {
		return mapper.insertImg(img);
	}

	public int updateBoard(Board b) {
		return mapper.updateBoard(b);
	}
}