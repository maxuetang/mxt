package com.mxt.problem.load;

import java.util.Map;
import java.util.TreeMap;

import com.mxt.config.MxtApiConfig;
import com.mxt.sign.SignHelper;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

public class ProblemRemote {
	
	public static JSONObject getProblems(int ptype, int start) {
		Map params = new TreeMap();
		params.put("merchant_id", MxtApiConfig.MERCHANT_ID							);
		params.put("ptype"		, ptype												);
		params.put("start"		, start												);
		params.put("timestamp"	, System.currentTimeMillis()						);
		params.put("sign"		, SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));
		
		return new JSONObject(HttpUtil.post(MxtApiConfig.PROBLEM_LOAD_API, params));
	}
	public static JSONObject getProblem(int ptype, int pid) {
		Map params = new TreeMap();
		params.put("merchant_id", MxtApiConfig.MERCHANT_ID							);
		params.put("ptype"		, ptype												);
		params.put("pid"		, pid												);
		params.put("timestamp"	, System.currentTimeMillis()						);
		params.put("sign"		, SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));
		
		return new JSONObject(HttpUtil.post(MxtApiConfig.PROBLEM_LOAD_API, params));
	}
	public static void main(String []args) {
		System.out.println(getProblems(1,0));
	}
}
