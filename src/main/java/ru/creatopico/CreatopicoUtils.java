package ru.creatopico;


import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.creatopico.config.Config;
import ru.creatopico.contraption.BreakableBlocks;
import ru.creatopico.dao.train.Train;
import ru.creatopico.dao.train.TrainDao;

import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class CreatopicoUtils implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "creatopicoutils";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Config CONFIG = Config.createAndLoad();

	public static Jdbi jdbi;

	@Override
	public void onInitialize() {
		String url = String.format(
				"jdbc:postgresql://%s:%s/%s",
				CONFIG.postgreSQL.address(),
				CONFIG.postgreSQL.port(),
				CONFIG.postgreSQL.database()
		);
		Properties jdbiProperties = new Properties();
		jdbiProperties.setProperty("user", CONFIG.postgreSQL.username());
		jdbiProperties.setProperty("password", CONFIG.postgreSQL.password());

		jdbi = Jdbi.create(url, jdbiProperties)
				.installPlugin(new SqlObjectPlugin())
				.installPlugin(new PostgresPlugin());


		CONFIG.contraption.dimensions()
				.stream()
				.map(Identifier::new)
				.forEach(BreakableBlocks.dimensionsWorksIn::add);

		try (Handle handle = jdbi.open()){
			TrainDao dao = handle.attach(TrainDao.class);
			dao.createTable();
			List<Train> trains = dao.userTrains("00000000-0000-0000-0000-000000000000");
			LOGGER.info("User trains test: " + trains);
		}
	}
}