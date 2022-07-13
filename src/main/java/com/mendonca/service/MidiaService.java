package com.mendonca.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.mendonca.model.Music;

public interface MidiaService {

	public void saveMusic(MultipartFile multipartFile,String ownerId) throws IOException;
	
	public Optional<Music> getOneMusic(String id);
	
	public List<Music> getAllMusicsByOwner(String ownerId);
	
	
}
