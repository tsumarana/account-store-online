package com.zjnu.web.servlet;

import com.alibaba.fastjson.JSON;
import com.zjnu.pojo.Brand;
import com.zjnu.pojo.Goods;
import com.zjnu.pojo.PageBean;
import com.zjnu.pojo.User;
import com.zjnu.servece.BrandService;
import com.zjnu.servece.GoodsService;
import com.zjnu.servece.impl.BrandServiceImpl;
import com.zjnu.servece.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/goods/*")
public class GoodsServlet extends BaseServlet{
    private GoodsService goodsService = new GoodsServiceImpl();
    //查看信息
    public void selectInfo(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        int id = Integer.parseInt(reader.readLine());
        Goods goods = goodsService.selectInfo(id);
        String jsonString = JSON.toJSONString(goods);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    //分页查询
    public void selectByPage(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        PageBean<Goods> goodsPageBean = goodsService.selectByPage(currentPage, pageSize);
        //转为JSON
        String jsonString = JSON.toJSONString(goodsPageBean);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    //按条件分页查询
    public void selectByPageAndCondition(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        Goods goods = JSON.parseObject(params, Goods.class);
        PageBean<Goods> goodsPageBean = goodsService.selectByPageAndCondition(currentPage, pageSize, goods);
        String jsonString = JSON.toJSONString(goodsPageBean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    //通过id查找
    public void selectById(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        System.out.println("进入selectByid");
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        Goods goods1 = JSON.parseObject(s, Goods.class);
        System.out.println(goods1.getId());
        Goods goods = goodsService.selectById(goods1.getId());
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(goods);
        resp.getWriter().write(jsonString);
    }
    //新增商品
    public void addGoods(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        req.setCharacterEncoding("utf-8");
        String readLine = req.getReader().readLine();
        Goods goods = JSON.parseObject(readLine, Goods.class);
        goodsService.addGoods(goods);
        resp.getWriter().write("success");
    }
    //通过id删除商品
    public void deleteById(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        req.setCharacterEncoding("utf-8");
        String readLine = req.getReader().readLine();
        Goods goods = JSON.parseObject(readLine, Goods.class);
        goodsService.deleteById(goods);
        resp.getWriter().write("success");
    }
}
