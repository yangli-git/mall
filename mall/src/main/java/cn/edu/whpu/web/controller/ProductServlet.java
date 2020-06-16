package cn.edu.whpu.web.controller;


import cn.edu.whpu.common.PageBean;
import cn.edu.whpu.common.Result;
import cn.edu.whpu.pojo.Product;
import cn.edu.whpu.service.ProductService;
import cn.edu.whpu.service.impl.ProductServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

@WebServlet("/product/*")
public class ProductServlet extends BaseServlet {

    ProductService productService = new ProductServiceImpl();


    public void findPage(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        //获取到前台传过来的分类编号
        String categoryId = request.getParameter("categoryId");
        //获取前台传过来的当前页
        String page = request.getParameter("currentPage");
        //获取每页显示的记录数
        String size = request.getParameter("pageSize");

        int cateId=0;
        if(categoryId!=null){
            cateId=Integer.parseInt(categoryId);
        }

        int currenPage=1;  //如果前台没有传递当前页，则默认值为1
        if(page!=null){
            currenPage=Integer.parseInt(page);
        }

        int pageSize=10;//如果前台没有传递每页条数，则默认值为10
        if(size!=null){
            pageSize= Integer.parseInt(size);
        }

        PageBean<Product> pageBean = productService.findPage(cateId, currenPage, pageSize);

        writeJson(response,pageBean);
    }



    public void findById(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
            //接收前台传过来的商品编号
            String sid = request.getParameter("productId");
            int productId = Integer.parseInt(sid);

            //调用业层查询商品详情
            Product product = productService.findById(productId);

            //封装result对象进行返回
            Result result = new Result(true,product,"查询成功");

            //将result转换成json响应到前台
            writeJson(response,result);
    }



    public void add(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{

        Map<String, String[]> parameterMap = request.getParameterMap();
        Product product = new Product();
        try {
            BeanUtils.populate(product,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        product.setSale_time(new Date());
        product.setCreate_time(new Date());

        productService.add(product);
    }





/*    public void findByCate(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

        //获取到前台传过来的分类编号
        String cate_id = request.getParameter("cate_id");
        int cateid =0;    //如果用户没有传分类编号，则将分类编号的默认值设置为0，否则转换后正常赋值
        if(cate_id!=null){
            cateid=Integer.parseInt(cate_id);
        }

        //调用业务层根据分类来进行商品的查询
        List<Product> productList = productService.findByCateId(cateid);

        //构建一个结果对象
        Result result = new Result(true,productList,"查询成功");

        writeJson(response,result);


    }*/
}
