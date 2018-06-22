package sistema.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.entidades.Inscricao;


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
			
			if(inscricao != null && inscricao instanceof Inscricao && inscricao.getEquipe() != null) {
				
				uiComponent.getAttributes().put(inscricao.getEquipe().toString(), inscricao);
				return inscricao.getEquipe().toString();
			}	
			
		}
		
		return "";
	}

}