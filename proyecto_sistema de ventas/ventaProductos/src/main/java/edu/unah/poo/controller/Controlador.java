package edu.unah.poo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.unah.poo.model.Administrador;
import edu.unah.poo.model.Cliente;
import edu.unah.poo.model.Direccion;
import edu.unah.poo.model.Distribucion;
import edu.unah.poo.model.Empleado;
import edu.unah.poo.model.IdDistribucion;

import edu.unah.poo.model.Lista;
import edu.unah.poo.model.OrdenEntrega;
import edu.unah.poo.model.Pedido;

import edu.unah.poo.model.Producto;
import edu.unah.poo.model.Provedor;
import edu.unah.poo.service.ServiceAdministrador;
import edu.unah.poo.service.ServiceCliente;
import edu.unah.poo.service.ServiceDireccion;
import edu.unah.poo.service.ServiceDistribucion;
import edu.unah.poo.service.ServiceEmpleado;
import edu.unah.poo.service.ServiceLista;
import edu.unah.poo.service.ServiceOrdenEntrega;
import edu.unah.poo.service.ServicePedido;
import edu.unah.poo.service.ServiceProducto;
import edu.unah.poo.service.ServiceProvedor;

@Controller
public class Controlador {

	@Autowired
	ServiceCliente serviceCliente;
	
	@Autowired
	ServiceDireccion serviceDireccion;
	
	@Autowired
	ServiceDistribucion serviceDistribucion;
	
	@Autowired
	ServiceProducto serviceProducto;
	
	@Autowired
	ServiceProvedor serviceProvedor;
	
	@Autowired
	ServicePedido servicePedido;
	
	@Autowired
	ServiceLista serviceLista;
	
	@Autowired
	ServiceEmpleado serviceEmpleado;
	
	@Autowired
	ServiceOrdenEntrega serviceOrdenEntrega;
	
	@Autowired
	ServiceAdministrador serviceAdministrador;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/pagina/principal")
	public String principalAdministracion() {
		return "paginaprincipal"; //retornar la pagina
	}
	
	
	
	@GetMapping("/cliente/agregar")
	public String registrarCliente() {
		return "agregarCliente"; //retornar la pagina
	}
	
	@GetMapping("/producto/agregar")
	public String registrarProducto() {
		return "agregarProducto"; //retornar la pagina
	}
	

	@GetMapping("/producto/agregarMas")
	public String agregarMasProducto() {
		return "agregarCantidadProducto"; //retornar la pagina
	}
	
	@GetMapping("/administrador/agregar")
	public String agregarAdministrador() {
		return "agregarAdministrador"; //retornar la pagina
	}
	
	
	@GetMapping("/empleado/agregar")
	public String registrarEmpleado() {
		return "agrearEmpleado"; //retornar la pagina
	}
	
	@GetMapping("/provedor/agregar")
	public String registrarProvedor() {
		return "agregarProvedor"; //retornar la pagina
	}
	
	@GetMapping("/distribucion/agregar")
	public String crearDistribucion() {
		return "crearDistribucion"; //retornar la pagina
	}
	//=====================================================================
	
	@GetMapping("/pagina/principalClientes")
	public String principalClientes() {
		return "paginaPrincipalClientes"; //retornar la pagina
	}
	
	@GetMapping("/direccion/agregar")
	public String crearDireccion() {
		return "agregarDireccion"; //retornar la pagina
	}
	
	
	@GetMapping("/pedido/crear")
	public String crearPedido() {
		return "crearPedido"; //retornar la pagina
	}
	
	@GetMapping("/producto/agregarLista")
	public String agregarLista() {
		return "agregarProductoLista"; //retornar la pagina
	}
	
	@GetMapping("/pedido/eliminar")
	public String confirmacionPedido() {
		return "confirmacionDePedido"; //retornar la pagina
	}
	
	@GetMapping("/pedido/guardar")
	public String guardarPedido() {
		return "guardarPedido"; //retornar la pagina
	}
	
	
	@GetMapping("/cliente/eliminar")
	public String eliminarCliente() {
		return "eliminarCliente"; //retornar la pagina
	}
	
	@GetMapping("/cliente/modificar")
	public String eliminarModificar() {
		return "modificarCliente"; //retornar la pagina
	}
	
	
	@GetMapping("/ordenentrega/crear")
	public String crearOrdenEntrega() {
		return "crearOrdenEntrega"; //retornar la pagina
	}
	
