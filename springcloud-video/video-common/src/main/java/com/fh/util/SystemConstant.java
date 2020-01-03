package com.fh.util;

public class SystemConstant {


    public static final String LOGIN_CURRENT_USERNAME = "user";
    public static final String COOKIE_KEY = "login";
    public static final String LOGIN_PAGE = "/login.jsp";
    public static final String LOGIN_CURRENT_USER = "aaa";
    public static final String NOT_PREMISSION = "/noPremission.jsp";
    //public static final String AJAX_SESSION_TIME_OUT = "ajaxTime";
    public static final String PDF_TIMPATE_FILE_PATH = "1904A-ptf.html";
    public static final String EXCEL_TIMPATE_FILE_PATH = "1094A-excel.xml";
    public static final String WORD_TIMPATE_FILE_PATH = "1904A-wod.xml";
    public static final int COOKIE_OUT_TIME = 24 * 60 * 60;//cookie默认有效时间一天
    public static final int TOKEN_OUT_TIME =  3*24*60*60;//token默认有效时间三天
    public static final int COOKIE_OUT_TIME_DEFAULT = 30 * 60;//cookie默认有效时间半个小时
    public static final int LONGIN_USERNAME_ERROR = 1;
    public static final int LONGIN_PASSWORD_ERROR = 2;
    public static final int LONGIN_SUCCESS = 3;
    public static final int LOG_ERROR = 0;
    public static final int LOG_SUCCESS = 1;
    public static final String AJAX_SESSION_OUT = "timeOut";


    public static final String UPLOAD_FILE_PATH = "upload";
    public static final String CURRENT_RESOURCE = "current_resource";//当前用户所拥有的权限
    public static final String USER_RESOURCE = "user_resource:";//当前用户所拥有的权限
    public static final String ALL_RESOURCE = "all_resource";//所有用户所拥有的权限
    public static final String SECRET_KEY = "CXY(()$@10*06";//所有资源的key
    public static final String CODE = "code";//手机验证码
    public static final int CODE_OUT_TIME = 5 * 60;//手机验证码有效时间
    public static final String CATEGORYLIST = "categoryList";//商品分类
    public static final String TOKEN_IS_NULL = "token为空";//token 为空
    public static final String TOKEN_CHECK_ERROR = "token解析失败";//token 为空
    public static final String CART_KEY = "cart:";//
    public static final String Pay_KEY = "pay:";//
    public static final String RECEIPT_KEY = "receipt:";//
    public static final String PAY_TIME_OUT = "支付超时";//支付超时

    public static final int ORDER_STATUS_WAIT = 1;//订单支付状态 待支付
    public static final int ORDER_STATUS_SUCCESS = 2;//订单支付状态 支付成功
    public static final int Pay_STATUS_WAIT = 1;//支付状态 待支付
    public static final int Pay_STATUS_SUCCESS = 2;//支付状态 待支付
    public static final String MTOKEN_IS_NULL = "不存在mtoken";//token 为空
    public static final String SUBMIT_TOKEN_DISABLED = "提交token无效";//token 为空
    public static final String NOT_REPETE_CONFIRM = "不能重复提交";//token 为空

    public static final String TOKEN_KEY = "token_key:";//token_key:

    //用户信息为空
    public static final String USER_NULL="请填写用户信息";
    //该用户不存在
    public static final String USERNAME_NULL="该用户不存在";
    //用户密码错误
    public static final String USERPWD_ERROR="用户密码错误";
    //登陆成功
    public static final String LOGIN_SUCCESS="登陆成功";
    //code错误
    public static final String CODE_NULL="验证码错误";
    //该用户已存在
    public static final String USER_NOTNULL="该用户已存在";
    //手机号码已存在
    public static final String PHONE_NOTNULL="该手机号码已存在";

}
