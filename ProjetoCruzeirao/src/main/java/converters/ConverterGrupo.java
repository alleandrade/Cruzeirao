package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import entidades.Grupo;


@FacesConverter(value = "ConverterGrupo")
public class ConverterGrupo implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
			
		if(value != null && !value.isEmpty()) 
				return (Grupo) uiComponent.getAttributes().get(value);

			return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if(value instanceof Grupo) {			
			Grupo grupo = (Grupo) value;
			
			if(grupo != null && grupo instanceof Grupo && grupo.getNome() != null) {
				
				uiComponent.getAttributes().put(grupo.getNome().toString(), grupo);
				return grupo.getNome().toString();
			}	
			
		}
		
		return "";
	}

}