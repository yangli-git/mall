package cn.edu.whpu.web.controller;

import cn.edu.whpu.common.Result;
import cn.edu.whpu.pojo.Member;
import cn.edu.whpu.service.MemberService;
import cn.edu.whpu.service.impl.MemberServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/*")
public class MemberServlet extends BaseServlet {
    MemberService memberService = new MemberServiceImpl();  //调用业务层的方法
    public void login(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        // response.setContentType("application/json");        //表示响应到前端的数据是一个json数据   "text/html"
        PrintWriter out = response.getWriter();



        //接收用户传过来的验证码
        String code = request.getParameter("code");
        //从session中取出服务器端生成的验证码
        String vaidatecode = (String)request.getSession().getAttribute("vaidatecode");
        //验证码取出后，就从session中销毁
        request.getSession().removeAttribute("vaidatecode");


        if(vaidatecode!=null&&vaidatecode.equalsIgnoreCase(code)){
            //1、接收用户传过来的手机号和密码
            String mobile = request.getParameter("mobile");
            String pwd = request.getParameter("pwd");

            //2、调用业务层判断手机号和密码是否正确
            Member member = memberService.login(mobile, pwd);
            //对member对象进行判断，如果为null则表示登陆失败，如果不null则表示登陆成功

            //创建一个结果对象
            Result result = new Result();
            if(member==null){

                result.setFlag(false);
                result.setMsg("登录失败");
            }else{

                //登陆成功之后需要将用户的信息保存到session中。
                HttpSession session = request.getSession();
                session.setAttribute("member",member);

                result.setFlag(true);
                result.setMsg("登录成功");
            }
            //将结果对象转换成json
            ObjectMapper mapper = new ObjectMapper();
            String resultJson = mapper.writeValueAsString(result);
            out.print(resultJson);
        }else{

            Result result = new Result();
            result.setMsg("验证码出错");
            result.setFlag(false);
            writeJson(response,result);
        }





    }

    public void logout(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        //销毁session
        HttpSession session = request.getSession();

        session.invalidate();

        Result result = new Result();
        result.setFlag(true);

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(result);

        response.getWriter().print(s);
    }

    public void register(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{

        HttpSession session = request.getSession();  //无则创建，有则获取
        Member member = (Member)session.getAttribute("member");   //如果已经登陆过member对象不为null,否则为null

        ObjectMapper mapper = new ObjectMapper();
        //返回的结果对象
        Result result = new Result();
        result.setFlag(true);
        result.setMsg("");
        result.setData(member);

        //转换成json
        String s = mapper.writeValueAsString(result);

        response.getWriter().print(s);
    }

    public void findNickName(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        HttpSession session = request.getSession();  //无则创建，有则获取
        Member member = (Member)session.getAttribute("member");   //如果已经登陆过member对象不为null,否则为null

        ObjectMapper mapper = new ObjectMapper();
        //返回的结果对象
        Result result = new Result();
        result.setFlag(true);
        result.setMsg("");
        result.setData(member);

        //转换成json
        writeJson(response,result);
    }






}
