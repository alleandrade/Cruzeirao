package sistema.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.entidades.Juiz;


@FacesConverter(value = "ConverterJuiz")
public class ConverterJuiz implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
			
		if(value != null && !value.isEmpty()) 
				return (Juiz) uiComponent.getAttributes().get(value);

			return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if(value instanceof Juiz) {			
			Juiz juiz = (Juiz) value;
			
			if(juiz != null && juiz instanceof Juiz && juiz.getUsuario().getNome() != null) {
				
				uiComponent.getAttributes().put(juiz.getUsuario().getNome().toString(), juiz);
				return juiz.getUsuario().getNome().toString();
			}	
			
		}
		
		return "";
	}

}