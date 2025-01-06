package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

public class MemberController {
	private MemberDao md = new MemberDao();

	public List<Member> selectMemberKeyword(String memberKeyword) {
		return md.selectMemberKeyword(memberKeyword);
	}

	public Member selectMemberOneById(String memberId) {
		return md.selectMemberOneById(memberId);
	}

	public int insertMember(String memberId, String memberPw, String memberName, String memberEmail, String memberPhone,
			String memberGender) {
		Member m = new Member(memberId, memberPw, memberName, memberEmail, memberPhone, memberGender);
		int result = md.insertMember(m);
		return result;
	}

	public List<Member> seletMemberAll() {
		List<Member> list = md.selectMemberAll();
		return list;
	}

	public Member selectMemberOneByIdAndPw(String id, String pw) {
		return md.selectMemberOneByIdAndPw(id, pw);
	}

	public int updateMemberInfo(int no, String name, String phone, String email) {
		return md.updateMemberInfo(no, name, phone, email);
	}

	public Member selectMemberForDelete(String id, String pw) {
		return md.selectMemberForDelete(id, pw);
	}

	public int deleteMemberInfo(int memberNo) {
		return md.deleteMemberInfo(memberNo);
	}
}