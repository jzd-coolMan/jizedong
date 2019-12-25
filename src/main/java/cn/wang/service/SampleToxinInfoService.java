package cn.wang.service;

import java.util.List;

import cn.wang.domain.BacterialStrainInfo;
import cn.wang.domain.SampleToxin;
import cn.wang.domain.SampleToxinInfo;

public interface SampleToxinInfoService {
	// 查询所有毒素信息
	public List<SampleToxinInfo> cxsyds();

	// 添加样品毒素信息
	public int tianjiaypds(SampleToxin sa);
	
	// 添加毒素菌株信息
	public int tianjiadsjz(BacterialStrainInfo b);
	
	// 查询毒素信息
	public List<SampleToxin> cxytyp(int id);
	
	// 通过毒素ID查询
	public List<SampleToxin> cxypid(String toxinId);
	
	// 删除毒素菌株信息
	public int shanchuJz(int sampleInfoId);
	
	// 查询毒素菌株信息
	public List<BacterialStrainInfo> chaxunJz(int id);
	
	// 通过样品ID删除
	public int shanchudusu(int id);
	
	// 真正删除一条样本的毒素菌株信息
	public int shanchudsjz(int sampleInfoId);
}
