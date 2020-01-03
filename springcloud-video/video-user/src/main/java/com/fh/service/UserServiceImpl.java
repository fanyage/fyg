package com.fh.service;

import com.alibaba.fastjson.JSONObject;
import com.fh.common.ServerResponse;
import com.fh.util.SystemConstant;
import com.fh.mapper.UserMapper;
import com.fh.model.User;
import com.fh.util.RedisUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;



    //根据用户名查询该用户是否存在
    @Override
    public User queryUserByName(String userName) {
        return userMapper.queryUserByName(userName);
    }



    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public ServerResponse addUser(User user) {
        if (user!=null){
            String phoneCode = RedisUtil.get(user.getCode());
            //判断该验证码不存在
            if (phoneCode!=null){
                //删除redis验证码
                RedisUtil.del(user.getCode());
            //通过用户名查询该用户是否存在
            User usName= userMapper.queryUserByName(user.getUserName());
                if (usName==null){
                    //判断该手机号码是否存在
                    User usPhone=userMapper.queryUserByPhone(user.getPhone());
                        if (usPhone==null){
                            user.setCreateTime(new Date());
                            userMapper.addUser(user);
                        }else{
                            //该手机号码已存在
                            return ServerResponse.error(SystemConstant.PHONE_NOTNULL);
                        }
                }else{
                    //该用户已经存在
                    return ServerResponse.error(SystemConstant.USER_NOTNULL);
                }
            }else{
                //验证码不存在
                return ServerResponse.error(SystemConstant.CODE_NULL);
            }
        }else{
            //请填写用户信息
            return ServerResponse.error(SystemConstant.USER_NULL);
        }
        return ServerResponse.success();
    }

    /**
     * 给发送验证码
     * @param phone
     * @return
     */
    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
    @Override
    public ServerResponse sendCode(String phone) {
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);

        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

        Integer mobile_code = (int)((Math.random()*9+1)*100000);

        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "C27048564"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
                new NameValuePair("password", "0735bff87197d6bfa552f6ff6f29df33"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", phone),
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);

        try {
            client.executeMethod(method);

            String SubmitResult =method.getResponseBodyAsString();

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();

            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");
            if("2".equals(code)){
                //把短信验证码存入redis中,并设置时间60秒
                RedisUtil.setex(mobile_code.toString(),60000,mobile_code.toString());
                System.out.println("短信提交成功");
                return ServerResponse.success();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally{
            method.releaseConnection();
        }
        return ServerResponse.success();
    }

    /**
     * 信息完善
     * @param user
     */
    @Override
    public void updateUserMassage(User user) {
        userMapper.updateUserMassage(user);
    }

    /**
     * 通过id查询用户信息
     * @param valueOf
     * @return
     */
    @Override
    public User queryUserById(Integer valueOf) {

        return userMapper.queryUserById(valueOf);
    }

    @Override
    public ServerResponse queryUser(Integer id) {
        User user = userMapper.queryUserById(id);
        return ServerResponse.success(user);
    }


}
