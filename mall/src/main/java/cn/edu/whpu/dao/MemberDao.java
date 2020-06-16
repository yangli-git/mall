package cn.edu.whpu.dao;

import cn.edu.whpu.pojo.Member;

public interface MemberDao {

    public Member findByMobileAndPwd(String mobile, String pwd);

    public Member findByMobile(String mobile);

    public void add(Member member);
}
