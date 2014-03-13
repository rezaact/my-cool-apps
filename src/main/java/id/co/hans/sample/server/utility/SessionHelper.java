package id.co.hans.sample.server.utility;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import id.co.hans.sample.shared.model.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionHelper {

    public static String session_name_filepath="filepath";

    public static String session_name_filename="filename";

    public static SessionHelper getInstance() {
        return new SessionHelper();
    }

    public HttpSession getHttpSession() {
        return getHttpServletRequest().getSession();
    }

    public HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest();
    }

    public User getUserFromSession() {
        User user = (User) getHttpSession().getAttribute("user");
        if (user != null) {
            return user;
        }
        return null;
    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static String MD5(String text)
            throws NoSuchAlgorithmException, UnsupportedEncodingException  {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        byte[] md5hash = new byte[32];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        md5hash = md.digest();
        return convertToHex(md5hash);
    }

    public boolean generateFileDownloadNE(List<String> list, String filepath, String filename){
        String status = "";
        try{
            FileWriter outFile = new FileWriter(filepath + "/" + filename);
            PrintWriter out = new PrintWriter(outFile);
            for (String data : list){
                out.println(data);
            }
            out.flush();
            out.close();
        }catch (Exception ex) {
            return false;
        }
        return true;
    }
}
