package ru.creatopico.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Nest;
import io.wispforest.owo.config.annotation.SectionHeader;
import ru.creatopico.CreatopicoUtils;

import java.util.ArrayList;
import java.util.List;

@Modmenu(modId = CreatopicoUtils.MOD_ID)
@Config(name = "creatopico", wrapperName = "Config")
public class ConfigModel {
    @SectionHeader("Server")
    @Nest
    public PostgreSQL postgreSQL = new PostgreSQL();

    @Nest
    public Contraption contraption = new Contraption();

    @SectionHeader("Client")
    public List<String> runCommandsOnEnter = new ArrayList<>(List.of("bobby upgrade"));

    public static class Contraption {
        public List<String> dimensions = List.of("minecraft:blank");
    }

    public static class PostgreSQL {
        public String address;
        public String port;
        public String username;
        public String password;
        public String database;
    }
}