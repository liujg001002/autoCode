package com.yintu.supply.common.restful;

/**
 * @Description: 响应码枚举，参考HTTP状态码的语义
 * @author kwah
 * @date 2018/4/19 09:42
 */
public enum ResCode {

	SUCCESS(200,"成功"),
	FAIL(400,"失败"),
	UNAUTHORIZED(401,"未认证（签名错误）"),
	UNAUTHEN(4401,"未登录"),
	UNAUTHZ(4403,"未授权，拒绝访问"),
	INTERNAL_SERVER_ERROR(500,"服务器内部错误");

	public int code;

	private String msg;

	private ResCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
