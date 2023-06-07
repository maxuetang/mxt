package com.mxt.demo.problem;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import com.mxt.config.MxtApiConfig;
import com.mxt.sign.SignHelper;

import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

public class DemoProblem {
	
	//新增一个题目
	public static void addProblem() {
		String url = MxtApiConfig.PROBLEM_INSERT_API;
		Map params = new TreeMap();
		params.put("merchant_id", 	MxtApiConfig.MERCHANT_ID);
		params.put("email", 		MxtApiConfig.TEACHER_EMAIL);//机构下的码学堂教师账号
		params.put("timestamp", 	System.currentTimeMillis());
		params.put("ptype", 		7);//题目类型, 必须
		params.put("kp_ids", 		"3713,3714");//知识点ID,对应“节”,多个知识点用英文","分割,必须
		params.put("difficulty", 	1);//题目难度,{1,2,3,4,5},可选
		params.put("score", 		2.0);//题目分数,必须
		params.put("tags", 			"C语言,Java");//标签，可选
		params.put("upload_file_flag", 1);//主观题目时,1表示作答时允许上传文件,0表示作答时不允许上传文件,可选
		params.put("upload_image_flag", 1);//主观题目时,1表示作答时允许上传图片,0表示作答时不允许上传图片,可选
		
		params.put("time", 			1);//时间要求，单位s，程序填空、函数、编程题时，必须
		params.put("memory", 		32);//内存要求，单位M, 程序填空、函数、编程题时，必须
		params.put("language",		"c");//程序填空题、函数题时，必须
		
		params.put("sign", 			SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));//签名
		
		//以下内容不参与签名
		params.put("in", 			"输入要求说明html");//输入要求说明，程序填空题、函数题、程序题时，必须
		params.put("in_mk", 		"输入要求说明markdown");//输入要求说明，程序填空题、函数题、程序题时，可选(推荐上传)
		params.put("out", 			"输出要求说明");//输出要求说明，程序填空题、函数题、程序题时，必须
		params.put("out_mk", 		"输出要求说明markdown");//输入要求说明，程序填空题、函数题、程序题时，可选(推荐上传)
		params.put("sample_in_out", "[[\"样例输入1\",\"样例输出1\"],[\"样例输入2\",\"样例输出2\"]]");//附加的多个程序样例输入与输出,程序填空题、函数题、程序题时，可选
		params.put("tip", 			"提示html");//提示，程序填空题、函数题、程序题时，可选
		params.put("tip_mk", 		"提示markdown");//提示markdown，程序填空题、函数题、程序题时，可选
		params.put("src", 			"题目来源");//题目来源，程序填空题、函数题、程序题时，可选
		params.put("test_data_in_out", "[[\"3 4\",\"7\",10.0,\"data1\"],[\"10 20\",\"30\",10.0,\"data2\"]]");//测试输入输出，程序填空题、函数题、程序题时，必须
		