	//principal/GeneralB
	@GetMapping("/principal/GeneralB")
	public String PaginaAdmin() {
		return "paginaGeneralB"; //retornar la pagina
	}
	
	@GetMapping("/")
	public String PaginaLogin() {
		return "entradaLogin"; //retornar la pagina
	}
	
	
	//=======================================================================================
		 //                                      SEGURIDAD
		 //======================================================================================
	 @RequestMapping (value = "/encriptar",method=RequestMethod.GET)
	public String encriptarContrasenia() {
		 List<Administrador> lista = this.serviceAdministrador.obtenerAdministradores();
		 String contrasenia;
		 
		 for(Administrador e:lista) {
			 
			 contrasenia=passwordEncoder.encode("123");
			 System.out.println("123"+" pasa a"+ contrasenia );
			 e.setContrasenia(contrasenia);
			 this.serviceAdministrador.crearAdministrador(e);
		 }
		 return "encriptar";
	 }
	
	
	//=======================================================================================
	 //                                        CLIENTE
	 //======================================================================================
	
			 
			 @RequestMapping (value = "/cliente/crearCliente",method=RequestMethod.POST)
		public String crearCliente(@RequestParam(name = "id") int idCliente,
				                    @RequestParam(name = "nombre") String nombre,
				                    @RequestParam(name = "correo") String correo,
				                    @RequestParam(name = "telefono") int telefono
				                  ) {
			 
			Cliente tmpCliente = new Cliente(idCliente,nombre,correo,telefono,5000);
			this.serviceCliente.crearCliente(tmpCliente);
			return "agregarCliente";
		}
		
		@RequestMapping(value = "/cliente/listarCliente",method=RequestMethod.GET)
		public List<Cliente> listarClientes(){
			return this.serviceCliente.obtenerCliente();
		}
		
		
		 
		 
		 @RequestMapping(value ="/cliente/eliminarCliente",method=RequestMethod.POST)
			public String eliminarCliente(@RequestParam(name = "id") int idCliente	) {
				
			List<Pedido> tmpListaPedidos=this.listadoPedidos();
			List<Direccion> tmpDirecciones=this.serviceDireccion.obtenerDireccion();
			
			for(int j=0;j<tmpDirecciones.size();j++) {
				
				if(tmpDirecciones.get(j).getCliente().getIdCliente()==idCliente) {
					
					this.eliminarDireccion(tmpDirecciones.get(j).getIdDireccion());
				}
				
			}
			
		
				for(int i=0; i<tmpListaPedidos.size();i++) {
				if(tmpListaPedidos.get(i).getCliente().getIdCliente()==idCliente) {
					
				this.eliminarPedidoCliente(tmpListaPedidos.get(i).getIdPedido());
				}
				}
			
			Cliente cliente=this.serviceCliente.buscarCliente(idCliente);
			this.serviceCliente.eliminarCliente(cliente);
				
				return "paginaGeneralB";
				//return "paginaprincipal";
				
		 }
		 
		 
		 @RequestMapping(value ="/cliente/mostrarClientes",method=RequestMethod.GET)
			public String listadoClientes(Model model) {
				List<Cliente> cliente = this.serviceCliente.obtenerCliente();
				model.addAttribute("cliente", cliente);
				
				return "mostrarClientes";
			}
		 
		 
		 
		 @RequestMapping (value ="/cliente/modificarCliente",method=RequestMethod.POST)
			public String modificarCliente(@RequestParam(name = "id") int idCliente,
					                    @RequestParam(name = "nombre") String nombre,
					                    @RequestParam(name = "correo") String correo,
					                    @RequestParam(name = "telefono") int telefono,
					                    @RequestParam(name = "limiteCredito") float limiteCredito   ) {
				 
				Cliente tmpCliente = new Cliente(idCliente,nombre,correo,telefono,limiteCredito);
				this.serviceCliente.crearCliente(tmpCliente);
				return "paginaGeneralB";
				//return "paginaPrincipal";
			}
		
		//=======================================================================================
		 //                                        DIRECCION
		 //======================================================================================
		
