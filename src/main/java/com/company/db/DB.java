package com.company.db;

import one.microstream.cluster.nodelibrary.common.ClusterStorageManager;
import one.microstream.reference.Lazy;

public class DB
{
	private static final DB INSTANCE = new DB();

	public static DataRoot root()
	{
		return INSTANCE.root.get();
	}
	
	public static void store(final Object o)
	{
		INSTANCE.storage.store(o);
	}

	private final Lazy<DataRoot> root;
	private final ClusterStorageManager<DataRoot> storage = new ClusterStorageManager<>(new DataRoot());

	private DB()
	{
		this.root = this.storage.getRoot();
	}
}
