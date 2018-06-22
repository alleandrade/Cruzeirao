package sistema.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.entidades.Fase;


@FacesConverter(value = "ConverterFase")
public class ConverterFase implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
			
		if(value != null && !value.isEmpty()) 
				return (Fase) uiComponent.getAttributes().get(value);

			return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if(value instanceof Fase) {			
			Fase fase = (Fase) value;
			
			if(fase != null && fase instanceof Fase && Integer.toString((int) fase.getIdFase()) != null) {
				
				uiComponent.getAttributes().put(Integer.toString((int) fase.getIdFase()), fase);
				return Integer.toString((int) fase.getIdFase());
			}	
			
		}
		
		return "";
	}

}