package com.cos.insta.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.insta.model.Follow;

public interface FollowRepository extends JpaRepository<Follow, Integer>{
	
	//unFollow
	@Transactional
	int deleteByFromUserIdAndToUserId(int fromUserId, int toUserId);
	
	//follow 유무
	
	int countByFromUserIdAndToUserId(int fromUserId, int toUserId);
}
