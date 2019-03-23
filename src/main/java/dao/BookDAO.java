package dao;

import annotations.MyBatisRepository;
import entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 映射器
 */
@Repository("bookDAO")
@MyBatisRepository
public interface BookDAO {

    public void save(Book book);

    public void deleteById(Integer id);

    public void modify(Book book);

    public List<Book> findAll();

    public Book findById(Integer id);

}
