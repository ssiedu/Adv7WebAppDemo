
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaxCalculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //read the data coming from client
        
            String s1=req.getParameter("t1");
            String s2=req.getParameter("t2");
            String s[]=req.getParameterValues("assets");
            String s3=req.getParameter("c1");
            int nriChrg=0;
            if(s3!=null){
                nriChrg=5000;
            }
            int surcharge=0;
            if(s!=null){
            surcharge=s.length*500;
            }
        
        //process the data
        
            int income=Integer.parseInt(s1);
            int age=Integer.parseInt(s2);
            int tax=0, rebate=0, net=0;
            
            if(income>=500000){
                tax=income*20/100;
            }else{
                tax=income*10/100;
            }
            
            if(age>=60){
                rebate=tax*10/100;
            }
            net=tax-rebate;
        //provide the response
        PrintWriter out=resp.getWriter();
        
        out.println("<html>");
        out.println("<body>");
        out.println("<h3>Thanks For Visiting Us.</h3>");
        out.println("<table border=2>");
        out.println("<tr>");
        out.println("<td>Income</td>");
        out.println("<td>"+income+"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Age</td>");
        out.println("<td>"+age+"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Tax</td>");
        out.println("<td>"+tax+"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Rebate</td>");
        out.println("<td>"+rebate+"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Net</td>");
        out.println("<td>"+net+"</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}