package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import entidades.Local;

@FacesConverter(value = "ConverterLocal")
public class ConverterLocal implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
			
		if(value != null && !value.isEmpty()) 
				return (Local) uiComponent.getAttributes().get(value);

			return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if(value instanceof Local) {			
			Local local = (Local) value;
			
			if(local != null && local instanceof Local && local.getNome() != null) {
				
				uiComponent.getAttributes().put(local.getNome().toString(), local);
				return local.getNome().toString();
			}	
			
		}
		
		return "";
	}

}
