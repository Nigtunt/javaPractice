package ioPractice;

import java.io.*;
import java.util.zip.*;

public class Zipio {
    public void zip(String zipFileName, File inputFile) throws Exception{
        ZipOutputStream out =new ZipOutputStream(new FileOutputStream( zipFileName));
        zip(out,inputFile,inputFile.getName());
        System.out.println("压缩完成");
        out.close();
    }
    private void zip(ZipOutputStream out, File f,String base)throws Exception{

        if(f.isDirectory()) {
            File[] fl = f.listFiles();
                out.putNextEntry(new ZipEntry(base+"/"));//创建base文件夹
            for (int i = 0; i < fl.length; i++) {
                zip(out,fl[i],base+"/"+fl[i].getName());
            }
        }
        else{
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in=new FileInputStream(f);
            int len;
            byte b[] = new byte[10*1024*1024];
            while((len=in.read(b))!=-1){
                out.write(b,0,len);
            }
            in.close();
        }
    }
    public void unZip(String unzipDirectory,File file){
        ZipInputStream zin;
        try{
            ZipFile zf=new ZipFile(file);
            zin=new ZipInputStream(new FileInputStream(file));
            ZipEntry entry;
            while((entry=zin.getNextEntry())!=null) {
                if (entry.isDirectory()) {
                    String dirPath = entry.getName();
                    File dir = new File(unzipDirectory+"/"+dirPath);
                    dir.mkdirs();
                } else {
                    File temp = new File(unzipDirectory+"/"+ entry.getName());
                    if (!temp.exists()) {
                        temp.createNewFile();
                        OutputStream os = new FileOutputStream(temp);
                        InputStream in = zf.getInputStream(entry);
                        BufferedInputStream bufferedInputStream=new BufferedInputStream(in);

                        byte []b = new byte[10*1024*1024];
                        int len = 0;
                        while ((len = bufferedInputStream.read(b)) != -1) {
                            os.write(b,0,len);
                        }
                        os.close();
                        in.close();
                    }
                    zin.closeEntry();
                }
            }
        } catch (ZipException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        Zipio book=new Zipio();
        long start = System.currentTimeMillis();
        try {
            book.zip("d://Product.zip",
                    new File("D://BaiduYunDownload/新建文件夹"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("压缩时间："+(end - start));
        start = System.currentTimeMillis();
        book.unZip("d://Product",new File("d://Product.zip"));
        end = System.currentTimeMillis();
        System.out.println("解压时间:"+(end - start));
    }

}
