# springboot文件上传
- 源代码　https://github.com/xuwujing/springBoot-study
- 在application.properties中配置好下载到的路径（服务器路径），注意一下在写路径的时候，/home/jerry/test/需要多写一个/后面加上文件名
- 在application配置上传文件大小限制
   - 设置上传文件的大小限制 spring.servlet.multipart.max-file-size=100Mb，spring.servlet.multipart.max-request-size=100Mb
- 在controller中获得文件名＠Value(${filepath}),从前台获取到MultiPartFile 
- 构建UploadFile方法，void uploadFile(byte[] file,String filePath,String fileName),把file转化为字节流，fileName通过file.getOriginalFilename()进行获取
- File file=new File(filepath)建立目标服务器文件路径，如果不存在就建立filepath,file.mkdir()
-  FileOutputStream out=new FileOutputStream(filePath+fileName);建立管道流
- out.write(file); out.flush(); out.close();写入，刷新，关闭，一气呵成。。。
- 在前端配置<form enctype="multipart/form-data" method="post" action="/uploading">
  - enctype就是encodetype就是编码类型的意思。
  - multipart/form-data是指表单数据有多部分构成，既有文本数据，又有文件等二进制数据的意思
  - 默认情况下，enctype的值是application/x-www-form-urlencoded，不能用于文件上传，只有使用了multipart/form-data，才能完整的传递文件数据。



　
