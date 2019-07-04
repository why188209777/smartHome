package com.chongya.controller;
import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class QcloudSmsTest {

    @ResponseBody

    @RequestMapping("sendCode")
    public SmsMultiSenderResult findMyPhone(HttpServletRequest request) {
        SmsMultiSenderResult result=null;

        String phone=request.getParameter("phone");
        String address=request.getParameter("address");

        // 短信应用SDK AppID
        int appid = 1400226206; // 1400开头

        // 短信应用SDK AppKey
        String appkey = "e68b07cbde6eb532d321f989346df85c";

        // 需要发送短信的手机号码
        String[] phoneNumbers = {phone};

        // 短信模板ID，需要在短信应用中申请
        // NOTE: 这里的模板ID`7839`只是一个示例，
        // 真实的模板ID需要在短信控制台中申请
        int templateId = 366018;

        // 签名
        // NOTE: 这里的签名"腾讯云"只是一个示例，
        // 真实的签名需要在短信控制台中申请，另外
        // 签名参数使用的是`签名内容`，而不是`签名ID`
        String smsSign = "智能家居中控系统";

        // 指定模板ID单发短信
        try {
            String[] params = {address, "【智能家居中控系统】"};
            SmsMultiSender msender = new SmsMultiSender(appid, appkey);
            result = msender.sendWithParam("86", phoneNumbers,
                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.print(result);

        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }

        return  result;
    }
}

