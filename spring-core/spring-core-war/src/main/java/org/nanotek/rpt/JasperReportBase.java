package org.nanotek.rpt;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

import org.apache.commons.codec.binary.Base64;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.core.layout.LayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;

@SuppressWarnings("rawtypes")
public class JasperReportBase implements ReportBase<DynamicReport>{

	protected JasperReport jr;
	protected DynamicReport dr;
	protected Map params = new HashMap();
	protected JasperPrint jp;
	protected byte[] bytes = null;
	
	protected void exportToJRXML() throws Exception {
		if (this.jr != null){
			DynamicJasperHelper.generateJRXML(this.jr, "UTF-8",System.getProperty("user.dir")+ "/target/reports/" + this.getClass().getName() + ".jrxml");
		} else {
			DynamicJasperHelper.generateJRXML(this.dr, this.getLayoutManager(), this.params, "UTF-8",System.getProperty("user.dir")+ "/target/reports/" + this.getClass().getName() + ".jrxml");
		}
	}	

	private LayoutManager getLayoutManager() {
		 return new ClassicLayoutManager();
	}

	protected void exportToHTML() throws Exception {
		ReportExporter.exportReportHtml(this.jp, System.getProperty("user.dir")+ "/target/reports/" + this.getClass().getName() + ".html");
	}

	public byte[] exportReport (List<Map<String,?>> data){ 
		JRDataSource jrdDataSource = new JRMapCollectionDataSource(data);
		Map  params = new HashMap<>();
		
		 try {
			 jr = DynamicJasperHelper.generateJasperReport(buildReport(), getLayoutManager(), params);
			 jp = JasperFillManager.fillReport(jr, params, jrdDataSource);
			 bytes = JasperExportManager.exportReportToPdf(jp);
		} catch (JRException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		 return new Base64().encode(bytes);
	}
	
	@Override
	public DynamicReport buildReport() {
		
		Style detailStyle = new Style();
		Style headerStyle = new Style();
		headerStyle.setFont(Font.VERDANA_MEDIUM_BOLD);
		headerStyle.setBorderBottom(Border.PEN_2_POINT());
		headerStyle.setHorizontalAlign(HorizontalAlign.CENTER);
		headerStyle.setVerticalAlign(VerticalAlign.MIDDLE);
		headerStyle.setBackgroundColor(Color.DARK_GRAY);
		headerStyle.setTextColor(Color.WHITE);
		headerStyle.setTransparency(Transparency.OPAQUE);
		 
		Style titleStyle = new Style();
		titleStyle.setFont(new Font(18,Font._FONT_VERDANA,true));
		Style importeStyle = new Style();
		importeStyle.setHorizontalAlign(HorizontalAlign.RIGHT);
		Style oddRowStyle = new Style();
		oddRowStyle.setBorder(Border.NO_BORDER()); oddRowStyle.setBackgroundColor(Color.LIGHT_GRAY);oddRowStyle.setTransparency(Transparency.OPAQUE);
		
		DynamicReportBuilder drb = new DynamicReportBuilder();
		drb.setTitle("Artist's Name Report Sample")		//defines the title of the report
        .setSubtitle("The items in this report correspond "
                        +"to Artists and their sort names for search!")
        .setDetailHeight(15)		//defines the height for each record of the report
        .setMargins(30, 20, 30, 15)		//define the margin space for each side (top, bottom, left and right)
        .setColumnsPerPage(1);
		
		AbstractColumn id = ColumnBuilder.getNew().setColumnProperty("id", Long.class.getName())
				.setTitle("ID").setWidth(new Integer(85))
				.setStyle(titleStyle).setHeaderStyle(headerStyle).build();
		
		AbstractColumn name = ColumnBuilder.getNew().setColumnProperty("name", String.class.getName())
				.setTitle("Name").setWidth(new Integer(200))
				.setStyle(titleStyle).setHeaderStyle(headerStyle).build();
		
		AbstractColumn sortName = ColumnBuilder.getNew().setColumnProperty("sortName", String.class.getName())
				.setTitle("Sort Name").setWidth(new Integer(200))
				.setStyle(titleStyle).setHeaderStyle(headerStyle).build();
		
		AbstractColumn mbid = ColumnBuilder.getNew().setColumnProperty("mbid", Long.class.getName())
				.setTitle("MBID").setWidth(new Integer(85))
				.setStyle(titleStyle).setHeaderStyle(headerStyle).build();
		
		drb.addColumn(id);
		drb.addColumn(name);
		drb.addColumn(sortName);
		drb.addColumn(mbid);
//        .setDefaultStyles(titleStyle, subtitleStyle, headerStyle, detailStyle)
//        .setColumnsPerPage(1);		//defines columns per page (like in the telephone guide)
		return drb.build();
	}

}
