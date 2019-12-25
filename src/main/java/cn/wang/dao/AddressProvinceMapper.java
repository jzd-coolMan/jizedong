package cn.wang.dao;

import java.util.List;

import cn.wang.domain.AddressProvince;

public interface AddressProvinceMapper {
	// 查询所有省信息
	public List<AddressProvince> selectAll();

	// 查询一条样品的省
	public AddressProvince selectTcp(String code);
}