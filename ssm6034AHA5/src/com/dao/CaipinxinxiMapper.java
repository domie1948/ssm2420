package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Caipinxinxi;

public interface CaipinxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Caipinxinxi record);

    int insertSelective(Caipinxinxi record);

    Caipinxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Caipinxinxi record);
	
    int updateByPrimaryKey(Caipinxinxi record);
	public Caipinxinxi quchongCaipinxinxi(Map<String, Object> caipinbianhao);
	public List<Caipinxinxi> getAll(Map<String, Object> map);
	public List<Caipinxinxi> getsycaipinxinxi1(Map<String, Object> map);
	public List<Caipinxinxi> getsycaipinxinxi3(Map<String, Object> map);
	public List<Caipinxinxi> getsycaipinxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Caipinxinxi> getByPage(Map<String, Object> map);
	public List<Caipinxinxi> select(Map<String, Object> map);
//	所有List
}

