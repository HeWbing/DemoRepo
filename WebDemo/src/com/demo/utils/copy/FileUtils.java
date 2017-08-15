package com.demo.utils.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.sound.sampled.AudioFormat.Encoding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 操作文件工具类
 * @author He
 *
 */
public class FileUtils {

	private static Logger log = LoggerFactory.getLogger(FileUtils.class);
	/*设置编码格式*/
	public static final String ENCODING = "UTF-8";
	
	/**
	 * 一行一行的读文件
	 * @param path 文件路径
	 * @return 记录条数(实际条数需要减一)
	 */
	public static int ReadFile(String path){
		int resultCode = 0;	//返回放结果代码  0-当前没有访问记录；-1 - 访问异常 ，其余数字为访问次数
		File file = new File(path);
		BufferedReader reader = null;
		try {
			if (!file.exists()) {
				 file.createNewFile();
				 resultCode = 0;
			}else{
				reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            int line = 1;
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	                System.out.println("line " + line + ": " + tempString);
	                line++;
	            }
	            resultCode = line;
	            //reader.close();
			}
		} catch (Exception e) {
			log.error("读取登录信息文件发生异常",e.getMessage());
			resultCode = -1;
		}finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		return resultCode;
	}
	
	/**
	 * 一行一行的写文件
	 * @param msg
	 * @param fileName
	 * @return
	 */
	public static boolean writeToFile(String msg,String fileName){
		
		FileOutputStream out = null;  
		OutputStreamWriter outWriter = null;  
		BufferedWriter bufWrite = null;  
		try {  
			out = new FileOutputStream(fileName);
			outWriter = new OutputStreamWriter(out, "UTF-8");
			bufWrite = new BufferedWriter(outWriter);
            bufWrite.write(msg + "\r\n");   
        } catch (Exception e) {  
            e.printStackTrace();  
            System.out.println("读取" + fileName + "出错！");  
        } finally{
        	try {
				bufWrite.close();
				outWriter.close();  
	            out.close();  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }
		return false;
	}
		
}