		params.put("desc", 			"这里是题面描述html-1");//题面描述,可以为html格式,必须
		params.put("markdown", 		"这里是题面描述markdown");//题面描述,markdown格式,可选,不传入时,不能在码学堂中修改题目
		params.put("source", 		"{\"0\":1,\"1\":0}");//题目资源/选项,当题目类型为判断、单选、多选、程序填空、函数题时必须传入,当为主观题时(评分标准及答案)可选，其他类型时无效
		params.put("source_mk", 	"$x_y$");//主观题目时，评分标准与答案的markdown,可选
		params.put("score_json", 	"{\"0\":\"10\",\"1\":\"10\"}");//主观题目时必须上传
		String result = HttpUtil.post(url, params);
		System.out.println("执行结果："+result);
	}
	//更新题目
	public static void updateProblem() {
		String url = MxtApiConfig.PROBLEM_UPDATE_API;
		Map params = new TreeMap();
		params.put("merchant_id", 	MxtApiConfig.MERCHANT_ID);
		params.put("email", 		MxtApiConfig.TEACHER_EMAIL);//机构下的码学堂教师账号
		params.put("timestamp", 	System.currentTimeMillis());
		params.put("ptype", 		7);//题目类型,必须
		params.put("pid", 			9219);//题目ID,必须
		params.put("kp_ids", 		"3713,3714");//知识点ID,对应“节”,多个知识点用英文","分割,可选
		params.put("difficulty", 	1);//题目难度,{1,2,3,4,5},可选
		params.put("score", 		2.0);//题目分数,可选
		params.put("tags", 			"C语言,Java");//标签，可选
		params.put("time", 			1);//时间要求，单位s，程序填空、函数、编程题时，可选
		params.put("memory", 		32);//内存要求，单位M, 程序填空、函数、编程题时，可选
		params.put("language",		"c");//程序填空题、函数题时有效，可选
		
		params.put("sign", 			SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));//签名
		//以下内容不参与签名
		params.put("in", 			"输入要求说明html");//输入要求说明，程序填空题、函数题、程序题时，可选
		params.put("in_mk", 		"输入要求说明markdown");//输入要求说明，程序填空题、函数题、程序题时，可选(推荐上传)
		params.put("out", 			"输出要求说明");//输出要求说明，程序填空题、函数题、程序题时，可选
		params.put("out_mk", 		"输出要求说明markdown");//输入要求说明，程序填空题、函数题、程序题时，可选(推荐上传)
		params.put("sample_in_out", "[[\"样例输入21\",\"样例输出21\"],[\"样例输入23\",\"样例输出23\"]]");//附加的多个程序样例输入与输出,程序填空题、函数题、程序题时，可选
		params.put("tip", 			"提示html");//提示，程序填空题、函数题、程序题时，可选
		params.put("tip_mk", 		"提示markdown");//提示markdown，程序填空题、函数题、程序题时，可选
		params.put("src", 			"题目来源");//题目来源，程序填空题、函数题、程序题时，可选
		
		params.put("desc", 			"这里是修改后的题面描述html");//题面描述,可以为html格式,必须
		params.put("markdown", 		"这里是修改后的题面描述markdown");//题面描述,markdown格式,可选,不传入时,不能在码学堂中修改题目
		params.put("source", 		"{\"0\":0,\"1\":1}");//题目资源/选项,当题目类型为判断、单选、多选、程序填空、函数题时传入,其他类型时无效
		params.put("score_json", 	"{\"0\":\"10\",\"1\":\"10\"}");//主观题目时上传
		
		String result = HttpUtil.post(url, params);
		System.out.println("执行结果："+result);
	}
	//删除题目
	public static void deleteProblem() {
		String url = MxtApiConfig.PROBLEM_DELETE_API;
		Map params = new TreeMap();
		params.put("merchant_id", 	MxtApiConfig.MERCHANT_ID);
		params.put("email", 		MxtApiConfig.TEACHER_EMAIL);//机构下的码学堂教师账号
		params.put("timestamp", 	System.currentTimeMillis());
		params.put("ptype", 		7);//题目类型,必须
		params.put("pid", 			9219);//题目ID,必须
		params.put("sign", 			SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));//签名
		
		String result = HttpUtil.post(url, params);
		System.out.println("执行结果："+result);
	}
	//上传编程题、程序填空题、函数题的测试数据
	public static void uploadTestData4Problem() {
		String url = MxtApiConfig.PROBLEM_BATCH_TEST_DATA_API;
		Map params = new TreeMap();
		params.put("merchant_id", 	MxtApiConfig.MERCHANT_ID);
		params.put("email", 		MxtApiConfig.TEACHER_EMAIL);//机构下的码学堂教师账号
		params.put("timestamp", 	System.currentTimeMillis());
		params.put("ptype", 		7);//题目类型,必须
		params.put("pid", 			16865);//题目ID,必须
		params.put("sign", 			SignHelper.sign(params, MxtApiConfig.MERCHANT_KEY));//签名
		
		HttpResponse res = HttpRequest.post(url).form(params).header("Content-Type", ContentType.MULTIPART.toString()).form("filein", new File("/Users/apple/Downloads/sample.zip")).execute();
		System.out.println("执行结果："+res.body());
	}
	public static void main(String []args) {
		//addProblem();
		//updateProblem();
		//deleteProblem();
		uploadTestData4Problem();
	}
}
