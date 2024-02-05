package ru.creatopico.dao.train;

import java.util.UUID;

public record Train(Integer id, UUID key, UUID owner, String dimension, String pos, String nbt) {
}
