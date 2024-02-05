package ru.creatopico;


import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.creatopico.config.Config;
import ru.creatopico.contraption.BreakableBlocks;
import ru.creatopico.jdbc.Database;
import ru.creatopico.jdbc.entities.player.PlayerEntity;

import java.sql.DriverManager;
import java.sql.SQLException;

public class CreatopicoUtils implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "creatopicoutils";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Config CONFIG = Config.createAndLoad();


	public static Database database;

	@Override
	public void onInitialize() {
		CONFIG.contraption.dimensions()
				.stream()
				.map(Identifier::new)
				.forEach(BreakableBlocks.dimensionsWorksIn::add);
	}
}