package com.mendonca.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mendonca.model.Music;
import com.mendonca.service.MidiaService;

@RestController
@RequestMapping("files")
public class MusicControler {

	@Autowired
	private MidiaService midiaService;
	
	
	@PostMapping("/upload")
	public void loadFileIntoDataBase(@RequestParam("file") MultipartFile multipartFile  ) throws IOException {	
	 System.out.println(multipartFile);
	 midiaService.saveMusic(multipartFile);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Resource> getMusic(@PathVariable(required = true) String id){
	  Optional<Music> musicOptional =   	midiaService.getOneMusic(Integer.parseInt(id));
		
		if(musicOptional.isPresent()) {
			Music music = musicOptional.get();
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(music.getMusicType()))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= "+music.getMusicName())
					.body(new ByteArrayResource(music.getMusicData()));
			
			
		}
	  
		
		return null;
	}
	
	
	
	
}
