package org.notimeforthat.template.filters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bson.types.ObjectId;

import java.io.IOException;

/**
 * Created by christianbraun on 06/01/17.
 */
public class ObjectIdJsonSerializer extends JsonSerializer<ObjectId> {
	@Override
	public Class<ObjectId> handledType() {
		return ObjectId.class;
	}

	@Override
	public void serialize(ObjectId objectId, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
		if (objectId == null) {
			jsonGenerator.writeNull();
		} else {
			jsonGenerator.writeString(objectId.toString());
		}
	}
}
