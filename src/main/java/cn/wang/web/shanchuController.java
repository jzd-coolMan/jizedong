package cn.wang.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wang.service.SampleInfoService;
import cn.wang.service.SampleToxinInfoService;

@Controller
public class shanchuController {
	@Resource
	SampleInfoService sampleinfoservice;
	@Resource
	SampleToxinInfoService sampletoxininfoservice;
	
	@RequestMapping("/scxx")
	public String scxx(Integer id) {
		sampleinfoservice.shanchuOne(id);
		sampletoxininfoservice.shanchuJz(id);
		return "redirect:/xxgl";
	}
}
