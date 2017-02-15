package com.jkthome.cmm.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jkthome.cmm.service.vo.FileMetaVO;

@Controller
@RequestMapping("/rest/controller")
public class JkthomeFileController {

	
	LinkedList<FileMetaVO> files = new LinkedList<FileMetaVO>();
	FileMetaVO fileMeta = null;
	/***************************************************
	 * URL: /rest/controller/upload  
	 * upload(): receives files
	 * @param request : MultipartHttpServletRequest auto passed
	 * @param response : HttpServletResponse auto passed
	 * @return LinkedList<FileMeta> as json format
	 ****************************************************/
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMetaVO> upload(MultipartHttpServletRequest request, HttpServletResponse response) {
 
		//1. build an iterator
		 Iterator<String> itr =  request.getFileNames();
		 MultipartFile mpf = null;

		 //2. get each file
		 while(itr.hasNext()){
			 
			 //2.1 get next MultipartFile
			 mpf = request.getFile(itr.next()); 
			 System.out.println(mpf.getOriginalFilename() +" uploaded! "+files.size());

			 //2.2 if files > 10 remove the first from the list
			 if(files.size() >= 10)
				 files.pop();
			 
			 //2.3 create new fileMeta
			 fileMeta = new FileMetaVO();
			 fileMeta.setFileName(mpf.getOriginalFilename());
			 fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
			 fileMeta.setFileType(mpf.getContentType());
			 
			 try {
				fileMeta.setBytes(mpf.getBytes());
				
				// copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream("D:/temp/files/"+mpf.getOriginalFilename()));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //2.4 add to files
			 files.add(fileMeta);
			 
		 }
		 
		// result will be like this
		// [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
		return files;
 
	}
	/***************************************************
	 * URL: /rest/controller/get/{value}
	 * get(): get file as an attachment
	 * @param response : passed by the server
	 * @param value : value from the URL
	 * @return void
	 * @throws UnsupportedEncodingException 
	 ****************************************************/
	@RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
	 public void get(HttpServletRequest request, HttpServletResponse response,@PathVariable String value) throws Exception{
//		 FileMeta getFile = files.get(Integer.parseInt(value));
//		 
//		 try {		
//			 	response.setContentType(getFile.getFileType());
//			 	response.setHeader("Content-disposition", "attachment; filename=\""+getFile.getFileName()+"\"");
//		        FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
//		 }catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//		 }

		/* start **/
        File file = new File("d:\\ko_office_professional_plus_2016_x86_x64_dvd_6968767.iso");
        System.out.println("DownloadView --> file.getPath() : " + file.getPath());
        System.out.println("DownloadView --> file.getName() : " + file.getName());
         
        String userAgent = request.getHeader("User-Agent");
        boolean ie = userAgent.indexOf("MSIE") > -1;
         
        String fileName = null;
         
        if(ie){
            fileName = URLEncoder.encode(file.getName(), "utf-8");
        } else {
            fileName = new String(file.getName().getBytes("utf-8"));
        }// end if;
        
        response.setContentType("application/octet-stream");
        response.setContentLength((int)file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
         
        OutputStream out = response.getOutputStream();
        FileInputStream fis = null;
         
        try {
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            if(fis != null){
                try{
                    fis.close();
                }catch(Exception e){}
            }
        }// try end;
         
        out.flush();
		/* end **/
	 }
 
}
