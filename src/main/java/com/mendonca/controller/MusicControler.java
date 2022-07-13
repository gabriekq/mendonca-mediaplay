package com.mendonca.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
@RequestMapping("media")
public class MusicControler {

	@Autowired
	private MidiaService midiaService;
	
	@PostMapping("/upload")
	public void loadFileIntoDataBase(@RequestParam("file") MultipartFile multipartFile  ) throws IOException {	
	 System.out.println(multipartFile);
	 String owner = getCurrentUserName( ).toString().split(",")[1];
	 
	 midiaService.saveMusic(multipartFile, owner);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Resource> getMusic(@PathVariable(required = true) String id){
	  
		String musicId = id.replaceAll("_", " ");
		
		Optional<Music> musicOptional = midiaService.getOneMusic(musicId);
		
		if(musicOptional.isPresent()) {
			Music music = musicOptional.get();
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(music.getMusicType()))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= "+music.getMusicName())
					.body(new ByteArrayResource(music.getMusicData()));	
		}
		return null;
	}
	
	@GetMapping("/musicInfo")
	public ResponseEntity<List> fetchMusics(){
		
		String owner = getCurrentUserName( ).toString().split(",")[1];
		
		ArrayList<Music> musics = new ArrayList<Music>(midiaService.getAllMusicsByOwner(owner));
			
		musics.parallelStream().forEach( value -> value.setOwners(null));
		System.out.println(musics.size());
		
		if(!musics.isEmpty()) {
			return ResponseEntity.ok(musics);
		}else {
		   return ResponseEntity.noContent().build();
		}

	}
	
	@GetMapping("/userName")
	public ResponseEntity<?> getCurrentUserName( ){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
		
        if(username == null) {
        	return ResponseEntity.notFound().build();
        }else {
        	return ResponseEntity.ok(username);	
        }  
	}
	
	
	
	
	
}
