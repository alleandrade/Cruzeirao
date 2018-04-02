package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import entidades.Usuario;


@FacesConverter(value = "ConverterUsuario")
public class ConverterUsuario implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
			
		if(value != null && !value.isEmpty()) 
				return (Usuario) uiComponent.getAttributes().get(value);

			return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if(value instanceof Usuario) {			
			Usuario usuario = (Usuario) value;
			
			if(usuario != null && usuario instanceof Usuario && usuario.getNome() != null) {
				
				uiComponent.getAttributes().put(usuario.getNome().toString(), usuario);
				return usuario.getNome().toString();
			}	
			
		}
		
		return "";
	}

}