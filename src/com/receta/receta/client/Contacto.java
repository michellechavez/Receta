package com.receta.receta.client;
 
 import java.util.Date;
 
 /** Modelo. Se recomienda que los modelos solo contengan referencias para que
  * interactúen más fácilmente con las vistas. */
 public class Contacto {
   private Integer cantidad;
   private String nombre_medicamento;
   private String codigo;
   private Integer monto;
   
   public Contacto() {
   }
   
   public Contacto(Integer cantidad, String nombre_medicamento, String codigo, Integer monto) {
     this.cantidad = cantidad;
     this.nombre_medicamento = nombre_medicamento;
     this.codigo = codigo;
     this.monto = monto;
   }
   
   public Integer getcantidad() {
     return cantidad;
   }
   
   public void setcantidad(Integer cantidad) {
     this.cantidad = cantidad;
   }
   
   public String getnombre_medicamento() {
     return nombre_medicamento;
   }
   
   public void setnombre_medicamento(String nombre_medicamento) {
     this.nombre_medicamento = nombre_medicamento;
   }
   
   public String getcodigo() {
	 return codigo;
   }
   
   public void setcodigo(String codigo) {
     this.codigo = codigo;
   }
   
   public Integer getmonto() {
     return monto;
   }
   public void setmonto(Integer monto) {
     this.monto = monto;
   }
   
   @Override
   public boolean equals(Object obj) {
     if (obj != null && getClass() == obj.getClass()) {
       final Contacto otra = (Contacto) obj;
       return getcantidad() == otra.getcantidad();
     } else {
       return false;
     }
   }
   
   @Override
   public int hashCode() {
     return 93 * getcantidad();
   }
 }