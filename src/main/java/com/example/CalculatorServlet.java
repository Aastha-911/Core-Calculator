//package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String coreModel = request.getParameter("coreModel");

        try {
            CoreModelCalculator calculator = new CoreModelCalculator(coreModel);

            request.setAttribute("coreFactor", String.format("%.2f", calculator.getCoreFactor()));
            request.setAttribute("effectiveVolume", String.format("%.2f", calculator.getEffectiveVolume()));
            request.setAttribute("effectiveLength", String.format("%.2f", calculator.getEffectiveLength()));
            request.setAttribute("effectiveArea", String.format("%.2f", calculator.getEffectiveArea()));
            request.setAttribute("minimumArea", String.format("%.2f", calculator.getMinimumArea()));

            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Invalid core model format. Please use the format 'EExx/yy/zz'.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
