package demo.nlp.aliyun;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alinlp.model.v20200629.GetPosChEcomRequest;
import com.aliyuncs.alinlp.model.v20200629.GetPosChEcomResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @Author: zhouchao
 * @Date: 2021/08/06 17:27
 * @Description:
 */
public class AliyunNlpDemo {

    public static void main(String[] args) {
        DefaultProfile defaultProfile = DefaultProfile.getProfile(
                "cn-hangzhou",
                "LTAI5t8J9fPMePduSxneLkUW",
                "W3ePTW1keSGX7x8MsC9PzYtqqgfOIS");
        IAcsClient client = new DefaultAcsClient(defaultProfile);
        GetPosChEcomRequest request = new GetPosChEcomRequest();
        request.setSysEndpoint("alinlp.cn-hangzhou.aliyuncs.com");
        request.setServiceCode("alinlp");
        request.setText("这是一条文本");
        request.setTokenizerId("MAINSE");
        long start = System.currentTimeMillis();
        GetPosChEcomResponse response = null;
        try {
            response = client.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        System.out.println(response.hashCode());
        System.out.println(response.getRequestId() + "\n" + response.getData() + "\n" + "cost:" + (System.currentTimeMillis() - start));
    }

}
