package cn.edu.whpu.web.controller;

import cn.edu.whpu.service.CategoryService;
import cn.edu.whpu.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

      /*  List<Category> categoryList = categoryService.findAll();

        Result result = new Result();
        result.setFlag(true);
        result.setMsg("查询成功");
        result.setData(categoryList);

        writeJson(response,result);*/

         response.setContentType("application/json");
        String allByRedis = categoryService.findAllByRedis(); //返回的就是json数据

        response.getWriter().print(allByRedis);

    }
}
