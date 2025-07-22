package com.neusoft.tijiancms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.tijiancms.mapper.OverallResultMapper;
import com.neusoft.tijiancms.po.OverallResult;
import com.neusoft.tijiancms.service.OverallResultService;

@Service
public class OverallResultServiceImpl implements OverallResultService{

	@Autowired
	private OverallResultMapper overallResultMapper;
	
	@Override
	public List<OverallResult> listOverallResultByOrderId(Integer orderId) {
		return overallResultMapper.listOverallResultByOrderId(orderId);
	}
	
	@Override
	public int removeOverallResult(Integer orId) {
		return overallResultMapper.removeOverallResult(orId);
	}
	
	@Override
	public int saveOverallResult(OverallResult overallResult) {
		return overallResultMapper.saveOverallResult(overallResult);
	}
	
	@Override
	public int updateOverallResult(OverallResult overallResult) {
		return overallResultMapper.updateOverallResult(overallResult);
	}
}
