package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import entidades.PartidasFutebol;


@FacesConverter(value = "ConverterPartidaFutebol")
public class ConverterPartidaFutebol implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
			
		if(value != null && !value.isEmpty()) 
				return (PartidasFutebol) uiComponent.getAttributes().get(value);

			return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if(value instanceof PartidasFutebol) {			
			PartidasFutebol partidafutebol = (PartidasFutebol) value;
			
			if(partidafutebol != null && partidafutebol instanceof PartidasFutebol && Integer.toString((int) partidafutebol.getIdPartida()) != null) {
				
				uiComponent.getAttributes().put(Integer.toString((int) partidafutebol.getIdPartida()), partidafutebol);
				return Integer.toString((int) partidafutebol.getIdPartida());
			}	
			
		}
		
		return "";
	}

}