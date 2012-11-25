 package com.receta.receta.client;
  
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextInputCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
  
  /** Ejemplo de areas de texto. */
  public class TablasEntryPoint extends Composite implements EntryPoint {
    
    /** Modelo de selección. Permite detectar selecciones en la tabla. */
    private SingleSelectionModel<Contacto> sm =
        new SingleSelectionModel<Contacto>();
    {
      /* Añade un objeto que recibe notificaciones cuando cambia la selección. */
     sm.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
        @Override
        public void onSelectionChange(SelectionChangeEvent event) {
          Contacto c = sm.getSelectedObject();
          if (c != null) {
            Window.alert(c.getnombre_medicamento());
          }
        }
      });
    }
    
    private final CellTable<Contacto> tblConocidos = new CellTable<Contacto>(5);
    {

      tblConocidos.setSelectionModel(sm);
      tblConocidos.addColumn(new Column<Contacto, Number>(new NumberCell()) {
        {
          setHorizontalAlignment(HasAlignment.ALIGN_RIGHT);
        }
        @Override
        public Integer getValue(final Contacto objeto) {
          return objeto.getcantidad();
        }
      }, "Cantidad");
      
      tblConocidos.addColumn(new TextColumn<Contacto>() {
          public String getValue(final Contacto objeto) {
              return objeto.getcodigo();
          }
      }, "Codigo");
            
      tblConocidos.addColumn(new TextColumn<Contacto>() {
        @Override
        public String getValue(final Contacto objeto) {
          return objeto.getnombre_medicamento();
        }
      }, "Nombre Medicamento", "Total: ");    
      
      tblConocidos.addColumn(new Column<Contacto, Number>(new NumberCell()) {
       @Override
        public Integer getValue(final Contacto objeto) {
         return objeto.getmonto();
       }
     }, "Precio", "(Monto Total Calculado)");
   }
   
    private final SimplePager pager = new SimplePager();
   {
//	 pager.setPageSize(10);
     pager.setDisplay(tblConocidos);
   }
   
   public TablasEntryPoint() {
     ListDataProvider<Contacto> dataProvider = new ListDataProvider<Contacto>(
         new ArrayList<Contacto>(Arrays.asList(
         new Contacto(1, "panadol", "0x0001", 34),
         new Contacto(2, "cicatriquiur", "0x0002", 56),
         new Contacto(3, "dulcolax", "0x0003", 28),
         new Contacto(4, "diasepan", "0x0004", 15),
         new Contacto(5, "omeprazol", "0x0005", 32),
         new Contacto(6, "ranitidica", "0x0006", 89))));
     dataProvider.addDataDisplay(tblConocidos);
     
     
     
     // Datos Paciente:
     HorizontalPanel hpanel1 = new HorizontalPanel();
     hpanel1.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
     Label h1lbl = new Label("Nombre Paciente: ");
     hpanel1.add(h1lbl);
     TextBox h1lb2 = new TextBox();
     h1lb2.setText("Michelle Chavez Diaz");
     h1lb2.setEnabled(false);
//     Label h1lb2 = new Label("Michelle Chavez Diaz");
     hpanel1.add(h1lb2);
     
     // Datos Paciente:
     HorizontalPanel hpanel2 = new HorizontalPanel();
     hpanel2.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
     Label h2lbl = new Label("Nombre Medico: ");
     hpanel2.add(h2lbl);
     TextBox h2lb2 = new TextBox();
     h2lb2.setText("Michelle Chavez Diaz");
     h2lb2.setEnabled(false);
     //Label h2lb2 = new Label("Michelle Chavez Diaz");
     hpanel2.add(h2lb2);
     
     // Fecha:
     HorizontalPanel hpanel3 = new HorizontalPanel();
     hpanel3.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
     Label h3lbl = new Label("Fecha Expedida: ");
     hpanel3.add(h3lbl);
     TextBox h3lb2 = new TextBox();
     h3lb2.setText("15-02-12");
     h3lb2.setEnabled(false);
  //   Label h3lb2 = new Label("");	
     hpanel3.add(h3lb2);
     
//     Separator sep = new Separator();
     
     VerticalPanel panel = new VerticalPanel();//("Detalle Receta");

//     panel.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
     panel.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
     panel.add(hpanel1);
     panel.add(hpanel2);
     panel.add(hpanel3);
     panel.add(tblConocidos);
     panel.add(pager);
     
     Button aceptar = new Button("Aceptar");
     panel.add(aceptar);
     
     
     initWidget(panel);
   }
   public void onModuleLoad() {
     RootPanel.get().add(this);
   }
 }
