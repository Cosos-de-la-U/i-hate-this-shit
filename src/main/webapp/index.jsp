<%--
    Document   : index
    Created on : 20 abr. 2023, 04:19:56
    Author     : samll
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="controlador.ControllerPersistence"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Productos-Ordenes</title>
    <link rel="icon" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/512/685/685388.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.3/dist/flowbite.min.css" />
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js" integrity="sha512-ElRFoEQdI5Ht6kZvyzXhYG9NqjtkmlkfYk0wr6wHxU9JEHakS7UJZNeml5ALk+8IKlU6jDgMabC3vkumRokgJA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Karla&display=swap" rel="stylesheet">

    <!-- JavaScript -->
    <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
    <!-- CSS -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
    <!-- Default theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
    <!-- Semantic UI theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
    <!-- Bootstrap theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>

    <style>
        *{
            font-family: 'Karla', cursive;
        }
        .formGrid{
            display: grid;
            width: 200px;
        }
        .iBr{
            margin-bottom: 15px;
        }
    </style>

</head>
<body>
<div class="">
    <nav class="bg-white border-gray-200 px-2 sm:px-4 py-2.5 dark:bg-slate-700">
        <div class="mx-auto">
            <nav class="flex h-14 items-center">
                <ul class="flex flex-row text-2xl font-light container mx-auto">
                    <li class="px-3"><a class="p-3 <% if(request.getParameter("pag")!=null)if(request.getParameter("pag").equals("views/productos.jsp")) out.print("border-b-4 border-teal-50"); %>" href="ProductoS?accion=queryProduc"><i class="fa-solid fa-box"></i> Productos</a></li>
                    <li class="px-3"><a class="p-3 <% if(request.getParameter("pag")!=null) if(request.getParameter("pag").equals("views/ordenes.jsp")) out.print("border-b-4 border-teal-50"); %>" href="OrdenS?accion=queryOrd"><i class="fa-solid fa-list"></i> Ordenes</a></li>
                </ul>
            </nav>
        </div>
    </nav>
    <div class="container  mx-auto px-24">
        <div class="mt-10">
            <%
                String pag = request.getParameter("pag");
                if (pag != null) {
            %>
            <jsp:include page="<%=pag%>" />
            <%
            } else {
            %>
            <div class="flex justify-center items-center h-full">
                <h1 class="text-5xl text-slate-900">Gracias a samuel y la aerin por pasar el proyectoo</h1>
                <img src="https://elinformante.com.sv/wp-content/uploads/2022/11/FAS-CAMPEON-APERTURA-2022.jpg"/>
            </div>
            <%
                }

            %>
        </div>
    </div>
</div>
</body>
</html>

