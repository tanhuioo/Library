package Controller.PersonalHomePage;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.HomePageService;
import service.impl.HomePageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@WebServlet("/homepagecover")
public class PersonalHomePageCoverServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        try {
            //鍒涘缓鏍稿績缁勪欢
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            //鎷垮埌涓�涓狥ileItem闆嗗悎
            List<FileItem> list = servletFileUpload.parseRequest(req);
            for(FileItem fileItem : list){
                //鍒ゆ柇浼犻�掓潵鐨勬槸鍚︽槸鏂囦欢
                if(fileItem.isFormField()){ //璇存槑鏄〃鍗曟暟鎹�,鍒欒鏄庡嚭鐜伴敊璇�
                    return;
                }else{ //璇存槑鏄枃浠�
                    String fileName = fileItem.getName();
                    //鑾峰彇杈撳叆娴�
                    InputStream inputStream = fileItem.getInputStream();

                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    //杈撳嚭娴佸啓鍥剧墖鏁版嵁
                    int temp = 0;
                    byte[] b = new byte[1024];
                    while ((temp = inputStream.read(b))!= -1){
                        out.write(b,0,temp);
                    }
//                   鑾峰彇鍥剧墖浜岃繘鍒舵暟鎹�
                    byte[] array = out.toByteArray();
                    HomePageServiceImpl homePageService = new HomePageServiceImpl();
                    //鑾峰彇session涓殑tel
                    HttpSession httpSession = req.getSession();
                    String tel = (String)httpSession.getAttribute("utel");
                    if(homePageService.UploadUserCover(array,tel)){
                        //鎴愬姛杩斿洖1
                        printWriter.write("1");
                    } else {
                        //澶辫触杩斿洖0
                        printWriter.write("0");
                    }
                    //鍏抽棴鐩稿叧缁勪欢
                    out.close();
                    inputStream.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
