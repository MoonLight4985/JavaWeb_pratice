package org.example.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/code")
public class CodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        int width = 80;
        int height = 40;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);
        graphics.setFont(new Font("微软雅黑", Font.BOLD, 25));
        Random random = new Random();
        for (int i = 1; i < 5; i++) {
            String code = random.nextInt(10) + "";
            graphics.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            graphics.drawString(code, 13 * i, random.nextInt(10) + 20);
        }
        for (int i = 0; i < 15; i++) {
            graphics.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            graphics.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }
        graphics.dispose();
        ServletOutputStream outputStream = resp.getOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
