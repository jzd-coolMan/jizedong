package cn.wang.dao;

import java.util.List;

import cn.wang.domain.AddressTown;

public interface AddressTownMapper {
	// 查询市包含的所有县
	public List<AddressTown> selectOneCity(String citycode);

	// 查询一条样品的县
	public AddressTown selectTcp(String code);
}