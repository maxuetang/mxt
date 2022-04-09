package com.mxt.problem.load;

import java.util.Map;
import java.util.TreeMap;

import com.mxt.config.MxtApiConfig;
import com.mxt.sign.SignHelper;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

public class ProblemSolve {
	public static JSONObject solveProblem(int pid, int ptype, String ans) {
		Map params = new TreeMap();
		params.put("merchant_id", MxtApiConfig.MERCHANT_ID							);
		params.put("ptype"		, ptype												);
		params.put("pid"		, pid												);
		params.put("order_id"	, System.currentTimeMillis()						);
		params.put("timestamp"	, System.currentTimeMillis()						);
		params.put("ans"		, ans												);
		params.put("sign"		, SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));
		return new JSONObject(HttpUtil.post(MxtApiConfig.PROBLEM_SOLVE_API, params));
	}
}
