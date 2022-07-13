package com.mendonca.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mendonca.model.OwnerMusic;

@Repository
public interface  OwnerMusicRepository  extends  JpaRepository<OwnerMusic,String>  {

	@Query("select o  from OwnerMusic o left join fetch o.musics where o.ownerLogin = ?1   ")
	 Optional<OwnerMusic> findAllMusicsByLogin( String userName   );
	
	
}
