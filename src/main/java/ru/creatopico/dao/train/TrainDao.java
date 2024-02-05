package ru.creatopico.dao.train;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.UUID;

public interface TrainDao {

    @SqlUpdate("CREATE TABLE Train (id INTEGER PRIMARY KEY, key UUID, owner UUID, dim VARCHAR, pos VARCHAR, nbt TEXT)")
    void createTable();

    @SqlQuery("SELECT * FROM Train WHERE owner=':owner'")
    @RegisterBeanMapper(Train.class)
    List<Train> userTrains(@BindBean UUID owner);
}
