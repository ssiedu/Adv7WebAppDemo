
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaxCalculator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //read the data coming from client
        
            String s1=req.getParameter("t1");
            String s2=req.getParameter("t2");
        
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
        out.println("Thanks For Visiting Us.");
        out.println("Your Tax : "+tax);
        out.println("Your Rebate : "+rebate);
        out.println("Your Net Tax : "+net);
        out.println("Pay Your Taxes Before 31st March.");
        out.close();
    }
}