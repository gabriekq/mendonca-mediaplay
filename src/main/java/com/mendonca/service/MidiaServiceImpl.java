package com.mendonca.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mendonca.model.Music;
import com.mendonca.repository.MidiaRepository;

@Service
public class MidiaServiceImpl implements MidiaService {

	@Autowired
	private MidiaRepository midiaRepository;
	
	public void saveMusic(MultipartFile multipartFile) throws IOException {
		
		Music music = new Music();
		music.setMusicName(multipartFile.getOriginalFilename());
		music.setMusicType( multipartFile.getContentType());
		music.setMusicData(multipartFile.getBytes());
		midiaRepository.save(music);
	}
	
	public Optional<Music> getOneMusic(int id){
	 return midiaRepository.findById(id);
	}
	
}