		 @RequestMapping (value = "/direccion/crearDireccion",method=RequestMethod.POST)
		 public String crearDireccion(@RequestParam(name = "id") int idDireccion,
                 @RequestParam(name = "direccionfisica") String direccionfisica,
                 @RequestParam(name = "direcciondespacho") String direcciondespacho,
                 @RequestParam(name = "idCliente") int idCliente) {
			 

Cliente tmpCliente= this.serviceCliente.buscarCliente(idCliente);
Direccion direccion= new Direccion(idDireccion,direccionfisica,direcciondespacho,tmpCliente);
this.serviceDireccion.crearDireccion(direccion);
return "agregarDireccion";
}
		 
		 
		 @RequestMapping(value ="/direccion/eliminarDireccion",method=RequestMethod.GET)
			public void eliminarDireccion(@RequestParam(name = "idDireccion") int idDireccion	) {
				
		Direccion tmpDireccion=this.serviceDireccion.buscarDireccion(idDireccion);
		this.serviceDireccion.eliminarDireccion(tmpDireccion);
		return;
				
		 }
		
		//=======================================================================================
		 //                                        PRODUCTO
		 //======================================================================================
		 
		 @RequestMapping (value = "/producto/crearProducto",method=RequestMethod.POST)
		 public String crearProducto(@RequestParam(name = "id") int idProducto,
                 @RequestParam(name = "nombre") String nombre,
                 @RequestParam(name = "unidaMedida") String unidadMedida,
                 @RequestParam(name = "precio") float precio,
                 @RequestParam(name = "descripcion") String descripcion,
                 @RequestParam(name = "cantidadExistente") float cantidadExistente) {
			 


Producto producto= new Producto(idProducto,nombre,unidadMedida,precio,descripcion,cantidadExistente);
this.serviceProducto.crearProducto(producto);
return "paginaGeneralB";
// pagina nueva return "paginaPrincipal";
}
		 
		 
		 @RequestMapping (value = "/producto/actualizarCantidadExistente",method=RequestMethod.GET)
		  public void actualizarCantidad(@RequestParam(name = "cantidad") float cantidad,
                 @RequestParam(name = "idProducto") int idProducto) {
			 
                Producto p= this.serviceProducto.buscarProducto(idProducto);
                float t=p.getCantidadExistente()-cantidad;

               this.serviceProducto.actualizarCantidadExistente(t, idProducto);
}
	
		 
			@RequestMapping(value ="/producto/listaProductos",method=RequestMethod.GET)
			public String listadoProductos(Model model) {
				List<Producto> producto = this.serviceProducto.obtenerProducto();
				model.addAttribute("producto", producto);
				
				return "mostrarProductos";
			}
		 
			@RequestMapping(value ="/producto/listaProductosClientes",method=RequestMethod.GET)
			public String listadoProductosClientes(Model model) {
				List<Producto> producto = this.serviceProducto.obtenerProducto();
				model.addAttribute("producto", producto);
				
				return "mostrarProductosCliente";
			}
			//=======================================================================================
		 //                                        PROVEDOR
		 //======================================================================================
		 
		 
		 @RequestMapping (value = "/provedor/crearProvedor",method=RequestMethod.POST)
		 public String crearProvedor(@RequestParam(name = "id") int idProvedor,
                 @RequestParam(name = "nombre") String nombre,
                 @RequestParam(name = "telefono") int telefono,
                 @RequestParam(name = "direccion") String direccion,
                 @RequestParam(name = "correo") String correo,
                 @RequestParam(name = "rtn") String rtn) {
			 


Provedor provedor= new Provedor(idProvedor,nombre,telefono,direccion,correo,rtn);
this.serviceProvedor.crearProvedor(provedor);;
return"paginaGeneralB";
// pagina nueva admin return "paginaPrincipal";
}
		 
	
		 
		 
			//=======================================================================================
		 //                                        Distribucion
		 //======================================================================================
		 
		 
		 @RequestMapping (value = "/distribucion/crearDistribucion",method=RequestMethod.POST)
			public String crearDistribucion( @RequestParam(name = "fecha") @DateTimeFormat(iso = ISO.DATE)  LocalDate fecha,
					                          @RequestParam(name = "idProvedor") int idProvedor,
					                      @RequestParam(name = "idProducto") int idProducto
					                     
					                     ) {
				
				
				Provedor provedor = this.serviceProvedor.buscarProvedor(idProvedor);
				Producto producto = this.serviceProducto.buscarProducto(idProducto);
				
				
				Distribucion tmpDistribucion = new Distribucion(fecha,idProvedor,idProducto,provedor,producto);
				
				
				
				this.serviceDistribucion.crearDistribucion(tmpDistribucion);
				
				return "paginaGeneralB";
				// nuevo admin return "paginaPrincipal";
			}
		 
		 
		 @RequestMapping(value = "/distribucion/buscarDistribucion",method=RequestMethod.GET)
			public Distribucion buscarDistribucion( @RequestParam(name = "fecha") @DateTimeFormat(iso = ISO.DATE)  LocalDate fecha,
                    @RequestParam(name = "idProvedor") int idProvedor,
                @RequestParam(name = "idProducto") int idProducto
               
               ) {
				IdDistribucion idDistribucion = new IdDistribucion(fecha, idProvedor, idProducto);
				return this.serviceDistribucion.buscarDistribucion(idDistribucion);
			}
			
