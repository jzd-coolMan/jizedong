package cn.wang.dao;

import java.util.List;

import cn.wang.domain.SampleToxinInfo;

public interface SampleToxinInfoMapper {
	//查询所有毒素信息
    public List<SampleToxinInfo> selectAll();
}