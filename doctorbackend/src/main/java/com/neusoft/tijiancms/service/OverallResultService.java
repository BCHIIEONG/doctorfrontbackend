package com.neusoft.tijiancms.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import com.neusoft.tijiancms.po.OverallResult;

public interface OverallResultService {

	public List<OverallResult> listOverallResultByOrderId(Integer orderId);
	public int saveOverallResult(OverallResult overallResult);
	public int updateOverallResult(OverallResult overallResult);
	public int removeOverallResult(Integer orId);
}