			@RequestMapping(value = "/distribucion/listarDistribucion",method=RequestMethod.GET)
			public List<Distribucion> listarRevision(){
				return this.serviceDistribucion.obtenerDistribucion();
			}
			
			
			//========================================================================
			//                              PEDIDO
			//==========================================================================
			
			@RequestMapping(value = "/pedido/crearPedido",method=RequestMethod.POST)
			 public String crearPedido(@RequestParam(name = "id") int idPedido,
					 @RequestParam(name = "fecha") @DateTimeFormat(iso = ISO.DATE)  LocalDate fecha,
	                 @RequestParam(name = "idCliente") int  idCliente ) {
				 
         List<Direccion> d=this.serviceDireccion.obtenerDireccion();
           String direccion="";
         for(int i=0;i<d.size();i++) {
	
	    if(d.get(i).getCliente().getIdCliente()==idCliente) {
		
		direccion=d.get(i).getDireccionDespacho();
		break;
	        }
	
    }
	Cliente c=this.serviceCliente.buscarCliente(idCliente);
Pedido pedido=new Pedido(idPedido,fecha,direccion,c);
this.servicePedido.crearPedido(pedido);
return "crearPedido";
	}
			
			
			//===========================================================
			 @RequestMapping(value ="/pedido/eliminarPedido",method=RequestMethod.POST)
				public String eliminarPedido(@RequestParam(name = "id") int idPedido	) {
					
				List<OrdenEntrega> tmpOrdenEntrega =this.serviceOrdenEntrega.obtenerOrdenesEntrega();
				List<Lista> tmpLista=this.serviceLista.obtenerListasProductos();
				
				for(int i=0;i<tmpOrdenEntrega.size();i++) {
					
					if(tmpOrdenEntrega.get(i).getIdPedido()==idPedido) {
						
						this.eliminarOrdenEntrega(tmpOrdenEntrega.get(i).getIdOrdenEntrega());
					}
					
				}
				
				
                  for(int j=0;j<tmpLista.size();j++) {
					
					if(tmpLista.get(j).getIdPedido()==idPedido) {
						
						this.eliminarProductoLista(tmpLista.get(j).getIdLista());
					}
					
				}
                  
                  Pedido tmpPedido=this.servicePedido.buscarPedido(idPedido);
                  
                  this.servicePedido.eliminarPedido(tmpPedido);
					
					
					return "paginaPrincipalClientes";
					
			 }
			 
			 
			  @RequestMapping(value ="/pedido/el",method=RequestMethod.GET)
				public void eliminarPedidoCliente(@RequestParam(name = "id") int idPedido	) {
					
					List<OrdenEntrega> tmpOrdenEntrega =this.serviceOrdenEntrega.obtenerOrdenesEntrega();
					List<Lista> tmpLista=this.serviceLista.obtenerListasProductos();
					
					for(int i=0;i<tmpOrdenEntrega.size();i++) {
						
						if(tmpOrdenEntrega.get(i).getIdPedido()==idPedido) {
							
							this.eliminarOrdenEntrega(tmpOrdenEntrega.get(i).getIdOrdenEntrega());
						}
						
					}
					
					
	                  for(int j=0;j<tmpLista.size();j++) {
						
						if(tmpLista.get(j).getIdPedido()==idPedido) {
							
							this.eliminarProductoLista(tmpLista.get(j).getIdLista());
						}
						
					}
	                  
	                  Pedido tmpPedido=this.servicePedido.buscarPedido(idPedido);
	                  
	                  this.servicePedido.eliminarPedido(tmpPedido);
						
						
						return;
						
				 }
			  
			  
			  public List<Pedido> listadoPedidos() {
					return this.servicePedido.obtenerListasPedidos();
				}
			
			
			
			
//============================================================================================
//               LISTA(GUARDA PRODUCTOS PEDIDOS)
//===========================================================================================
			
