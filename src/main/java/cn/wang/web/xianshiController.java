package cn.wang.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wang.domain.AddressTown;
import cn.wang.domain.SampleInfo;
import cn.wang.domain.SampleInfoWithBLOBs;
import cn.wang.domain.SampleToxin;
import cn.wang.service.AddressTownService;
import cn.wang.service.SampleInfoService;
import cn.wang.service.SampleToxinInfoService;

@Controller
public class xianshiController {
	@Resource
	SampleInfoService sampleinfoservice;
	@Resource
	AddressTownService addresstownservice;
	@Resource
	SampleToxinInfoService sampletoxininfoservice;

	// 显示所有信息
	@RequestMapping("/xxgl")
	public String xssy(ModelMap map,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum) {
		PageHelper.startPage(pageNum, 7);
		List<SampleInfoWithBLOBs> r = sampleinfoservice.cxsy();
		for (int i = 0; i < r.size(); i++) {
			SampleInfoWithBLOBs s = r.get(i);
			// 查询省市县
			AddressTown a = addresstownservice.cxssx(s.getCounty());
			String t = a.getName();
			String c = a.getAddresscity().getName();
			String d = a.getAddresscity().getAddressProvince().getName();
			String ssx = d + c + t;
			// 省市县
			s.setCounty(ssx);
			// 毒素信息查询
			List<SampleToxin> lis = sampletoxininfoservice.cxytyp(s.getId());
			String aa = "";
			for (int x = 0; x < lis.size(); x++) {
				// 毒素信息表
				SampleToxin to = lis.get(x);
				aa += to.getSampletoxininfo().getToxinType() + ",";
			}
			// 截掉最后一个','
			aa = aa.substring(0, aa.length() - 1);
			s.setDsm(aa);
		}
		PageInfo<SampleInfoWithBLOBs> pageInfo = new PageInfo<>(r);
		map.put("r", pageInfo.getList());
		map.put("pageInfo", pageInfo);
		map.put("pageNum", pageNum);
		return "IM";
	}

	/**
	 * 
	 * @param pageNum
	 *            页数
	 * @param sampleId
	 *            样品编号
	 * @param pollutionRate
	 *            污染率
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param day
	 *            日
	 * @param toxinType
	 *            毒素ID
	 * @param cropSpecies
	 *            农作物种类
	 * @param province
	 *            省
	 * @param city
	 *            市
	 * @param county
	 *            县
	 * @param map
	 *            map集合
	 * @return
	 * @throws ParseException
	 */
	// 模糊查询
	@RequestMapping("/mhcx")
	public String mhcx(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			String sampleId, String pollutionRate, String year, String month, String day, String toxinType,
			String cropSpecies, String province, String city, String county, ModelMap map) throws ParseException {
		PageHelper.startPage(pageNum, 7);
		SampleInfo sampleInfo = new SampleInfo();
		List<Integer> list = new ArrayList<>();
		// 查询毒素种类
		if (!("undefined".equals(toxinType)) && !(("0").equals(toxinType))) {
			List<SampleToxin> s = sampletoxininfoservice.cxypid(toxinType);
			for (int i = 0; i < s.size(); i++) {
				SampleToxin sa = s.get(i);
				int id = sa.getSampleInfoId();
				list.add(id);
			}
		}
		sampleInfo.setSampleId(sampleId);
		sampleInfo.setBreed(Integer.parseInt(cropSpecies));
		sampleInfo.setProvince(province);
		sampleInfo.setCity(city);
		sampleInfo.setCounty(county);
		// 污染率判断
		if (!("".equals(pollutionRate))) {
			String[] poll = pollutionRate.split("-");
			sampleInfo.setAaa(Integer.parseInt(poll[0]));
			sampleInfo.setB(Integer.parseInt(poll[1]));
		}
		String harvestTime = null;
		if (!("0".equals(year)) && !("0".equals(month)) && !("0".equals(day))) {
			if ((month.length() == 1) && (day.length() == 1)) {
				harvestTime = year + "-0" + month + "-0" + day;
			} else if ((month.length() == 1) && (day.length() == 2)) {
				harvestTime = year + "-0" + month + "-" + day;
			} else if ((month.length() == 2) && (day.length() == 1)) {
				harvestTime = year + "-" + month + "-0" + day;
			} else if ((month.length() == 2) && (day.length() == 2)) {
				harvestTime = year + "-" + month + "-" + day;
			}
			sampleInfo.setDsm(harvestTime);
		} else if (!("0".equals(year)) && !("0".equals(month))) {
			if (month.length() == 1) {
				harvestTime = year + "-0" + month;
			} else {
				harvestTime = year + "-" + month;
			}
			sampleInfo.setDsm(harvestTime);
		} else if (!("0".equals(year))) {
			harvestTime = year;
			sampleInfo.setDsm(harvestTime);
		}
		List<SampleInfoWithBLOBs> r = sampleinfoservice.chaxunTheyb(sampleInfo, list);
		for (int i = 0; i < r.size(); i++) {
			SampleInfoWithBLOBs s = r.get(i);
			// 查询省市县
			AddressTown a = addresstownservice.cxssx(s.getCounty());
			String t = a.getName();
			String c = a.getAddresscity().getName();
			String d = a.getAddresscity().getAddressProvince().getName();
			String ssx = d + c + t;
			// 省市县
			s.setCounty(ssx);
			// 毒素信息查询
			List<SampleToxin> lis = sampletoxininfoservice.cxytyp(s.getId());
			String aa = "";
			for (int x = 0; x < lis.size(); x++) {
				// 毒素信息表
				SampleToxin to = lis.get(x);
				aa += to.getSampletoxininfo().getToxinType() + ",";
			}
			// 截掉最后一个','
			aa = aa.substring(0, aa.length() - 1);
			s.setDsm(aa);
		}
		PageInfo<SampleInfoWithBLOBs> pageInfo = new PageInfo<>(r);
		map.put("r", pageInfo.getList());
		map.put("pageInfo", pageInfo);
		map.put("pageNum", pageNum);
		map.put("cropSpecies", cropSpecies);
		map.put("toxinType", toxinType);
		map.put("province", province);
		map.put("city", city);
		map.put("county", county);
		map.put("sampleId", sampleId);
		map.put("pollutionRate", pollutionRate);
		return "IM";
	}
}
