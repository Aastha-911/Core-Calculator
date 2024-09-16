<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Core Model Calculator</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 20px; }
        h1 { color: #333; }
        form { margin-bottom: 20px; }
        label { display: block; margin-bottom: 5px; }
        input[type="text"] { width: 200px; padding: 5px; }
        input[type="submit"] { padding: 5px 10px; background-color: #4CAF50; color: white; border: none; cursor: pointer; }
        table { border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1>Core Model Calculator</h1>
    
    <form action="calculate" method="post">
        <label for="coreModel">Core Model (e.g., EE25/13/7):</label>
        <input type="text" id="coreModel" name="coreModel" required>
        <input type="submit" value="Calculate">
    </form>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <% if (request.getAttribute("coreFactor") != null) { %>
        <h2>Results:</h2>
        <table>
            <tr>
                <th>Parameter</th>
                <th>Value</th>
            </tr>
            <tr>
                <td>Core Factor</td>
                <td><%= request.getAttribute("coreFactor") %></td>
            </tr>
            <tr>
                <td>Effective Volume (Ve)</td>
                <td><%= request.getAttribute("effectiveVolume") %> mm³</td>
            </tr>
            <tr>
                <td>Effective Length (le)</td>
                <td><%= request.getAttribute("effectiveLength") %> mm</td>
            </tr>
            <tr>
                <td>Effective Area (Ae)</td>
                <td><%= request.getAttribute("effectiveArea") %> mm²</td>
            </tr>
            <tr>
                <td>Minimum Area (An)</td>
                <td><%= request.getAttribute("minimumArea") %> mm²</td>
            </tr>
        </table>
    <% } %>
</body>
</html>
