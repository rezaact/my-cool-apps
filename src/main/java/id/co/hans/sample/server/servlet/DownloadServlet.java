package id.co.hans.sample.server.servlet;

import id.co.hans.sample.server.utility.SessionHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String filepath = "";
        try{
            filepath = request.getSession().getAttribute(SessionHelper.session_name_filepath).toString();
            request.getSession().removeAttribute(SessionHelper.session_name_filepath);
        }catch(Exception e){
            filepath = "";
        }
        String filename = "";
        try{
            filename = request.getSession().getAttribute(SessionHelper.session_name_filename).toString();
            request.getSession().removeAttribute(SessionHelper.session_name_filename);
        }catch(Exception e){
            filename = "";
        }

        java.io.BufferedInputStream buf=null;
        ServletOutputStream myOut=null;

        try{
            response.setContentType("text/plain");
            response.addHeader("Content-Disposition","attachment; filename="+filename );

            myOut = response.getOutputStream( );
            File myfile = new File(filepath + "/" +  filename);

            response.setContentLength( (int) myfile.length( ) );

            FileInputStream input = new FileInputStream(myfile);
            buf = new java.io.BufferedInputStream(input);
            int readBytes = 0;

            //read from the file; write to the ServletOutputStream
            while((readBytes = buf.read( )) != -1){
                myOut.write(readBytes);
            }
            buf.close();
            myOut.flush();
            myOut.close();
            myfile.delete();
        } catch (java.io.IOException ioe){
            throw new ServletException(ioe.getMessage( ));
        } finally {
            //close the input/output streams
            if (myOut != null)
                myOut.close( );
            if (buf != null)
                buf.close( );
        }
    }
}
