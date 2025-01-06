package com.gn.homework.model.vo;

import java.time.LocalDateTime;

public class Menu {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private LocalDateTime signupDate;

	private int songNo;
	private String songTitle;
	private String artist;
	private int playCount;

	private int playlistNo;

	public Menu() {
		super();
	}

	public Menu(int userNo, String userId, String userPw, String userName, LocalDateTime signupDate, int songNo,
			String songTitle, String artist, int playCount, int playlistNo) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.signupDate = signupDate;
		this.songNo = songNo;
		this.songTitle = songTitle;
		this.artist = artist;
		this.playCount = playCount;
		this.playlistNo = playlistNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(LocalDateTime signupDate) {
		this.signupDate = signupDate;
	}

	public int getSongNo() {
		return songNo;
	}

	public void setSongNo(int songNo) {
		this.songNo = songNo;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	public int getPlaylistNo() {
		return playlistNo;
	}

	public void setPlaylistNo(int playlistNo) {
		this.playlistNo = playlistNo;
	}

	@Override
	public String toString() {
		return "사용자 번호:" + userNo + ", 아이디:" + userId + ", 비밀번호:" + userPw + ", 이름:" + userName + ", 가입일:" + signupDate
				+ ", 노래 번호:" + songNo + ", 노래 제목:" + songTitle + ", 아티스트:" + artist + ", 재생횟수:" + playCount
				+ ", 플레이리스트 번호:" + playlistNo;
	}

}
