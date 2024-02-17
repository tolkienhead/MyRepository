package org.example.servletstarter.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletstarter.service.AuthorService;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/author")
public class AuthorServlet extends HttpServlet {
    private final AuthorService authorService = AuthorService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (var printWriter = resp.getWriter()) {
            printWriter.write("<ul>");
            authorService.findAll().forEach(authorDto -> {
                printWriter.write(
                        """
                                <li>
                                    %s %s
                                </li>
                                """.formatted(authorDto.getId(), authorDto.getDescription())
                );
            });
            printWriter.write("</ul>");
        }
    }
}
