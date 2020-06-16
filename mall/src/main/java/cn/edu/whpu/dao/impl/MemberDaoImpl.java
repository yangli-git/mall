package cn.edu.whpu.dao.impl;

import cn.edu.whpu.pojo.Member;
import cn.edu.whpu.utils.DateUtil;
import cn.edu.whpu.utils.JDBCUtils;
import cn.edu.whpu.dao.MemberDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class MemberDaoImpl implements MemberDao {

    //访问数据库使用QueryRunner对象来完成
    QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());


    //登陆
    @Override
    public Member findByMobileAndPwd(String mobile, String pwd) {

        String sql = "select * from member where mobile=? and pwd=?";
        Member member =null;
        try {
            member=runner.query(sql, new BeanHandler<>(Member.class), mobile, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return member;
    }


    @Override
    public Member findByMobile(String mobile) {
        String sql = "select * from member where mobile=?";
        Member member =null;
        try {
            member=  runner.query(sql, new BeanHandler<>(Member.class), mobile);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public void add(Member member) {
        String sql = "insert into member values(null,?,?,?,?,?,?,?)";

        try {
            runner.update(sql,member.getMobile(),member.getPwd(),member.getNick_name(),member.getReal_name(),member.getEmail(),member.getGender(), DateUtil.date2String(member.getRegister_time()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
