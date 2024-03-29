<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navigation">
	<a href="feed.html"> <img src="/images/logo.png" />
	</a> <input type="text" placeholder="Search">
	<div class="navigation__links">
		<a href="explore.html" class="navigation__link"> 
			<i class="fa fa-compass"></i>
		</a> 
		<a href="#" class="navigation__link like_popup"> 
			<i class="fa fa-heart-o"></i>
		</a> 
		<a href="profile.html" class="navigation__link"> 
			<i class="fa fa-user-o"></i>
		</a>
	</div>
</nav>

<!-- Modal 시작 -->
<div id="modal">
  <div id="like_popup_list">
    <div class="like_popup_item"> 
      <img src="/images/avatar.jpg" alt="코스사진">
      <p><a href="#">누가 누구의 사진을 좋아합니다.</a></p>
    </div>

    <div class="like_popup_item"> 
      <img src="/images/avatar.jpg" alt="코스사진">
      <p><a href="#">누가 누구의 사진을 좋아합니다.</a></p>
    </div>

    <div class="like_popup_close">
      <button type="button">닫기</button>
    </div>
  </div>
</div>
<!-- Modal 끝 --> 