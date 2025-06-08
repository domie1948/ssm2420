package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Caipinxinxi;
import com.server.CaipinxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class CaipinxinxiController {
	@Resource
	private CaipinxinxiServer caipinxinxiService;


   
	@RequestMapping("addCaipinxinxi.do")
	public String addCaipinxinxi(HttpServletRequest request,Caipinxinxi caipinxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		caipinxinxi.setAddtime(time.toString().substring(0, 19));
		caipinxinxiService.add(caipinxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "caipinxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:caipinxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateCaipinxinxi.do")
	public String doUpdateCaipinxinxi(int id,ModelMap map,Caipinxinxi caipinxinxi){
		caipinxinxi=caipinxinxiService.getById(id);
		map.put("caipinxinxi", caipinxinxi);
		return "caipinxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("caipinxinxiDetail.do")
	public String caipinxinxiDetail(int id,ModelMap map,Caipinxinxi caipinxinxi){
		caipinxinxi=caipinxinxiService.getById(id);
		map.put("caipinxinxi", caipinxinxi);
		return "caipinxinxi_detail";
	}
//	前台详细
	@RequestMapping("cpxxDetail.do")
	public String cpxxDetail(int id,ModelMap map,Caipinxinxi caipinxinxi){
		caipinxinxi=caipinxinxiService.getById(id);
		map.put("caipinxinxi", caipinxinxi);
		return "caipinxinxidetail";
	}
//	
	@RequestMapping("updateCaipinxinxi.do")
	public String updateCaipinxinxi(int id,ModelMap map,Caipinxinxi caipinxinxi,HttpServletRequest request,HttpSession session){
		caipinxinxiService.update(caipinxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:caipinxinxiList.do";
	}

//	分页查询
	@RequestMapping("caipinxinxiList.do")
	public String caipinxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caipinxinxi caipinxinxi, String caipinbianhao, String caipinmingcheng, String caipinleibie, String xiaoliang1,String xiaoliang2, String kucun1,String kucun2, String jiage1,String jiage2, String tupian, String caipinjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(caipinbianhao==null||caipinbianhao.equals("")){pmap.put("caipinbianhao", null);}else{pmap.put("caipinbianhao", caipinbianhao);}		if(caipinmingcheng==null||caipinmingcheng.equals("")){pmap.put("caipinmingcheng", null);}else{pmap.put("caipinmingcheng", caipinmingcheng);}		if(caipinleibie==null||caipinleibie.equals("")){pmap.put("caipinleibie", null);}else{pmap.put("caipinleibie", caipinleibie);}		if(xiaoliang1==null||xiaoliang1.equals("")){pmap.put("xiaoliang1", null);}else{pmap.put("xiaoliang1", xiaoliang1);}		if(xiaoliang2==null||xiaoliang2.equals("")){pmap.put("xiaoliang2", null);}else{pmap.put("xiaoliang2", xiaoliang2);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(caipinjianjie==null||caipinjianjie.equals("")){pmap.put("caipinjianjie", null);}else{pmap.put("caipinjianjie", caipinjianjie);}		
		int total=caipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caipinxinxi> list=caipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caipinxinxi_list";
	}
	
	
	
	@RequestMapping("cpxxList.do")
	public String cpxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caipinxinxi caipinxinxi, String caipinbianhao, String caipinmingcheng, String caipinleibie, String xiaoliang1,String xiaoliang2, String kucun1,String kucun2, String jiage1,String jiage2, String tupian, String caipinjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(caipinbianhao==null||caipinbianhao.equals("")){pmap.put("caipinbianhao", null);}else{pmap.put("caipinbianhao", caipinbianhao);}		if(caipinmingcheng==null||caipinmingcheng.equals("")){pmap.put("caipinmingcheng", null);}else{pmap.put("caipinmingcheng", caipinmingcheng);}		if(caipinleibie==null||caipinleibie.equals("")){pmap.put("caipinleibie", null);}else{pmap.put("caipinleibie", caipinleibie);}		if(xiaoliang1==null||xiaoliang1.equals("")){pmap.put("xiaoliang1", null);}else{pmap.put("xiaoliang1", xiaoliang1);}		if(xiaoliang2==null||xiaoliang2.equals("")){pmap.put("xiaoliang2", null);}else{pmap.put("xiaoliang2", xiaoliang2);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(caipinjianjie==null||caipinjianjie.equals("")){pmap.put("caipinjianjie", null);}else{pmap.put("caipinjianjie", caipinjianjie);}		
		int total=caipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caipinxinxi> list=caipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caipinxinxilist";
	}
	
	@RequestMapping("deleteCaipinxinxi.do")
	public String deleteCaipinxinxi(int id,HttpServletRequest request){
		caipinxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:caipinxinxiList.do";
	}
	
	
}
