package edu.unah.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="lista")
public class Lista {
	
	@Id
	private int idLista;
	private int cantidad;
	private float precioVenta;
	private int idPedido;
	private int idProducto;
	
	@ManyToOne
	@JoinColumn(name="idPedido", referencedColumnName="idPedido", insertable = false, updatable = false)
	@JsonBackReference
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="idProducto", referencedColumnName="idProducto", insertable = false, updatable = false)
	@JsonBackReference
	private Producto producto;

	public Lista() {}
	
	public Lista(int idLista, int cantidad, float precioVenta, int idPedido, int idProducto, Pedido pedido,
			Producto producto) {
		super();
		this.idLista = idLista;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
		this.idPedido = idPedido;
		this.idProducto = idProducto;
		this.pedido = pedido;
		this.producto = producto;
	}

	public int getIdLista() {
		return idLista;
	}

	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}	
	
	
	
	
	

}
