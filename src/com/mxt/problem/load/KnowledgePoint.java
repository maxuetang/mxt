package com.mxt.problem.load;

import java.util.Map;
import java.util.TreeMap;

import com.mxt.config.MxtApiConfig;
import com.mxt.sign.SignHelper;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

public class KnowledgePoint {
	public static JSONObject getKnowledgePoint(long kp_id, long parent_id, int start) {
		Map params = new TreeMap();
		params.put("merchant_id", MxtApiConfig.MERCHANT_ID							);
		params.put("kp_id"		, kp_id												);
		params.put("parent_id"	, parent_id											);
		params.put("start"		, start												);
		params.put("timestamp"	, System.currentTimeMillis()						);
		params.put("sign"		, SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));
		
		return new JSONObject(HttpUtil.post(MxtApiConfig.KNOWLEDGE_POINT_API, params));
	}
}
