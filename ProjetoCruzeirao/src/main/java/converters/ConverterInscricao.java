package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import entidades.Inscricao;


@FacesConverter(value = "ConverterInscricao")
public class ConverterInscricao implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
			
		if(value != null && !value.isEmpty()) 
				return (Inscricao) uiComponent.getAttributes().get(value);

			return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		
		if(value instanceof Inscricao) {			
			Inscricao inscricao = (Inscricao) value;
			
			if(inscricao != null && inscricao instanceof Inscricao && Integer.toString((int) inscricao.getNumero()) != null) {
				
				uiComponent.getAttributes().put(Integer.toString((int) inscricao.getNumero()), inscricao);
				return Integer.toString((int) inscricao.getNumero());
			}	
			
		}
		
		return "";
	}

}