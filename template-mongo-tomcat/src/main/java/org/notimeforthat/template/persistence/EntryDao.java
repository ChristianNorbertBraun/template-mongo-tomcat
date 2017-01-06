package org.notimeforthat.template.persistence;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.notimeforthat.template.models.Entry;

/**
 * Created by christianbraun on 06/01/17.
 */
public class EntryDao extends BasicDAO<Entry, ObjectId>{

	protected EntryDao(Datastore ds) {
		super(ds);
	}
}
