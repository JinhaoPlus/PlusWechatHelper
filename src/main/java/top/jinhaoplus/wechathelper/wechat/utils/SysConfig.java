package top.jinhaoplus.wechathelper.wechat.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class SysConfig {

	/**
	 * 得到根目录下的配置文件
	 */
	public static Properties getProperties(String conFile){
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = SysConfig.class.getResourceAsStream("/"+conFile);//不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从ClassPath根下获取
			if(inputStream != null){
				properties.load(inputStream);
			}else{
				throw new RuntimeException("查找不到"+ conFile + "配置文件");
			}
		} catch (Exception e) {
			throw new RuntimeException("读取" + conFile + "出错,原因：" + e.getMessage(), e);
		} finally{
			try {
				if(inputStream != null){
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return  properties;
	}

}
