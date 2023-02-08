package com.company.business;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonLocalDateDeserializer extends JsonDeserializer<LocalDate>
{
	@Override
	public LocalDate deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException,
		JacksonException
	{
		return LocalDate.parse(p.currentToken().asString(), JsonDateFormatter.FORMATTER);
	}
}
