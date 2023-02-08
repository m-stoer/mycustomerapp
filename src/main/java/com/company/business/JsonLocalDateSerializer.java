package com.company.business;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonLocalDateSerializer extends JsonSerializer<LocalDate>
{
	@Override
	public void serialize(final LocalDate value, final JsonGenerator gen, final SerializerProvider serializers)
		throws IOException
	{
		gen.getOutputContext().setCurrentValue(JsonDateFormatter.FORMATTER.format(value));
	}
}
