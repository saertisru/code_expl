import DAO.PersonDAO;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;



@WebServlet(name = "test", urlPatterns = {"/dir"})
public class test extends HttpServlet  {
    private PersonDAO  personDAO;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        personDAO = new PersonDAO();

        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(personDAO.getAll().toString());
    }



}
