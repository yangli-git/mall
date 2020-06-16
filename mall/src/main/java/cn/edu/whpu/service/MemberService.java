package cn.edu.whpu.service;

import cn.edu.whpu.pojo.Member;

public interface MemberService {

     Member login(String mobile , String pwd);


     boolean regist(Member member);
}
