package com.company.business;

import java.io.IOException;
import java.time.LocalDate;

import io.micronaut.core.type.Argument;
import io.micronaut.serde.Decoder;
import io.micronaut.serde.Deserializer;
import io.micronaut.serde.Encoder;
import io.micronaut.serde.Serializer;

public class JsonLocalDateSerializer implements Serializer<LocalDate>, Deserializer<LocalDate>
{
	@Override
	public void serialize(
		final Encoder encoder,
		final EncoderContext context,
		final Argument<? extends LocalDate> type,
		final LocalDate value
	) throws IOException
	{
		encoder.encodeString(JsonDateFormatter.FORMATTER.format(value));
	}

	@Override
	public LocalDate deserialize(
		final Decoder decoder,
		final DecoderContext context,
		final Argument<? super LocalDate> type
	) throws IOException
	{
		return LocalDate.parse(decoder.decodeString(), JsonDateFormatter.FORMATTER);
	}
}
