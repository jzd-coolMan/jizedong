package cn.wang.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wang.domain.cropSpecies;
import cn.wang.service.cropSpeciesService;

@Controller
public class cropSpeciesCotroller {
	@Resource
	cropSpeciesService cropSpeciesService;

	// 通过原料类别查询品种
	@RequestMapping("/cxpz")
	@ResponseBody
	public Map<String, Object> cxpz(Integer cropCategoryId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<cropSpecies> list = cropSpeciesService.cxpz(cropCategoryId);
		map.put("cro", list);
		return map;
	}
	
	// 查询所有农作物种类
	@RequestMapping("/cxsynzw")
	@ResponseBody
	public Map<String, Object> cxsynzw(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<cropSpecies> list = cropSpeciesService.cxsynzw();
		map.put("nzw", list);
		return map;
	}
}
