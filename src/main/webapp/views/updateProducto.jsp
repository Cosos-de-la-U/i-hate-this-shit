<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <h1 class="text-2xl mb-5">Actualizar Producto</h1>
    <form action="ProductoS" method="post">
        <div class="flex gap-3">
            <input type="hidden" name="id" value="${product.getId_producto()}" />
            <div class="flex flex-col">
                <label>Nombre </label>
                <input type="text" id="nom" name="nom" placeholder="Nombre" class="iBr" value="${product.getNombre()}"
                    required />
            </div>
            <div class="flex flex-col">
                <label>Descripcion </label>
                <input type="text" id="descri" name="descri" placeholder="Descripcion" class="iBr" value="${product.getDescripcion()}"
                       required />
            </div>
            <div class="flex flex-col">
                <label>Precio Unitario </label>
                <input type="number" name="prec" step="any" min="0" max="999" placeholder="0" class="iBr"
                    value="${product.getPrecio_unitario()}" required />
            </div>
            <div class="flex flex-col">
                <label>Categoria </label>
                <input type="text" id="cat" name="cat" placeholder="Categoria" class="iBr" value="${product.getCategoria()}"
                       required />
            </div>
        </div>
        <input style="margin-top: 20px" type="submit" name="btnUpdate" value="Actualizar"
            class="bg-black-500 px-4 py-2 rounded-md cursor-pointer">
    </form>