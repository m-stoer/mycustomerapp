package com.company;

import com.company.db.DB;
import com.company.db.DataRoot;

import one.microstream.cluster.nodelibrary.common.ClusterStorageManager;
import one.microstream.cluster.nodelibrary.common.spi.ClusterStorageManagerProvider;

public class StorageManagerProvider implements ClusterStorageManagerProvider
{
	@Override
	public ClusterStorageManager<DataRoot> provideClusterStorageManager()
	{
		return DB.storage();
	}
}
