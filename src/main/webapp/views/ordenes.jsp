<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <h1 class="text-2xl mb-5">Ordens</h1>
        <form action="OrdenS" method="post">
            <div class="flex gap-3">
                <div class="flex flex-col">
                    <label>Producto </label>
                    <select name="idProd" class="h-11 w-72 pl-2" required>
                        <option value="">[ -- Selecciona un Producto -- ]</option>
                        <c:forEach items="${listProduc}" var="producto">
                            <option value="${producto.id_producto}">${producto.nombre} - $${producto.precio_unitario}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="flex flex-col">
                    <label>Cantidad </label>
                    <input type="number" name="cant" min="1" max="99" placeholder="Cantidad" class="iBr w-28"
                        required />
                </div>
                <div class="flex flex-col">
                    <label style="margin-left: 5px">Fecha Entrega </label>
                    <input type="date" name="fchU" required />
                </div>
                <div class="flex flex-col">
                    <label>Direccion de entrega </label>
                    <input type="text" name="dir" placeholder="Direccion" class="iBr w-28"
                           required />
                </div>

            </div>
            <input style="margin-top: 20px" type="submit" name="btnAdd" value="Agregar"
                class="bg-green-500 px-4 py-2 rounded-md cursor-pointer">
        </form>


        <table class="table-auto mt-8 w-fit border-collapse border border-slate-600 text-left">
            <thead class="bg-slate-600 text-gray-50 uppercase text-lg">
                <tr>
                    <th class="px-6 py-3">Producto</th>
                    <th class="px-6 py-3">Cantidad</th>
                    <th class="px-6 py-3">Fecha Orden</th>
                    <th class="px-6 py-3">Direccion Entrega</th>
                    <th></th>
                </tr>
            </thead>
            <tbody class="capitalize">
                <c:forEach items="${listOrd}" var="orden">
                    <fmt:formatDate var="fchFormat" value="${orden.fecha_orden}" pattern="yyyy-MM-dd" />
                    <c:set var="i" value="${i+1}" />
                    <tr class="hover:bg-slate-100 border <c:if test=" ${i%2==0}">bg-slate-200</c:if>">
                        <td class="px-6 py-3">${orden.producto.nombre}</td>
                        <td class="px-6 py-3">${orden.cantidad}</td>
                        <td class="px-6 py-3">${orden.fecha_orden}</td>
                        <td class="px-6 py-3">${orden.direccion_entrega}</td>
                        <td class="flex">
                            <a href="OrdenS?id=${orden.id_orden}&accion=updateOrd" class="p-3">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                                stroke="currentColor" class="w-6 h-6 text-sky-400">
                                <path stroke-linecap="round" stroke-linejoin="round"
                                    d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L10.582 16.07a4.5 4.5 0 01-1.897 1.13L6 18l.8-2.685a4.5 4.5 0 011.13-1.897l8.932-8.931zm0 0L19.5 7.125M18 14v4.75A2.25 2.25 0 0115.75 21H5.25A2.25 2.25 0 013 18.75V8.25A2.25 2.25 0 015.25 6H10" />
                            </svg>
                            </a>
                            <a href="OrdenS?id=${orden.id_orden}&accion=deleteOrd" class="p-3">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                                stroke="currentColor" class="w-6 h-6 text-red-400">
                                <path stroke-linecap="round" stroke-linejoin="round"
                                    d="M14.74 9l-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 01-2.244 2.077H8.084a2.25 2.25 0 01-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 00-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 013.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 00-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 00-7.5 0" />
                            </svg>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>