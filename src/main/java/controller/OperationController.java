package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.BookDAO;
import entity.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("Operation")
public class OperationController {

    @RequestMapping(value = "/findAll.do", method = RequestMethod.GET)
    public void findAllBooks(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取所有图书信息
        String config = "application-config.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        BookDAO dao = ac.getBean("bookDAO", BookDAO.class);
        List<Book> books = dao.findAll();

        //使用JSON将获取的图书信息返回给浏览器
        ObjectMapper om = new ObjectMapper();
        String jsonStr = om.writeValueAsString(books);
        PrintWriter out = response.getWriter();
        out.println(jsonStr);
    }

}
