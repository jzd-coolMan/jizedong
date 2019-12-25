package cn.wang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wang.dao.AddressTownMapper;
import cn.wang.domain.AddressTown;
import cn.wang.service.AddressTownService;

@Service
public class AddressTownServiceImpl implements AddressTownService {
	@Resource
	AddressTownMapper addresstowndao;

	// 查询所有省市县信息

		public AddressTown cxssx(String code) {
			return addresstowndao.selectTcp(code);
		}

	

}
