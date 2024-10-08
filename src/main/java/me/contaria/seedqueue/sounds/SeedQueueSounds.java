package me.contaria.seedqueue.sounds;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SeedQueueSounds {
    public static final SoundEvent PLAY_INSTANCE = register("play_instance");
    public static final SoundEvent LOCK_INSTANCE = register("lock_instance");
    public static final SoundEvent RESET_INSTANCE = register("reset_instance");
    public static final SoundEvent RESET_ALL = register("reset_all");
    public static final SoundEvent RESET_COLUMN = register("reset_column");
    public static final SoundEvent RESET_ROW = register("reset_row");
    public static final SoundEvent START_BENCHMARK = register("start_benchmark");
    public static final SoundEvent FINISH_BENCHMARK = register("finish_benchmark");

    public static void init() {
    }

    private static SoundEvent register(String id) {
        return register(new Identifier("seedqueue", id));
    }

    private static SoundEvent register(Identifier id) {
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
