package org.sang.servlet;

import org.sang.bean.Employee;
import org.sang.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sang on 2017/8/18.
 */
public class ApproveaccountServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * @param req  请求数据
     * @param resp 相应数据
     * @throws ServletException 抛出异常
     * @throws IOException      抛出异常
     *                          <p>
     *                          使用service层中的getUnApproveaccount();进行人数的统计
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> list = employeeService.getUnApproveaccount();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/approveaccount.jsp").forward(req, resp);
    }
}
