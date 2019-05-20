package org.nanotek.rpt;

import java.text.Format;

import ar.com.fdvs.dj.domain.CustomExpression;
import ar.com.fdvs.dj.domain.Style;

public class ColunaRelatorio {

	private String nomeAtributo;
	private String tipoAtributo;
	private String tituloColuna;
	private String pattern;
	private Format formatter;
	private Style style;
	private CustomExpression customExpression;
	private boolean isOnlyField;
	/**
	 * Adicionado width para ajuste tamanho coluna arquivo XLS
	 */
	private Integer width;
	
	public ColunaRelatorio(String tituloColuna, String nomeAtributo, String tipoAtributo) {
		super();
		this.nomeAtributo = nomeAtributo;
		this.tipoAtributo = tipoAtributo;
		this.tituloColuna = tituloColuna; 
		this.pattern = null;
		this.formatter = null;
		this.style = null;
		this.isOnlyField = false;
		this.customExpression = null;
	}
	
	public ColunaRelatorio(String tituloColuna, String nomeAtributo, String tipoAtributo, String pattern,
			Format formatter, Style style) {
		super();
		this.nomeAtributo = nomeAtributo;
		this.tipoAtributo = tipoAtributo;
		this.tituloColuna = tituloColuna; 
		this.pattern = pattern;
		this.formatter = formatter;
		this.style = style;
		this.isOnlyField = false;
		this.customExpression = null;
	}
	 
	public ColunaRelatorio(String nomeAtributo, String tipoAtributo){
		super();
		this.nomeAtributo = nomeAtributo;
		this.tipoAtributo = tipoAtributo;
		this.isOnlyField = true; 
		this.tituloColuna = null; 
		this.pattern = null;
		this.formatter = null;
		this.style = null; 
		this.customExpression = null;
	}
	
	
	public ColunaRelatorio(String tituloColuna, String nomeAtributo, String tipoAtributo, String pattern,
			Format formatter, Style style, Integer xWidth) {
		super();
		this.nomeAtributo = nomeAtributo;
		this.tipoAtributo = tipoAtributo;
		this.tituloColuna = tituloColuna; 
		this.pattern = pattern;
		this.formatter = formatter;
		this.style = style;
		this.isOnlyField = false;
		this.customExpression = null;
		this.width  = (xWidth !=null)? xWidth:0;
	}
	
	public ColunaRelatorio(String tituloColuna, CustomExpression customExpression){
		super();
		this.tituloColuna = tituloColuna; 
		this.customExpression = customExpression;
	}
	
	public String getNomeAtributo() {
		return nomeAtributo;
	}

	public void setNomeAtributo(String nomeAtributo) {
		this.nomeAtributo = nomeAtributo;
	}

	public String getTipoAtributo() {
		return tipoAtributo;
	}

	public void setTipoAtributo(String tipoAtributo) {
		this.tipoAtributo = tipoAtributo;
	}

	public String getTituloColuna() {
		return tituloColuna;
	}

	public void setTituloColuna(String tituloColuna) {
		this.tituloColuna = tituloColuna;
	}
 
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Format getFormatter() {
		return formatter;
	}

	public void setFormatter(Format formatter) {
		this.formatter = formatter;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	} 
	
	public CustomExpression getCustomExpression() {
		return customExpression;
	}

	public void setCustomExpression(CustomExpression customExpression) {
		this.customExpression = customExpression;
	}

	public boolean isOnlyField() {
		return isOnlyField;
	}

	public void setOnlyField(boolean isOnlyField) {
		this.isOnlyField = isOnlyField;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
	
}