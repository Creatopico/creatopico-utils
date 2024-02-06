package ru.creatopico.dao.train;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.UUID;

public interface TrainDao {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS Train (id INTEGER PRIMARY KEY, key UUID, owner UUID, dimension VARCHAR, pos VARCHAR, nbt TEXT)")
    void createTable();

    @SqlQuery("SELECT * FROM Train WHERE owner=:ownerUUID::uuid")
    @RegisterConstructorMapper(Train.class)
    List<Train> userTrains(@Bind("ownerUUID") String ownerUUID);
}
