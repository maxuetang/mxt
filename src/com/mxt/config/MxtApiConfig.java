package com.mxt.config;

public class MxtApiConfig {
	public static final String MERCHANT_ID					= "商户号"							;
	public static final String MERCHANT_KEY					= "商户密钥"							;
	public static final String SERVER_HOST 					= "https://mp.api.maxuetang.cn/"	;
	public static final String TEACHER_EMAIL				= "xxxxxxxxx@qq.com"				;//教师账号
	//查询
	public static final String PROBLEM_LOAD_API 			= SERVER_HOST + "problem"			;//加载题目
	public static final String PROBLEM_SOLVE_API 			= SERVER_HOST + "solve"				;//提交测评
	public static final String PROBLEM_RESULT_API 			= SERVER_HOST + "result"			;//测评结果
	public static final String KNOWLEDGE_POINT_API  		= SERVER_HOST + "kp"				;//加载知识点
	//更新
	public static final String KNOWLEDGE_POINT_INSERT_API 	= SERVER_HOST + "kp-insert"			;//增加知识点
	public static final String KNOWLEDGE_POINT_UPDATE_API 	= SERVER_HOST + "kp-update"			;//更新知识点
	public static final String KNOWLEDGE_POINT_DELETE_API 	= SERVER_HOST + "kp-delete"			;//删除知识点
	public static final String PROBLEM_INSERT_API 	        = SERVER_HOST + "problem-insert"	;//增加题目
	public static final String PROBLEM_UPDATE_API 	        = SERVER_HOST + "problem-update"	;//更新题目
	public static final String PROBLEM_DELETE_API 	        = SERVER_HOST + "problem-delete"	;//删除题目
	public static final String PROBLEM_BATCH_TEST_DATA_API	= SERVER_HOST + "problem-test-data"	;//删除题目
}
