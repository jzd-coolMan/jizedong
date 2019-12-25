package cn.wang.dao;

import cn.wang.domain.cropCategory;

public interface cropCategoryMapper {
	// 通过ID查询
	public cropCategory selectThis(int id);
}