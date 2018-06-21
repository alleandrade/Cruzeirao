package sistema.converters;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.entidades.Equipe;


@FacesConverter(value = "ConverterEquipe")
public class ConverterEquipe implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
			
		if(value != null && !value.isEmpty()) 
				return (Equipe) uiComponent.getAttributes().get(value);

			return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if(value instanceof Equipe) {			
			Equipe equipe = (Equipe) value;
			
			if(equipe != null && equipe instanceof Equipe && equipe.getNome() != null) {
				
				uiComponent.getAttributes().put(equipe.getNome().toString(), equipe);
				return equipe.getNome().toString();
			}	
			
		}
		
		return "";
	}

}