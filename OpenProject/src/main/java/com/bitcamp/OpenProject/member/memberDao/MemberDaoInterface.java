package com.bitcamp.OpenProject.member.memberDao;

import com.bitcamp.OpenProject.member.model.MemberInfo;

public interface MemberDaoInterface {

	public int insertMemberInfo(MemberInfo memberInfo);

	public MemberInfo getMemberInfo(String id);

	public int ModifyMemberInfo(MemberInfo memberInfo);
}
