package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CaipinxinxiMapper;
import com.entity.Caipinxinxi;
import com.server.CaipinxinxiServer;
@Service
public class CaipinxinxiServerImpi implements CaipinxinxiServer {
   @Resource
   private CaipinxinxiMapper gdao;
	@Override
	public int add(Caipinxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Caipinxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Caipinxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Caipinxinxi> getsycaipinxinxi1(Map<String, Object> map) {
		return gdao.getsycaipinxinxi1(map);
	}
	public List<Caipinxinxi> getsycaipinxinxi2(Map<String, Object> map) {
		return gdao.getsycaipinxinxi2(map);
	}
	public List<Caipinxinxi> getsycaipinxinxi3(Map<String, Object> map) {
		return gdao.getsycaipinxinxi3(map);
	}
	
	@Override
	public Caipinxinxi quchongCaipinxinxi(Map<String, Object> account) {
		return gdao.quchongCaipinxinxi(account);
	}

	@Override
	public List<Caipinxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Caipinxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Caipinxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