			@RequestMapping(value = "/lista/guardarListaProducto",method=RequestMethod.POST)
			 public String guardarListaProducto(@RequestParam(name = "id") int idLista,
	                 @RequestParam(name = "cantidad") int cantidad,
	                  @RequestParam(name = "idPedido") int idPedido,
	                 @RequestParam(name = "idProducto") int idProducto) {
				 
				
				
				
				Pedido pedido=this.servicePedido.buscarPedido(idPedido);
				
              	Producto producto=this.serviceProducto.buscarProducto(idProducto);
              	
              	if(this.validarPedidoProducto((float)cantidad, idProducto)==true) {
              		
              		if(pedido.getCliente().getLimiteCredito()>this.preciosAcumulado(idPedido)) {
              		    
              			Lista lista=new Lista(idLista,cantidad,producto.getPrecio(),idPedido,idProducto,pedido,producto);
              		    this.serviceLista.guardarListaProductos(lista);
              		  return "agregarProductoLista";
              			
              		}
              	}
              	
   return "agregarProductoLista";
           
              	
	}
			
			
			
			@RequestMapping(value ="/lista/obtenerListas",method=RequestMethod.GET)
			public List<Lista> listadoProductosPedidos() {
				return this.serviceLista.obtenerListasProductos();
			}
			
			
			
			public boolean validarPedidoProducto(float cantidadpedida,int idProducto) {
				
				Producto p=this.serviceProducto.buscarProducto(idProducto);
				
				if(cantidadpedida>=p.getCantidadExistente()) {
					return false;
				}
				
				return true;
				
			}
			
			public float  preciosAcumulado(int idPedido) {
				
				List<Lista> listas=this.serviceLista.obtenerListasProductos();
				
				List<Lista>  listasCliente =new ArrayList<Lista>();
				float acumulador=0;
				
				for(int i=0;i<listas.size();i++) {
					
					if(listas.get(i).getIdPedido()==idPedido) {
						
						listasCliente.add(listas.get(i));
					}
				}
				
				
				for(int j=0;j<listasCliente.size();j++) {
					acumulador=acumulador+listasCliente.get(j).getPrecioVenta()*listasCliente.get(j).getCantidad();
				}
				
				
				
				return acumulador;
				}
			
			
			
			 @RequestMapping(value ="/lista/eliminarProductoLista",method=RequestMethod.GET)
				public void eliminarProductoLista(@RequestParam(name = "idLista") int idLista	) {
					
				Lista tmpLista=this.serviceLista.buscarLista(idLista);
					
					this.serviceLista.eliminarproductoLista(tmpLista);
					
					
					return;
					
			 }
			 
			 
			 
			 
			
				
			
			
			
			
			//=======================================================================================
			 //                                        EMPLEADO
			 //======================================================================================
			
			 
			 @RequestMapping (value = "/empleado/agregarEmpleado",method=RequestMethod.POST)
				public String guardarEmpleado( @RequestParam(name = "id") int idEmpleado,
						                          @RequestParam(name = "nombre") String nombre,
						                      @RequestParam(name = "telefono") int telefono,
						                      @RequestParam(name = "direccion") String direccion ) {
					
		
					
					
					Empleado empleado = new Empleado(idEmpleado,nombre,telefono,direccion);
					
					
					
					this.serviceEmpleado.agregarEmpleado(empleado);
					return "paginaGeneralB";
					// nuevo admin return "paginaPrincipal";
				}
			
			

				//=======================================================================================
				 //                                        ORDEN ENTREGA
				 //======================================================================================
				
