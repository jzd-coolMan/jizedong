package cn.wang.service;

import java.util.List;

import cn.wang.domain.SampleInfo;
import cn.wang.domain.SampleInfoWithBLOBs;

public interface SampleInfoService {


	// 查询所有信息
	public List<SampleInfoWithBLOBs> cxsy();
	
	// 模糊查询信息
	public List<SampleInfoWithBLOBs> chaxunTheyb(SampleInfo sampleInfo,List<Integer> list);
	
	// 删除一条样本信息
	public int shanchuOne(int id);
	
	// 查询一条样本信息
	public SampleInfoWithBLOBs chaxunytyb(int id);
	
	// 修改一条样本信息
	public int xiugaiyitiao(SampleInfoWithBLOBs s);
}
