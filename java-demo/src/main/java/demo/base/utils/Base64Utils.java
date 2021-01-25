package demo.base.utils;

import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhouc
 * @Date: 2021/1/25 23:39
 * @Description:
 */
public class Base64Utils {

    /**
     * 文件转化成base64字符串
     * 将文件转化为字节数组字符串，并对其进行Base64编码处理
     */
    public static String getFileStr(String filePath) {
        File file = new File(filePath);
        FileInputStream inputFile = null;
        byte[] buffer = null;
        try {
            inputFile = new FileInputStream(file);
            buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
            inputFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(buffer);
    }

    public static void main(String[] args) {
        String result = Base64Utils.getFileStr("C:/Users/zhouc/Desktop/abc.wav");
        result = result.trim();

        Map<String, Object> map = new HashMap();
        map.put("voice_data", "data:audio/wav;base64," + result);
        map.put("voice_format", 1);
        map.put("voice_id", "22");
        String param = JacksonUtil.toJson(map);
        String s = HttpUtils.sendPost("http://10.10.10.122:8000/api/v1/ai/speech-recog", param);

        System.out.println(result);
        System.out.println(s);
    }
}
