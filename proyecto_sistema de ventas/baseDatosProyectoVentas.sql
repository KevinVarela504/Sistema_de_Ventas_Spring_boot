CREATE DATABASE ventas;
USE ventas;
CREATE TABLE cliente(idCliente int primary key,nombre VARCHAR(50),correo VARCHAR(50),telefono int , limiteCredito DECIMAL(20.5));
USE ventas;
CREATE TABLE direccion(idDireccion int primary key,direccionFisica VARCHAR(50),direccionDespacho VARCHAR(50), idCliente int,
foreign key(idCliente)references cliente(idCliente));

USE ventas;
CREATE TABLE producto(idProducto int primary key,nombre VARCHAR(50),unidaMedida VARCHAR(50), precio DECIMAL(20.5),
descripcion VARCHAR(50),cantidadExistente DECIMAL(20.5));

USE ventas;
CREATE TABLE provedor(idProvedor int primary key,nombre VARCHAR(50),telefono int, direccion VARCHAR(50),
correo VARCHAR(50),rtn VARCHAR(50));

USE ventas;
CREATE TABLE distribucion(fecha date,idProvedor int,idProducto int,
primary key(fecha,idProducto,idProvedor), foreign key(idProducto)references producto(idProducto),
foreign key(idProvedor)references provedor(idProvedor));


USE ventas;
CREATE TABLE pedido(idPedido int primary key,fecha Date,direccionCliente VARCHAR(50), idCliente int,
foreign key(idCliente)references cliente(idCliente)
);

USE ventas;
CREATE TABLE lista(idLista int primary key,cantidad int,precioVenta DECIMAL(20.5),
idPedido int , idProducto int ,
foreign key(idPedido)references pedido(idPedido),
foreign key(idProducto)references producto(idProducto));

USE ventas;
CREATE TABLE empleado(idEmpleado int primary key,nombre VARCHAR(50),telefono VARCHAR(50),direccion VARCHAR(50));

USE ventas;
CREATE TABLE tarjeta(idTarjeta int primary key,numeroTarjeta int,tipo VARCHAR(50),clave VARCHAR(50),fechaExpiracion DATE);

USE ventas;
CREATE TABLE efectivo(idEfectivo int primary key,monto DECIMAL(20.5),vuelto DECIMAL(20.5));

USE ventas;
CREATE TABLE ordenentrega(idOrdenEntrega int primary key,fechaCreacion DATE, fechaEntrega DATE ,
idEmpleado int,idPedido int,
foreign key(idEmpleado)references empleado(idEmpleado),
foreign key(idPedido)references pedido(idPedido));
USE ventas;
CREATE TABLE administrador(idAdministrador int primary key, usuario VARCHAR(70),contrasenia VARCHAR(70),rol VARCHAR(70));