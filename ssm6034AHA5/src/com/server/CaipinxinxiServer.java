package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Caipinxinxi;

public interface CaipinxinxiServer {

  public int add(Caipinxinxi po);

  public int update(Caipinxinxi po);
  
  
  
  public int delete(int id);

  public List<Caipinxinxi> getAll(Map<String,Object> map);
  public List<Caipinxinxi> getsycaipinxinxi1(Map<String,Object> map);
  public List<Caipinxinxi> getsycaipinxinxi2(Map<String,Object> map);
  public List<Caipinxinxi> getsycaipinxinxi3(Map<String,Object> map);
  public Caipinxinxi quchongCaipinxinxi(Map<String, Object> acount);

  public Caipinxinxi getById( int id);

  public List<Caipinxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Caipinxinxi> select(Map<String, Object> map);
}
//	所有List
