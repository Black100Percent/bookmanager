package test;

import dao.BookDAO;
import entity.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.List;

public class InsertBooks {

    @Test
    public void testDate() {
        Long now = System.currentTimeMillis();
        Date date = new Date(now);
        System.out.println(date);
    }

    @Test
    public void insertion() {
        String config = "mybatis-config.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        BookDAO dao = ac.getBean("bookDAO", BookDAO.class);
        Book book = new Book();
        book.setName("C++编程思想");
        book.setAuthor("[美]Bruce Eckel/[美]Chuck Allison");
        book.setPress("机械工业出版社");
        book.setPrice(116.00);
        book.setCategory("IT&通信");
        book.setDate(new Date(System.currentTimeMillis()));
        book.setAmount(1);
        book.setApproach("部门购买");
        dao.save(book);
        System.out.println("成功插入一条数据！");
    }

    @Test
    public void findAllBooks() {
        String config = "mybatis-config.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        BookDAO dao = ac.getBean("bookDAO", BookDAO.class);
        List<Book> books = dao.findAll();
        System.out.println(books);
    }

    @Test
    public void findOneBook() {
        String config = "mybatis-config.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        BookDAO dao = ac.getBean("bookDAO", BookDAO.class);
        Book book = dao.findById(1);
        System.out.println(book);
    }

}
