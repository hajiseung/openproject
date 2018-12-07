package com.bitcamp.OpenProject.member.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberInfo {
//	객체는 반드시 Default생성자가 있어야 한다.
	private int idx;
	private String userID;
	private String userPW;
	private String userName;
	private String userPhoto;
	private MultipartFile photoFile;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	@Override
	public String toString() {
		return "MemberInfo [userID=" + userID + ", userPW=" + userPW + ", userName=" + userName + ", userPhoto="
				+ userPhoto + ", photoFile=" + photoFile + "]";
	}

}
