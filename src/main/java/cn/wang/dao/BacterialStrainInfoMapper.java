package cn.wang.dao;

import java.util.List;

import cn.wang.domain.BacterialStrainInfo;

public interface BacterialStrainInfoMapper {
    // 添加毒素菌株信息
	public int insertdsjz(BacterialStrainInfo b);
	
	// 删除毒素菌株信息
	public int delectOnejz(int sampleInfoId);
	
	// 查询毒素菌株信息
	public List<BacterialStrainInfo> selectOnejz(int id);
	
	// 真正删除一条样本的毒素菌株信息
	public int deleteThejz(int sampleInfoId);
}