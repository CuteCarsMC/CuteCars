package io.github.cutecarsmc.utils.uwuify;

import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.FormattedCharSink;
import org.jspecify.annotations.NonNull;

public class UwuifiedCharSequence implements FormattedCharSequence {
	private final FormattedCharSequence original;
	private final String uwuified;

	public UwuifiedCharSequence(FormattedCharSequence original) {
		this.original = original;
		this.uwuified = Uwuifier.uwuify(this.original);
	}

	@Override
	public boolean accept(@NonNull FormattedCharSink output) {
		return original.accept((position, style, codepoint) -> {
			// thanks jab lol
			for (int newCodepoint : (Iterable<Integer>) uwuified.chars()::iterator) {
				output.accept(position, style, newCodepoint);
			}
			return false;
		});
	}
}
