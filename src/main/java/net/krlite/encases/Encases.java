package net.krlite.encases;

import com.simibubi.create.Create;

import com.simibubi.create.foundation.data.CreateRegistrate;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

import net.krlite.encases.util.EncasesItemGroups;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Encases implements ModInitializer {
	public static final String NAME = "Create: Encases", ID = "encases";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]! ⚙️", NAME, Create.VERSION);
		LOGGER.info(EnvExecutor.unsafeRunForDist(
				() -> () -> "{} is accessing Porting Lib from the client!",
				() -> () -> "{} is accessing Porting Lib from the server!"
		), NAME);
	}

	public static CreateRegistrate registrate() {
		return REGISTRATE.creativeModeTab(() -> EncasesItemGroups.CREATORS_DECORS);
	}

	public static Identifier identifier(String... paths) {
		return id(Arrays.stream(paths).filter(Objects::nonNull).filter(p -> !p.isEmpty()).collect(Collectors.joining("/")));
	}

	public static Identifier id(String path) {
		return new Identifier(ID, path);
	}
}