			 @RequestMapping (value = "/ordenentrega/crearOrdenEntrega",method=RequestMethod.POST)
				public String crearOrdenEntrega(@RequestParam(name = "id") int idOrdenEntrega,
						                          @RequestParam(name = "fechaCreacion")  @DateTimeFormat(iso = ISO.DATE)  LocalDate fechaCreacion,
						                      @RequestParam(name = "fechaEntrega")  @DateTimeFormat(iso = ISO.DATE)  LocalDate fechaEntrega,
						                      @RequestParam(name = "idEmpleado") int idEmpleado ,
						                      @RequestParam(name = "idPedido") int idPedido) {
					
		
					
					
					
					Pedido pedido =this.servicePedido.buscarPedido(idPedido);
					Empleado empleado=this.serviceEmpleado.buscarEmpleado(idEmpleado);
					
					
					OrdenEntrega ordenEntrega=new OrdenEntrega(idOrdenEntrega,fechaCreacion,fechaEntrega,idEmpleado, idPedido,empleado,pedido);
					this.serviceOrdenEntrega.crearOrdenEntrega(ordenEntrega);
					
					return "paginaGeneralB";
					//nueva pagina admin return "paginaprincipal";
					
				}
			 
			 
			 @RequestMapping(value ="/ordenentrega/eliminarOrdenEntrega",method=RequestMethod.GET)
				public void eliminarOrdenEntrega(@RequestParam(name = "idOrdenEntrega") int idOrdenEntrega	) {
					
				OrdenEntrega tmpOrdenEntrega=this.serviceOrdenEntrega.buscarOrdenEntrega(idOrdenEntrega);
				
					
					this.serviceOrdenEntrega.eliminarOrdenEntrega(tmpOrdenEntrega);
					
					
					return ;
					
			 }
			 
			 //=========================================================================
			 //                    actualizar inventario
			 //==========================================================================
			
			 @RequestMapping(value ="/producto/actualizarInventario",method=RequestMethod.POST)
			 public String actualizarInventario(@RequestParam(name = "id") int idPedido	) {
				 
				 Pedido p=this.servicePedido.buscarPedido(idPedido);
				 Cliente c= this.serviceCliente.buscarCliente(p.getCliente().getIdCliente());
				 float acumulador=c.getLimiteCredito()-this.preciosAcumulado(idPedido);
				 this.serviceCliente.actualizarLimiteCreditoCliente(acumulador, c.getIdCliente());
				List<Lista> tmpListasPedido=this.serviceLista.obtenerListasProductos();
				
				for(int i=0;i<tmpListasPedido.size();i++) {
					
					if(tmpListasPedido.get(i).getIdPedido()==idPedido) {
						
						this.actualizarCantidad(tmpListasPedido.get(i).getCantidad(), tmpListasPedido.get(i).getIdProducto());
					}
					
				}
				
				
				return "paginaPrincipalClientes"; 
			}
			 
			 //=============================================================================
			 //                            ADMINISTRADOR
			 //=======================================================================
			

			 @RequestMapping (value = "/administrador/agregarAdministrador",method=RequestMethod.POST)
				public String crearCliente(@RequestParam(name = "id") int idAdministrador,
						                    @RequestParam(name = "usuario") String usuario,
						                    @RequestParam(name = "contrasenia") String contrasenia,
						                    @RequestParam(name = "rol") String rol
						                  ) {
					 
					Administrador tmpAdministrador = new Administrador(idAdministrador,usuario,passwordEncoder.encode(contrasenia),rol);
					this.serviceAdministrador.crearAdministrador(tmpAdministrador);
					return "paginaGeneralB";
				}
			 
            //======================================================================================================
			// nuevos de media noche
           //================================================================================================
			 @RequestMapping (value = "/producto/agregarMas",method=RequestMethod.POST)
			 public String agregarCantidadMas(@RequestParam(name = "id") int idProducto,
	                    @RequestParam(name = "cantidad") float cantidad) {

                 float acumulador=0;
				 Producto p=this.serviceProducto.buscarProducto(idProducto);
                 acumulador= acumulador+p.getCantidadExistente()+cantidad;
                 this.serviceProducto.actualizarCantidadExistente(acumulador, idProducto);
				 
            return "paginaGeneralB";
               }
			 
			 
			 //======================================================================
			 //======================ultimos 2 en admin=============================
			 
			 @RequestMapping(value ="/provedor/mostrarProvedor",method=RequestMethod.GET)
				public String listadoProvedor(Model model) {
					List<Provedor> provedor = this.serviceProvedor.obtenerProvedor();
					model.addAttribute("provedor", provedor);
					
					return "mostrarProvedores";
				}
			 
			 
			 @RequestMapping(value ="/empleado/mostrarEmpleados",method=RequestMethod.GET)
				public String listadoEmpleados(Model model) {
					List<Empleado> empleado = this.serviceEmpleado.obtenerEmpleado();
					model.addAttribute("empleado", empleado);
					
					return "mostrarEmpleados";
				}
			 
			 
}
