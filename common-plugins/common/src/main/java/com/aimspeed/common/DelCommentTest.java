package com.aimspeed.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * 
 * @author AimSpeed
 */
public class DelCommentTest {
		
	
	private static ArrayList filelist = new ArrayList();
	public static void main(String[] args) throws IOException {
		refreshFileList("E:\\WorkSpaceBuffer\\Git\\AimSpeed\\customer\\dataintegrationservices");
//		updatePackageName("E:\\Buffer\\IDEA\\dataintegrationservices\\gatherer\\gatrepository\\src\\main\\resources");
		
		System.out.println(filelist.size());
	}
	
	public static void refreshFileList(String strPath) throws IOException {
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		
		if (files == null)
		return;
		
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				refreshFileList(files[i].getAbsolutePath());
			} else {
				String strFileName = files[i].getAbsolutePath().toLowerCase();
				
				if(files[i].getName().contains(".java")) {
					System.out.println("---"+strFileName);
					filelist.add(files[i].getAbsolutePath());
					
					//读取文件内容
	                ArrayList<String> list = new ArrayList<>();
	                String str = null;  
					FileInputStream inputStream = new FileInputStream(strFileName);  
	                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
					
	                while((str = bufferedReader.readLine()) != null){  
	                    //如果不是空串、添加到list、然后提交
	                    if(!str.contains("* @Date") 
	                    		&& !str.contains("* @date")
	                    		&& !str.contains("* @Title")
	                    		&& !str.contains("* @title")
	                    		&& !str.contains("* @Project")
	                    		&& !str.contains("* @project")
	                    		&& !str.contains("* @Package")
	                    		&& !str.contains("* @package")
	                    		&& !str.contains("* @FileName")
	                    		&& !str.contains("* @fileName")
	                    		&& !str.contains("* @ClassName")
	                    		&& !str.contains("* @className")) {
	                    	
	                    	if(str.contains("* @Description")) {
	                    		list.add(str.replace(" @Description", ""));
	                    	}else {
	                    		list.add(str);
	                    	}
	                    	
	                       
	                    }
	                } 
	                bufferedReader.close();
	                inputStream.close();
	                
	                
	                //写回到文本
	                FileOutputStream fileOutputStream = new FileOutputStream(strFileName); 
	                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
	                BufferedWriter bw = new BufferedWriter(outputStreamWriter); 

	                if(list.size() != 0)
	                    for (String string : list) {
	                        bw.write(string);
	                        bw.newLine();
	                        System.out.println(string);
	                    }
	                else if(list.size() == 0) {
	                    bw.write("");
	                }
	                bw.flush();
	                bw.close();
	                //file.delete();
				}				
			}
		}
	}
	
	public static void updatePackageName(String strPath) throws IOException {
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		
		if (files == null)
		return;
		
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				updatePackageName(files[i].getAbsolutePath());
			} else {
				String strFileName = files[i].getAbsolutePath().toLowerCase();
				
				if(files[i].getName().contains(".xml")) {
					//System.out.println("---"+strFileName);
					filelist.add(files[i].getAbsolutePath());
					
					//读取文件内容
	                ArrayList<String> list = new ArrayList<>();
	                String str = null;  
					FileInputStream inputStream = new FileInputStream(strFileName);  
	                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
					
	                while((str = bufferedReader.readLine()) != null){  
	                    //如果不是空串、添加到list、然后提交
	                    if(str.contains("com.aimspeed.mysql.vo.MySqlPageVo")) {
	                    	System.out.println("---------------------------------------");
	                    	str = str.replace("com.aimspeed.mysql.vo.MySqlPageVo", "com.aimspeed.mysql.vo.PageVo");
	                    }
	                    list.add(str);
	                } 
	                bufferedReader.close();
	                inputStream.close();
	                
	                
	                //写回到文本
	                FileOutputStream fileOutputStream = new FileOutputStream(strFileName); 
	                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
	                BufferedWriter bw = new BufferedWriter(outputStreamWriter); 

	                if(list.size() != 0)
	                    for (String string : list) {
	                        bw.write(string);
	                        bw.newLine();
	                        //System.out.println(string);
	                    }
	                else if(list.size() == 0) {
	                    bw.write("");
	                }
	                bw.flush();
	                bw.close();
	                //file.delete();
				}				
			}
		}
	}
}
