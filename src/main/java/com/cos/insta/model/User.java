package com.cos.insta.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity//jpa->orm
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;//시퀀스
	private String username;//사용자 아이디
	@JsonIgnore
	private String password; //암호화된 패스워드
	private String name;//사용자이름
	private String website;//홈페이지 주소
	private String bio;//자기소개
	private String email;
	private String phone;
	private String gender;
	private String profileImage;//프로파일 사진 경로+이름
	
	//(1)findbyid()때만 동작
	//(2)findbyuserinfo() 제외
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Image> images = new ArrayList<>();
	
	@CreationTimestamp//자동으로 현재 시간이 세팅
	private Timestamp createDate;
	@CreationTimestamp
	private Timestamp updateDate;//유저정보 수정된날
	
	
}
