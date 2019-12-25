package cn.wang.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wang.domain.BacterialStrainInfo;
import cn.wang.domain.SampleInfoWithBLOBs;
import cn.wang.domain.SampleToxin;
import cn.wang.domain.cropCategory;
import cn.wang.service.SampleInfoService;
import cn.wang.service.SampleToxinInfoService;
import cn.wang.service.cropSpeciesService;

@Controller
public class xiugaiController {
	@Resource
	SampleInfoService sampleinfoservice;
	@Resource
	cropSpeciesService cropseciesservice;
	@Resource
	SampleToxinInfoService sampletoxininfoservice;

	// 显示单条样本信息：修改界面
	@RequestMapping("/updatexx")
	public String updatexx(int id, ModelMap map) {
		// 获取样本信息
		SampleInfoWithBLOBs s = sampleinfoservice.chaxunytyb(id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String har = (sdf.format(s.getHarvestTime()));
		String ctt = (sdf.format(s.getCreateTime()));
		// 获取品种信息
		cropCategory c = cropseciesservice.cxzl(s.getCropCategoryId());
		// 毒素信息查询
		List<SampleToxin> lis = sampletoxininfoservice.cxytyp(s.getId());
		// 毒素菌株信息查询
		List<BacterialStrainInfo> bas = sampletoxininfoservice.chaxunJz(s.getId());
		map.put("bas", bas);
		map.put("lis", lis);
		map.put("s", s);
		map.put("c", c);
		map.put("har", har);
		map.put("ctt", ctt);
		return "editIM";
	}
	
	// 修改样本信息
	@RequestMapping("/updateThe")
	public String updateTheSam(SampleInfoWithBLOBs s,Float[] toxinCount, Integer[] toxinId, String[] originalNum) {
		// 修改样品信息
		sampleinfoservice.xiugaiyitiao(s);
		// 删除毒素
		sampletoxininfoservice.shanchudusu(s.getId());
		SampleToxin sa = new SampleToxin();
		int a = toxinCount.length;
		for (int i = 0; i < a; i++) {
			sa.setSampleInfoId(s.getId());
			sa.setToxinCount(toxinCount[i]);
			sa.setToxinId(toxinId[i]);
			// 添加样品毒素信息
			sampletoxininfoservice.tianjiaypds(sa);
		}
		Date date = new Date();
		// 真正删除一条样本的毒素菌株信息
		sampletoxininfoservice.shanchudsjz(s.getId());
		BacterialStrainInfo b = new BacterialStrainInfo();
		if(originalNum == null) {
			return "redirect:/xxgl";
		}else {
			int bb = originalNum.length;
			for (int c = 0; c < bb; c++) {
				b.setCreateTime(date);
				b.setSampleInfoId(s.getId());
				b.setSampleNum(s.getSampleId());
				b.setOriginalNum(originalNum[c]);
				b.setIsdel(0);
				// 添加毒素菌株
				sampletoxininfoservice.tianjiadsjz(b);
			}
			return "redirect:/xxgl";
		}
	}
}
