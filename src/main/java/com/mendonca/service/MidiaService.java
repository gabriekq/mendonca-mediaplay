package com.mendonca.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.mendonca.model.Music;

public interface MidiaService {

	public void saveMusic(MultipartFile multipartFile) throws IOException;
	
	public Optional<Music> getOneMusic(int id);
	
	
	
}
