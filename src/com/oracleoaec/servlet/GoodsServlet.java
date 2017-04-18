package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.entity.Goods;
import com.oracleoaec.entity.Pager;
import com.oracleoaec.service.IGoodService;
import com.oracleoaec.service.impl.GoodsServiceImpl;

public class GoodsServlet extends HttpServlet{
	private static final String ADD="1";
	private static final String QUERY="2";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		IGoodService igs = new GoodsServiceImpl();
		if(ADD.equals(id)){//添加
			for (int i = 0; i < 33; i++) {
				Goods goods = new Goods("苹果"+i, 1L+i, 3.3f);
				int addGoods = igs.addGoods(goods);
			}
		}else if(QUERY.equals(id)){//查询显示
			String page = req.getParameter("page");
			int p = 1;
			if(page != null){
				p = Integer.parseInt(page);
			}
			Pager pager = new Pager(p);
			List<Goods> list = igs.getAllGoods(pager);
			System.out.println(list);
			req.setAttribute("list", list);//将集合和page对象存入request作用域中
			req.setAttribute("pager", pager);
			if(list == null){
				//失败，重定向到主页
				resp.sendRedirect("index.jsp");
			}else{
				RequestDispatcher rd = req.getRequestDispatcher("goods.jsp");
				rd.forward(req, resp);//转发
			}
		}
	}

}













