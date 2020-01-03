package com.fh.controller;
import com.alibaba.fastjson.JSON;
import com.fh.common.lgnore;
import com.fh.common.ServerResponse;
import com.fh.util.SystemConstant;
import com.fh.model.User;
import com.fh.service.UserService;
import com.fh.util.CreateValidateCode;
import com.fh.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 登陆
     * @param user
     * @return
     */
    @RequestMapping("login")
    @lgnore
    public ServerResponse login(User user){
        if (user!=null){
            //判断code是否正确
            String code = RedisUtil.get(user.getCode());
            if(code!=null){
                //判断该用户是否存在
                User us=userService.queryUserByName(user.getUserName());
                if (us!=null){
                    //判断该用户密码是否错误
                    if (us.getUserPwd().equals(user.getUserPwd())){
                        //把用户信息转换成json存放入redis中'
                        String userString = JSON.toJSONString(us);
                        RedisUtil.set(us.getUserid().toString(),userString);
                        //登陆成功
                        return ServerResponse.success(us.getUserid());
                    }else{
                        //密码错误
                        return ServerResponse.error(SystemConstant.USERPWD_ERROR);
                    }
                }else{
                    //该用户不存在
                    return ServerResponse.error(SystemConstant.USERNAME_NULL);
                }
            }else{
                //验证码错误
                return ServerResponse.error(SystemConstant.CODE_NULL);
            }
        }else{
            //用户信息为空
            return ServerResponse.error(SystemConstant.USER_NULL);
        }
    }


    /**
     * 获取验证码 并存放到redis中
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("getCode")
    public void getValidateCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        //创建输出流
        OutputStream outputStream = response.getOutputStream();
        //获取验证码
        CreateValidateCode createValidateCode = new CreateValidateCode();
        String generateVerifyCode = createValidateCode.getString();
        //将验证码存入redis中，做登录验证
        RedisUtil.set(generateVerifyCode,generateVerifyCode);
        System.out.println(generateVerifyCode);
        //获取验证码图片
        BufferedImage image = createValidateCode.getImage();
        ImageIO.write(image, "png", outputStream);
        //关流
        outputStream.flush();
        outputStream.close();

    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("register")
    public ServerResponse register(User user){
        //给会员一个初始状态为0
        user.setUserStatus(0);
        return userService.addUser(user);
    }

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @RequestMapping("sendCode")
    public ServerResponse sendCode(String phone){
        return userService.sendCode(phone);
    }

    /**
     * 判断是否登陆
     * @param request
     * @return
     */
    @RequestMapping("getUser")
    public ServerResponse getUser(HttpServletRequest request){
        String userId = request.getHeader("userId");
        String userString = RedisUtil.get(userId);
        Map map = JSON.parseObject(userString, Map.class);
        if (userString!=null){
            return ServerResponse.success(map);
        }
        return ServerResponse.error();
    }

    /**
     * 退出登陆
     * @param request
     * @return
     */
    @RequestMapping("loginOut")
    public ServerResponse loginOut(HttpServletRequest request){
        //获取用户信息
        String userId = request.getHeader("userId");
        if (userId!=null){
            //删除登陆信息
            RedisUtil.del(userId);
            return ServerResponse.success();
        }
        return ServerResponse.error();
    }


    /**
     * 信息完善
     * 该方法拦截
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("perfectUserMassage")
    public ServerResponse perfectUserMassage(User user,HttpServletRequest request, HttpServletResponse response){
        String userId = request.getHeader("userId");
        if (userId!=null){
           user.setUserid(Integer.valueOf(userId));
           //完善用户信息
            userService.updateUserMassage(user);
        }
        User user1 = userService.queryUserById(user.getUserid());
        String userString = JSON.toJSONString(user1);
        RedisUtil.set(userId,userString);
        return ServerResponse.success();
    }

    /**
     * 通过id 查询当前登陆的会员信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("queryUserById")
    public ServerResponse queryUserById(HttpServletRequest request,HttpServletResponse response){
        String userId = request.getHeader("userId");
        User user= null;
        if (userId!=null){
            user=userService.queryUserById(Integer.valueOf(userId));
        }
        return ServerResponse.success(user);
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @RequestMapping("queryUser")
    public ServerResponse queryUser(@RequestParam("id") Integer id){

        return userService.queryUser(id);
    }
}
