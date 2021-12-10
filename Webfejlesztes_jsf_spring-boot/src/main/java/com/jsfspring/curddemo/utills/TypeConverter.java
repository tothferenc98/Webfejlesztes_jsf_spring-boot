package com.jsfspring.curddemo.utills;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsfspring.curddemo.service.TypeService;
import com.jsfspring.curddemo.uito.TypeUITO;

@Service
public class TypeConverter implements Converter {

	@Autowired
	private TypeService typeService;

	private static final Logger LOG = LoggerFactory.getLogger(TypeConverter.class.getName());

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		LOG.info("getAsObject: " + typeService);

		TypeUITO typeUITO = new TypeUITO();
		typeUITO.setTypeName(string);
		typeUITO = typeService.getDepartment(typeUITO);
		System.out.println(typeUITO.toString());
		return typeUITO;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		LOG.info("getAsString obj class: " + obj.getClass().getName());
		if (obj instanceof TypeUITO) {
			TypeUITO dept = (TypeUITO) obj;
			LOG.info("getAsString def name: " + dept.getTypeName());
			return dept.getTypeName();
		} else {
			StringBuilder sbError = new StringBuilder("The object of class ");
			sbError.append(obj.getClass().getName()).append(" is not of TypeUITO");
			throw new ClassCastException(sbError.toString());
		}
	}
}