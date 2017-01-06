package org.notimeforthat.template.persistence;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by christianbraun on 06/01/17.
 */
public class MongoPersistency {

	private static MongoPersistency instance;

	private final MongoClient mongoClient;
	private final Morphia morphia;
	private Datastore baseDatastore;

	private MongoPersistency(){
		mongoClient = new MongoClient("mongo");
		morphia = new Morphia();
		morphia.mapPackage("org.notimeforthat.template");
	}

	public static MongoPersistency getInstance() {
		if (instance == null) {
			instance = new MongoPersistency();
		}
		return instance;
	}

	public Datastore getDatastore(String dbName) {
		return morphia.createDatastore(mongoClient, dbName);
	}

	public Datastore getDatastore() {
		if (baseDatastore == null) {
			baseDatastore = morphia.createDatastore(mongoClient, "template");
			baseDatastore.ensureIndexes();
		}

		return baseDatastore;
	}

}
