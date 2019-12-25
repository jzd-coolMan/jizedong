package cn.wang.dao;

import java.util.List;

import cn.wang.domain.SampleToxin;

public interface SampleToxinMapper {
	// 添加样品毒素信息
	public int insertdsxx(SampleToxin sa);

	// 查询毒素信息
	public List<SampleToxin> selectOneds(int id);
	
	// 通过毒素ID查询
	public List<SampleToxin> selectXx(String toxinId);
	
	// 通过样品Id删除
	public int delectId(int id);
}