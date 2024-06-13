package br.ufmg.dcc.luar.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufmg.dcc.luar.model.Albumn;

@FacesConverter(forClass = Albumn.class , value = "albumnConverter")
public class AlbumnConverter implements Converter<Albumn> {


    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebPlayer_JavaProject");

    @Override
    public Albumn getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        if (value == null || value.isEmpty()) {
            return null;
        }
        EntityManager manager = factory.createEntityManager();
        try {
            return manager.find(Albumn.class, Integer.parseInt(value));
        } catch (NumberFormatException e) {
            throw new ConverterException("Invalid value: " + value, e);
        } finally {
            manager.close();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Albumn value) throws ConverterException {
        if (value == null) {
            return "";
        }
        return String.valueOf(value.getId());
    }
}