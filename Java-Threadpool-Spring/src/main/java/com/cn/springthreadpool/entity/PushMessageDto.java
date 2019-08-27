package com.cn.springthreadpool.entity;


import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 与结算系统通信使用的消息dto
 * @version 创建时间：2019/2/19
 */
@Slf4j
@Data
public class PushMessageDto {

	private String uuid;

	private String type;//访问记录、订单

	//消息体
	private String body;

	private Long createAt;

	private String sign;

	public PushMessageDto(PushMessage pushMessage){
		this.uuid=pushMessage.getUuid();
		this.type=pushMessage.getType();
		this.body=pushMessage.getBody();
		this.createAt=pushMessage.getCreateAt().getTime();
	}

	/**
	 * 签名并将值设置到sign字段
	 * @param secret 密码
	 */
	public void sign(String secret){
		Map<String, Object> map = JSON.parseObject(JSON.toJSONString(this));
		//sign字段本身不参与签名
		map.remove("sign");
		Map<String, String> params = map.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey,
						e -> e.getValue().toString()));

		this.sign=getSignature(params,secret);
	}

	/**
	 * 签名生成算法
	 *
	 * @param params 请求参数集，所有参数必须已转换为字符串类型并进行encode
	 * @param secret 签名密钥
	 * @return 签名
	 * @throws Exception
	 */
	public static String getSignature(Map<String, String> params, String secret) {
		//将Map转换为TreeMap实现参数以其参数名的字典序升序进行排序
		Map<String, String> sortedParams = new TreeMap<>(params);
		Set<Map.Entry<String, String>> entrySet = sortedParams.entrySet();

		//遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
		StringBuilder baseString = new StringBuilder();
		try {
			for (Map.Entry<String, String> param : entrySet) {
				baseString.append(param.getKey()).append("=").append(URLEncoder.encode(param.getValue(),"UTF-8")).append("&");
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		//baseString.deleteCharAt(baseString.length() - 1);


		String fullString=baseString+secret;
		log.debug("fullString : "+fullString);

		return MD5(fullString);
	}

	private static String MD5(String str) {
		try {
			//生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			//计算md5函数
			md.update(str.getBytes());
			//digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			//BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}

