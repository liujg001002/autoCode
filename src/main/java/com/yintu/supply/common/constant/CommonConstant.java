package com.yintu.supply.common.constant;

public class CommonConstant {

	/**
	 * 设置入账状态0未入账
	 */
	public static final Byte ACCOUNTING_STATUS0 = 0;
	/*
	*设置入账状态0未入账1已入账
	 */
	public static final Byte ACCOUNTING_STATUS1 = 1;
	/*
	*来源0自购返现
	 */
	public static final Byte SOURCE0 = 0;
	/*
	 *来源1推荐返现
	 */
	public static final Byte SOURCE1 = 1;

	/*
	 *来源2业绩返利
	 */
	public static final Byte SOURCE2 = 2;
	/*
	 *来源3提现
	 */
	public static final Byte SOURCE3 = 3;

	/*
	 *来源自购返现
	 */
	public static final String SOURCEMSG0 = "自购返现";
	/*
	 *来源1推荐返现
	 */
	public static final String SOURCEMSG1 = "推荐返现";

	/*
	 *来源2业绩返利
	 */
	public static final String SOURCEMSG2 = "月享红包";
	/*
	 *来源3提现
	 */
	public static final String SOURCEMSG3 = "提现";

	/*
	 *设置供应商是否需结算0无需结算
	 */
	public static final Byte STLSTATUS0 = 0;
	/*
	 *设置供应商是否需结算1需要结算
	 */
	public static final Byte STLSTATUS1 = 1;
	/*
	 *设置(备用)供应商逻辑处理消息发送状态0未发送
	 */
	public static final Byte SENDSTATUS0 = 0;
	/*
	 *设置(备用)供应商逻辑处理消息发送状态1发送失败
	 */
	public static final Byte SENDSTATUS1 = 1;
	/*
	 *设置(备用)供应商逻辑处理消息发送状态2发送成功
	 */
	public static final Byte SENDSTATUS2 = 2;
	/*
	 *设置操作类型 0创建
	 */
	public static final String OPTYPE0 = "0";
	/*
	 *设置操作类型 1修改
	 */
	public static final String OPTYPE1 = "1";
	/*
	 *设置操作类型 2提现
	 */
	public static final String OPTYPE2 = "2";
	/*
	 *设置操作类型 3冻结
	 */
	public static final String OPTYPE3 = "3";
	/*
	 *设置操作类型 4审核
	 */
	public static final String OPTYPE4 = "4";

	/*
	 *设置操作类型 0入账中
	 */
	public static final String STATE0 = "0";
	/*
	 *设置操作类型 1已入账
	 */
	public static final String STATE1 = "1";
	/*
	 *设置操作类型 2提现中
	 */
	public static final String STATE2 = "2";
	/*
	 *设置操作类型 3已提现
	 */
	public static final String STATE3 = "3";
	/*
	 *设置操作类型 4冻结
	 */
	public static final String STATE4 = "4";

	/**
	 * 设置非会员
	 */
	public static final Byte VIP0 = 0;
	/*
	 *设置是会员
	 */
	public static final Byte VIP1 = 1;
	/*
	 *设置是会员欠费中
	 */
	public static final Byte VIP2 = 2;

	/*
	 *设置是会员缓冲期会员
	 */
	public static final Byte VIP3 = 3;

	/*
	 *设置无效
	 */
	public static final Byte ACHIEVE0 = 0;

	/*
	 *设置有效
	 */
	public static final Byte ACHIEVE1 = 1;
	/*
	 * 是否是缓冲期：不是
	 */
	public static final Byte BUFFER0 = 0;

	/*
	 * 是否是缓冲期：是
	 */
	public static final Byte BUFFER1 = 1;

	/*
	 * 月享红包错误类型 支付创建
	 */
	public static final Byte MONTHENJOERRORTYPE0 = 0;

	/*
	 * 月享红包错误类型 会员续费
	 */
	public static final Byte MONTHENJOERRORTYPE1 = 1;

	/*
	 * 0未推送
	 */
	public static final Byte PUSH0 = 0;

	/*
	 * 1已推送
	 */
	public static final Byte PUSH1 = 1;

	/*
	 * 0无效果
	 */
	public static final Byte EFFECT0 = 0;

	/*
	 * 1有效果
	 */
	public static final Byte EFFECT1 = 1;





}