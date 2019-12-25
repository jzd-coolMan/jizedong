package cn.wang.dao;

import java.util.List;

import cn.wang.domain.cropSpecies;

public interface cropSpeciesMapper {
	// 通过原料类别查询品种
	public List<cropSpecies> selectThecs(int cropCategoryId);
	
	// 查询所有农作物种类
	public List<cropSpecies> selectAllNzw();
}