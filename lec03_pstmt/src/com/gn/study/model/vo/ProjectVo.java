package com.gn.study.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjectVo {
	private int projectId; // PK(번호)
	private String projectName; // 프로젝트명
	private int projectManager; // FK(employee의 emp_id) -> 관리자 사번
	private LocalDateTime regDate; // 등록일
	private LocalDateTime modDate; // 수정일
	private String managerName; // 관리자 이름

	public ProjectVo() {
		super();
	}

	public ProjectVo(int projectId, String projectName, int projectManager, String managerName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManager = projectManager;
		this.managerName = managerName;
	}

	public ProjectVo(int projectId, String projectName, int projectManager, LocalDateTime regDate,
			LocalDateTime modDate, String managerName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManager = projectManager;
		this.regDate = regDate;
		this.modDate = modDate;
		this.managerName = managerName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(int projectManager) {
		this.projectManager = projectManager;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getModDate() {
		return modDate;
	}

	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd(E)");
		String managerInfo;
		if (managerName == null && projectManager == 0) {
			managerInfo = "미정";
		} else {
			managerInfo = managerName + "(" + projectManager + ")";
		}

		return "번호:" + projectId + ", 이름:" + projectName + ", 관리자:" + managerInfo + ", 등록일:" + regDate.format(dtf)
				+ ", 수정일:" + modDate.format(dtf);
	}

}
