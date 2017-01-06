package org.notimeforthat.template.persistence;

/**
 * Created by christianbraun on 06/01/17.
 */
public class DaoFactory {

	public static EntryDao createEntryDao() {
		return new EntryDao(MongoPersistency.getInstance().getDatastore());
	}
}
