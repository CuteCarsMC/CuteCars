package io.github.cutecarsmc;

import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;

@Entrypoint
public final class CuteCarsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		System.out.println("Mod ID" + CuteCars.MOD_ID);
		System.out.println("Version" + CuteCars.VERSION);
		System.out.println("Commit hash" + CuteCars.COMMIT_HASH);
	}
}