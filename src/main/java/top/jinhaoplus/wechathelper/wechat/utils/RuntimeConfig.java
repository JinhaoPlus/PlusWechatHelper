package top.jinhaoplus.wechathelper.wechat.utils;

import java.io.*;
import java.util.Properties;


public class RuntimeConfig {

    private Properties internalProperties = new Properties();

    private String pFileName;

    public RuntimeConfig(String pFileName) {

        this.pFileName = pFileName;
        InputStream inputStream = null;
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(pFileName);
            if (inputStream != null) {
                internalProperties.load(inputStream);
            } else {
                throw new RuntimeException("查找不到配置文件:" + pFileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("读取" + pFileName + "出错, 原因:" + e.getMessage(), e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized String getProperty(String key) {
        return internalProperties.getProperty(key);
    }

    public synchronized void setProperty(String key, String value) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(getClass().getClassLoader().getResource(pFileName).getFile());
            // 保存,并加入注释
            internalProperties.setProperty(key, value);
            internalProperties.store(outputStream, "Update Runtime Configs at");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("读取" + pFileName + "出错, 原因:" + e.getMessage(), e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
