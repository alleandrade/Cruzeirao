package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import entidades.Categoria;


@FacesConverter(value = "ConverterCategoria")
public class ConverterCategoria implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
			
		if(value != null && !value.isEmpty()) 
				return (Categoria) uiComponent.getAttributes().get(value);

			return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if(value instanceof Categoria) {			
			Categoria categoria = (Categoria) value;
			
			if(categoria != null && categoria instanceof Categoria && categoria.getNome() != null) {
				
				uiComponent.getAttributes().put(categoria.getNome().toString(), categoria);
				return categoria.getNome().toString();
			}	
			
		}
		
		return "";
	}

}