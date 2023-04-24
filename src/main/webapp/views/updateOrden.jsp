<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <fmt:formatDate var="fchFormat" value="${ord.getFecha_orden()}" pattern="yyyy-MM-dd" />
        <h1 class="text-2xl mb-5">Actualizar Inventario</h1>
        <form action="OrdenS" method="post">
            <div class="flex gap-3">
                <input type="hidden" name="id" value="${ord.getId_orden()}" />
                <div class="flex flex-col">
                    <label>Producto </label>
                    <select name="idProd" class="h-11 w-72 pl-2" required>
                        <option value="">[ -- Selecciona un Producto -- ]</option>
                        <c:forEach items="${listProduc}" var="ordPro">
                            <option <c:if test="${ord.producto.id_producto==ordPro.id_producto}">selected</c:if> value="${ordPro.id_producto}">${ordPro.nombre} - $${ordPro.precio_unitario}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="flex flex-col">
                    <label>Cantidad </label>
                    <input type="number" name="cant" min="1" max="99" placeholder="Cantidad" class="iBr w-28" value="${ord.getCantidad()}" required />
                </div>
                <div class="flex flex-col">
                    <label style="margin-left: 5px">Fecha Entrega </label>
                    <input type="date" name="fchU" value="${ord.getFecha_orden()}" required />
                </div>
                <div class="flex flex-col">
                    <label>Direccion de entrega </label>
                    <input type="text" name="dir" value="${ord.getDireccion_entrega()}" placeholder="Direccion" class="iBr w-28"
                           required />
                </div>
            </div>
            <input style="margin-top: 20px" type="submit" name="btnUpdate" value="Actualizar"
                class="bg-black-500 px-4 py-2 rounded-md cursor-pointer">
        </form>