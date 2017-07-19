import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class WatchesServlet extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        HttpSession session=req.getSession(false);
        if(session!=null)
        {
            String[] watches=req.getParameterValues("watches");
            session.setAttribute("watches",watches);
            RequestDispatcher rd=req.getRequestDispatcher("/welcome.html");
                    rd.forward(req,res);
        }
        else
        {
            RequestDispatcher rd=req.getRequestDispatcher("/index.html");
            rd.forward(req,res);
        }
    }
}