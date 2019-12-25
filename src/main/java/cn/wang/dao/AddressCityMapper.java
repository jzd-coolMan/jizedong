package cn.wang.dao;

import java.util.List;

import cn.wang.domain.AddressCity;

public interface AddressCityMapper {


	// 查询一条样品的市
	public AddressCity selectTcp(String code);
}