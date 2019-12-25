package cn.wang.dao;

import java.util.List;

import cn.wang.domain.SampleInfo;
import cn.wang.domain.SampleInfoWithBLOBs;

public interface SampleInfoMapper {

	// 查询所有信息
	public List<SampleInfoWithBLOBs> selectAll();
	
	// 模糊查询信息
	public SampleInfoWithBLOBs selectTheyb(SampleInfo sampleInfo);
	
	// 删除一条样本信息
	public int delectOneyb(int id);
	
	// 查询一条样本信息
	public SampleInfoWithBLOBs selectOneyb(int id);
	
	// 修改一条样本信息
	public int updateOneyangben(SampleInfoWithBLOBs s);
}