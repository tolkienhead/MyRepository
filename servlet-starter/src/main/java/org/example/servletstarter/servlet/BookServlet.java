package org.example.servletstarter.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletstarter.service.BookService;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    BookService bookService = BookService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        Integer author_id =  Integer.valueOf(req.getParameter("author_id"));


        try(PrintWriter printWriter = resp.getWriter()){
            printWriter.write("<ul>");
            bookService.findAllByAuthorId(author_id).forEach(bookDto -> printWriter.write(
                    """  
                            <li>
                                %s %s
                            </li>
                            """.formatted(bookDto.getId(), bookDto.getDescription())
            ));
            printWriter.write("</ul>");
        }
    }
}
