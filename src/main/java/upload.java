import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.SQLData;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: shushkov
 * Date: 18.11.14
 * Time: 17:19
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(name = "simpleServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class upload extends HttpServlet {

    private final static String rootDir = new String("C:\\apache-tomcat-7.0.53\\apache-tomcat-7.0.53\\webapps\\tmp");

    private final static Logger LOGGER =
            Logger.getLogger(upload.class.getCanonicalName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {

        // Create path components to save the file
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        final String path = rootDir;
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);

       /* OutputStream out = null;*//*
        InputStream filecontent = null;*/
        final PrintWriter writer = response.getWriter();
        request.getSession().setMaxInactiveInterval(300);
        try(BufferedOutputStream out = new BufferedOutputStream( new FileOutputStream(new File(path + File.separator
                + fileName)));
            InputStream filecontent = filePart.getInputStream();
            )
        {
            /*out = new FileOutputStream(new File(path + File.separator
                    + fileName));*//*
            filecontent = filePart.getInputStream();*/

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                //LOGGER.log(Level.INFO,"{0}",read);
                out.write(bytes, 0, read);

            }


            writer.println("{success:true , file: '" + fileName + "' } ");
            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
                    new Object[]{fileName, path});
        } catch (FileNotFoundException fne) {
            writer.println("{success:false , msg: '" + fne.getMessage()+"'}");

            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                    new Object[]{fne.getMessage()});
        } finally {


            if (writer != null) {
                writer.close();
            }
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}

