package br.ufc.quixada.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;

@Alternative
@Priority(Interceptor.Priority.APPLICATION)
@Convert(Date.class)
@ApplicationScoped
public class DateConverter implements Converter<Date> {
	public Date convert(String dataString, Class<? extends Date> type) {
		if (dataString == null || dataString.equals("")) {
			return null;
		}
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			format.setLenient(false);
			return (Date) format.parse(dataString);
		} catch (ParseException e) {
			return null;
			//throw new ConversionException(new ConversionMessage("is_not_a_valid_date", dataString));
		}
	}
}