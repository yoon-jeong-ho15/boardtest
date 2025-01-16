package com.bo.board.model.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bo.board.model.exception.BoardException;
import com.bo.board.model.mapper.BoardMapper;
import com.bo.board.model.vo.Image;
@Service
public class UploadService {
	private final BoardMapper mapper;
	public UploadService(BoardMapper mapper) {
		this.mapper = mapper;
	}

	
	public String saveTemp(MultipartFile file, int thum){
		try {
			String tempPath ="C:/boardTest/temp/";
			File dir = new File(tempPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			String og = file.getOriginalFilename();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmSSS_");
			int ranNum = (int)(Math.random()*100000);
			String suffix = og.substring(og.lastIndexOf("."));
			String re = sdf.format(new Date())+ranNum+suffix;
			
			File destfile = new File(tempPath, re);
			file.transferTo(destfile);
			
			return re;
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException("failed : img transfer to server",e);
		}
	}
	
	
}
