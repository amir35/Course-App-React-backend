package com.amir35.profileImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, String>{
	
	//public Course findById(int id);
	
	

}
