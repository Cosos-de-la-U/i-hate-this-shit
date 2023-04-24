```postgresql

CREATE TABLE producto (
    id_producto SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio_unitario NUMERIC(10,2) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

CREATE TABLE orden (
    id_orden SERIAL PRIMARY KEY,
    producto_id_producto INTEGER NOT NULL REFERENCES producto(id_producto),
    cantidad INTEGER NOT NULL,
    fecha_orden DATE NOT NULL,
    direccion_entrega VARCHAR(255) NOT NULL
);

INSERT INTO orden (producto_id_producto, cantidad, fecha_orden, direccion_entrega)
VALUES (1, 5, '2023-04-24', '123 Main St, Anytown USA');

INSERT INTO orden (id_producto, cantidad, fecha_orden, direccion_entrega, producto_id)
VALUES (1, 10, '2023-04-24', '123 Main St, Anytown USA', 1);

-- Insert product 1
INSERT INTO producto ( nombre, descripcion, precio_unitario, categoria)
VALUES ( 'Producto 1', 'Descripción del producto 1', 10.99, 'Categoría 1');

-- Insert product 2
INSERT INTO producto ( nombre, descripcion, precio_unitario, categoria)
VALUES ( 'Producto 2', 'Descripción del producto 2', 19.99, 'Categoría 1');

-- Insert product 3
INSERT INTO producto ( nombre, descripcion, precio_unitario, categoria)
VALUES ( 'Producto 3', 'Descripción del producto 3', 5.99, 'Categoría 2');

-- Insert product 4
INSERT INTO producto ( nombre, descripcion, precio_unitario, categoria)
VALUES ( 'Producto 4', 'Descripción del producto 4', 39.99, 'Categoría 2');

-- Insert product 5
INSERT INTO producto ( nombre, descripcion, precio_unitario, categoria)
VALUES ( 'Producto 5', 'Descripción del producto 5', 15.99, 'Categoría 3');

```