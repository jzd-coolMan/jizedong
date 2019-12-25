package cn.wang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wang.dao.BacterialStrainInfoMapper;
import cn.wang.dao.SampleToxinInfoMapper;
import cn.wang.dao.SampleToxinMapper;
import cn.wang.domain.BacterialStrainInfo;
import cn.wang.domain.SampleToxin;
import cn.wang.domain.SampleToxinInfo;
import cn.wang.service.SampleToxinInfoService;

@Service
public class SampleToxinInfoServiceImpl implements SampleToxinInfoService {
	@Resource
	SampleToxinInfoMapper sampletoxininfodao;
	@Resource
	SampleToxinMapper sampletoxindao;
	@Resource
	BacterialStrainInfoMapper bacterialstraininfodao;

	// 查询所有毒素信息
	@Override
	public List<SampleToxinInfo> cxsyds() {
		return sampletoxininfodao.selectAll();
	}

	// 添加样品毒素信息
	@Override
	public int tianjiaypds(SampleToxin sa) {
		return sampletoxindao.insertdsxx(sa);
	}

	// 添加毒素菌株信息
	@Override
	public int tianjiadsjz(BacterialStrainInfo b) {
		return bacterialstraininfodao.insertdsjz(b);
	}

	// 查询一条样品的毒素信息
	@Override
	public List<SampleToxin> cxytyp(int id) {
		return sampletoxindao.selectOneds(id);
	}

	// 通过毒素ID查询
	@Override
	public List<SampleToxin> cxypid(String toxinId) {
		return sampletoxindao.selectXx(toxinId);
	}

	// 删除毒素菌株信息
	@Override
	public int shanchuJz(int sampleInfoId) {
		return bacterialstraininfodao.delectOnejz(sampleInfoId);
	}

	// 查询毒素菌株信息
	@Override
	public List<BacterialStrainInfo> chaxunJz(int id) {
		return bacterialstraininfodao.selectOnejz(id);
	}

	// 通过样品Id删除
	@Override
	public int shanchudusu(int id) {
		return sampletoxindao.delectId(id);
	}

	// 真正删除一条样本的毒素菌株信息
	@Override
	public int shanchudsjz(int sampleInfoId) {
		return bacterialstraininfodao.deleteThejz(sampleInfoId);
	}

}
