package cn.wang.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wang.dao.SampleInfoMapper;
import cn.wang.domain.SampleInfo;
import cn.wang.domain.SampleInfoWithBLOBs;
import cn.wang.service.SampleInfoService;

@Service
public class SampleInfoServiceImpl implements SampleInfoService {
	@Resource
	SampleInfoMapper sampleinfodao;

	

	// 查询所有
	@Override
	public List<SampleInfoWithBLOBs> cxsy() {
		return sampleinfodao.selectAll();
	}

	// 模糊查询信息
	@Override
	public List<SampleInfoWithBLOBs> chaxunTheyb(SampleInfo sampleInfo, List<Integer> list) {
		List<SampleInfoWithBLOBs> bloBs = new ArrayList<>();
		if(list.size()==0) {
			SampleInfoWithBLOBs bloBs2 = sampleinfodao.selectTheyb(sampleInfo);
			bloBs.add(bloBs2);
		}else {
			for (int i = 0; i < list.size(); i++) {
				sampleInfo.setId(list.get(i));
				SampleInfoWithBLOBs bloBs2 = sampleinfodao.selectTheyb(sampleInfo);
				if (bloBs2 != null) {
					bloBs.add(bloBs2);
				}
			}
		}
		return bloBs;
	}

	// 删除一条样本信息
	@Override
	public int shanchuOne(int id) {
		return sampleinfodao.delectOneyb(id);
	}

	// 查询一条样本信息
	@Override
	public SampleInfoWithBLOBs chaxunytyb(int id) {
		return sampleinfodao.selectOneyb(id);
	}

	// 修改一条样本信息
	@Override
	public int xiugaiyitiao(SampleInfoWithBLOBs s) {
		return sampleinfodao.updateOneyangben(s);
	}

}
