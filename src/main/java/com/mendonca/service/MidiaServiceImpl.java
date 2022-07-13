package com.mendonca.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mendonca.model.Music;
import com.mendonca.model.OwnerMusic;
import com.mendonca.repository.MidiaRepository;
import com.mendonca.repository.OwnerMusicRepository;

@Service
public class MidiaServiceImpl implements MidiaService {

	@Autowired
	private MidiaRepository midiaRepository;

	@Autowired
	private OwnerMusicRepository ownerMusicRepository;

	public void saveMusic(MultipartFile multipartFile, String ownerId) throws IOException {

		Optional<OwnerMusic> ownerOptional = ownerMusicRepository.findById(ownerId);
		String musicId = multipartFile.getOriginalFilename().split("([.])+")[0];
		Optional<Music> musicOptional = midiaRepository.findById(musicId);

		if (ownerOptional.isPresent()) {

			if (musicOptional.isPresent()) {

				Music music = musicOptional.get();
				OwnerMusic ownerMusic = ownerOptional.get();

				ownerMusic.addMusic(music);
				music.addOwner(ownerMusic);

				ownerMusicRepository.save(ownerMusic);
				midiaRepository.save(music);

			} else {

				OwnerMusic owner = ownerOptional.get();

				Music music = new Music();
				music.setMusicName(multipartFile.getOriginalFilename());
				music.setMusicType(multipartFile.getContentType());
				music.setMusicData(multipartFile.getBytes());
				music.setIdMusicName(musicId);

				midiaRepository.save(music);

				// relations
				owner.addMusic(music);
				music.addOwner(owner);
				midiaRepository.save(music);
				ownerMusicRepository.save(owner);

			}

		} else {

			if (musicOptional.isPresent()) {

				Music music = musicOptional.get();
				OwnerMusic owner = new OwnerMusic();
				owner.setOwnerLogin(ownerId);
				owner.addMusic(music);
				music.addOwner(owner);

				ownerMusicRepository.save(owner);
				midiaRepository.save(music);

			} else {

				OwnerMusic owner = new OwnerMusic();
				owner.setOwnerLogin(ownerId);

				Music music = new Music();
				music.setMusicName(multipartFile.getOriginalFilename());
				music.setMusicType(multipartFile.getContentType());
				music.setMusicData(multipartFile.getBytes());

				music.setIdMusicName(musicId);
				// relations

				midiaRepository.save(music);
				ownerMusicRepository.save(owner);

				owner.addMusic(music);
				music.addOwner(owner);

				midiaRepository.save(music);
				ownerMusicRepository.save(owner);

			}

		}

	}

	public Optional<Music> getOneMusic(String id) {
		return midiaRepository.findById(id);
	}

	@Override
	public List<Music> getAllMusicsByOwner(String ownerId) {

		Optional<OwnerMusic> ownerOptional = ownerMusicRepository.findById(ownerId);

		if (ownerOptional.isPresent()) {
			OwnerMusic owner = ownerOptional.get();
			return owner.getMusics();

		}

		return new ArrayList<Music>();
	}

}
