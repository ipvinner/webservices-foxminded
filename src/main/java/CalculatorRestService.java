import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by ipvinner on 26.11.2016.
 */
@WebServlet("/CalculatorRestService")
public class CalculatorRestService extends HttpServlet {
        private static final long serialVersionUID = 1L;

        /**
         * @see HttpServlet#HttpServlet()
         */
        public CalculatorRestService() {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                Integer number1 = Integer.valueOf(request.getParameter("number1"));
                Integer number2 = Integer.valueOf(request.getParameter("number2"));
                Integer sum = number1 + number2;
                String result = "{result: " + sum + "}";
                response.setContentType("application/json");
                response.getWriter().append(result);
            } catch (Exception e) {
                String error = "{error: " + e + "}";
                response.setContentType("application/json");
                response.getWriter().append(error);
            }
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                Integer number1 = Integer.valueOf(request.getParameter("number1"));
                Integer number2 = Integer.valueOf(request.getParameter("number2"));
                Integer compusition = number1 * number2;
                String result = "{result: " + compusition + "}";
                response.setContentType("application/json");
                response.getWriter().append(result);
            } catch (Exception e) {
                String error = "{error: " + e + "}";
                response.setContentType("application/json");
                response.getWriter().append(error);
            }
        }

        /**
         * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
         */
        protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
        }

    }

