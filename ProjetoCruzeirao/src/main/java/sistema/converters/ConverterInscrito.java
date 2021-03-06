package sistema.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.entidades.Inscrito;

@FacesConverter(value = "ConverterInscrito")
public class ConverterInscrito implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
			
		if(value != null && !value.isEmpty()) 
				return (Inscrito) uiComponent.getAttributes().get(value);

			return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if(value instanceof Inscrito) {			
			Inscrito inscrito = (Inscrito) value;
			
			if(inscrito != null && inscrito instanceof Inscrito && inscrito.getUsuario().getNome() != null) {
				
				uiComponent.getAttributes().put(inscrito.getUsuario().getNome().toString(), inscrito);
				return inscrito.getUsuario().getNome().toString();
			}	
			
		}
		
		return "";
	}

}