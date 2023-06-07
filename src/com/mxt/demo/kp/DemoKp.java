package com.mxt.demo.kp;

import java.util.Map;
import java.util.TreeMap;

import com.mxt.config.MxtApiConfig;
import com.mxt.sign.SignHelper;

import cn.hutool.http.HttpUtil;

public class DemoKp {
	//新增一门课程 
	public static void addCourse() {
		String url = MxtApiConfig.KNOWLEDGE_POINT_INSERT_API;
		Map params = new TreeMap();
		params.put("merchant_id", 	MxtApiConfig.MERCHANT_ID);
		params.put("kp_text", 		"数据结构与算法1");//课程名称,必须
		params.put("kp_level", 		1);//增加一门课程的标识,必须
		params.put("img_url", 		"https://www.maxuetang.cn/lxojres/index/img/ic_subject_2@2x.png");//封面图片地址,建议使用480x270的图片，可选
		params.put("email", 		MxtApiConfig.TEACHER_EMAIL);//机构下的码学堂教师账号
		params.put("kp_desc", 		"这是一门计算机专业课程");//课程描述，1000字以内，可选
		params.put("timestamp", 	System.currentTimeMillis());
		params.put("sign", 			SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));//签名
		String result = HttpUtil.post(url, params);
		System.out.println("执行结果："+result);
	}
	//新增一个章节
	public static void addKp() {
		String url = MxtApiConfig.KNOWLEDGE_POINT_INSERT_API;
		Map params = new TreeMap();
		params.put("merchant_id", 	MxtApiConfig.MERCHANT_ID);
		params.put("kp_text", 		"第二章 线性表");//课程/知识点/章节名称,必须
		params.put("kp_level", 		3);//增加章节的标识,2为章,3为节,必须
		params.put("parent_id", 	2500);//如果为kp_level为2时,这里加入课程kp_id,如果为3时,加入所属章的kp_id,必须
		params.put("show_flg", 		1);//章节显示顺序,默认为0,越大越靠后,可选
		params.put("email", 		MxtApiConfig.TEACHER_EMAIL);//机构下的码学堂教师账号
		params.put("timestamp", 	System.currentTimeMillis());
		params.put("sign", 			SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));
		String result = HttpUtil.post(url, params);
		System.out.println("执行结果："+result);
	}
	
	//更新课程或章节信息
	public static void updateKp() {
		String url = MxtApiConfig.KNOWLEDGE_POINT_UPDATE_API;
		Map params = new TreeMap();
		params.put("merchant_id", 	MxtApiConfig.MERCHANT_ID);
		params.put("kp_id", 		2500);//课程或章节ID,必须
		params.put("kp_text", 		"第二章 线性表修改2");//课程或章节名称,可选
		params.put("show_flg", 		10);//章节显示顺序,默认为0,越大越靠后,可选
		params.put("img_url", 		"https://www.maxuetang.cn/lxojres/index/img/ic_subject_2@2x.png");//封面图片地址(为课程时有效),建议使用480x270的图片，可选
		params.put("kp_desc", 		"这是一门计算机专业课程2");//课程描述，1000字以内，可选
		params.put("email", 		MxtApiConfig.TEACHER_EMAIL);//机构下的码学堂教师账号
		params.put("timestamp", 	System.currentTimeMillis());
		params.put("sign", 			SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));
		String result = HttpUtil.post(url, params);
		System.out.println("执行结果："+result);
	}
	
	//删除课程或章节信息
	public static void deleteKp() {
		String url = MxtApiConfig.KNOWLEDGE_POINT_DELETE_API;
		Map params = new TreeMap();
		params.put("merchant_id", 	MxtApiConfig.MERCHANT_ID);
		params.put("kp_id", 		2401);//课程或章节ID,必须
		params.put("email", 		MxtApiConfig.TEACHER_EMAIL);//机构下的码学堂教师账号
		params.put("timestamp", 	System.currentTimeMillis());
		params.put("sign", 			SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));
		String result = HttpUtil.post(url, params);
		System.out.println("执行结果："+result);
	}
	
	public static void main(String []args) {
		//addCourse();
		//addKp();
		//updateKp();
		//deleteKp();
	}
}
