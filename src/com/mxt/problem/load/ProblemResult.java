package com.mxt.problem.load;

import java.util.Map;
import java.util.TreeMap;

import com.mxt.config.MxtApiConfig;
import com.mxt.sign.SignHelper;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

public class ProblemResult {
	public static JSONObject resultProblem(int pid, int ptype, long solve_id) {
		Map params = new TreeMap();
		params.put("merchant_id", MxtApiConfig.MERCHANT_ID							);
		params.put("ptype"		, ptype												);
		params.put("pid"		, pid												);
		params.put("timestamp"	, System.currentTimeMillis()						);
		params.put("solve_id"	, solve_id												);
		params.put("sign"		, SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));
		return new JSONObject(HttpUtil.post(MxtApiConfig.PROBLEM_RESULT_API, params));
	}
}
