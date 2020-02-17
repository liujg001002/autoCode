package com.yintu.supply.restful;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 返回对象实体
 * @author kwah
 * @date 2018/4/19 09:43
 */
public class ResResult<T> implements Serializable {

	private static final long serialVersionUID = 3758864789222317092L;

	public int code;

	private String msg;

	private T data;

	public ResResult<T> setCode(ResCode resCode) {
		this.code = resCode.code;
		return this;
	}

	public int getCode() {
		return code;
	}

	public ResResult<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResResult<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		return data;
	}

	public ResResult<T> setData(T data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}