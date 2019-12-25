package cn.wang.service;

import java.util.List;

import cn.wang.domain.cropCategory;
import cn.wang.domain.cropSpecies;

public interface cropSpeciesService {
	// 通过原料类别查询品种
	public List<cropSpecies> cxpz(int cropCategoryId);
	
	// 查询所以有农作物种类
	public List<cropSpecies> cxsynzw();
	
	// 通过ID查询
	public cropCategory cxzl(int id);
}
