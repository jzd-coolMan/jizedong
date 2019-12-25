package cn.wang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wang.dao.cropCategoryMapper;
import cn.wang.dao.cropSpeciesMapper;
import cn.wang.domain.cropCategory;
import cn.wang.domain.cropSpecies;
import cn.wang.service.cropSpeciesService;

@Service
public class cropSpeciesServiceImpl implements cropSpeciesService {
	@Resource
	cropSpeciesMapper cropSpeciesdao;
	@Resource
	cropCategoryMapper cropcategorydao;

	// 通过原料类别查询品种
	@Override
	public List<cropSpecies> cxpz(int cropCategoryId) {
		return cropSpeciesdao.selectThecs(cropCategoryId);
	}

	// 查询所有农作物种类
	@Override
	public List<cropSpecies> cxsynzw() {
		return cropSpeciesdao.selectAllNzw();
	}

	// 通过ID查询
	@Override
	public cropCategory cxzl(int id) {
		return cropcategorydao.selectThis(id);
	}
}
