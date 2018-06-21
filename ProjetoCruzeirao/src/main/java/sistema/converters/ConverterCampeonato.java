package sistema.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.entidades.Campeonato;


@FacesConverter(value = "ConverterCampeonato")
public class ConverterCampeonato implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
			
		if(value != null && !value.isEmpty()) 
				return (Campeonato) uiComponent.getAttributes().get(value);

			return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if(value instanceof Campeonato) {			
			Campeonato campeonato = (Campeonato) value;
			
			if(campeonato != null && campeonato instanceof Campeonato && campeonato.getNome() != null) {
				
				uiComponent.getAttributes().put(campeonato.getNome().toString(), campeonato);
				return campeonato.getNome().toString();
			}	
			
		}
		
		return "";
	}

}