import DAO.PersonDAO;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.Serializable;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "test", urlPatterns = {"/dir"})
public class test extends HttpServlet  {


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PersonDAO person = new PersonDAO();

        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(person.getAll().toString());
    }



}
