package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import entidades.Rodada;


@FacesConverter(value = "ConverterRodada")
public class ConverterRodada implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
			
		if(value != null && !value.isEmpty()) 
				return (Rodada) uiComponent.getAttributes().get(value);

			return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if(value instanceof Rodada) {			
			Rodada rodada = (Rodada) value;
			
			if(rodada != null && rodada instanceof Rodada && Integer.toString((int) rodada.getIdRodada()) != null) {
				
				uiComponent.getAttributes().put(Integer.toString((int) rodada.getIdRodada()), rodada);
				return Integer.toString((int) rodada.getIdRodada());
			}	
			
		}
		
		return "";
	}

}