package org.eclipse.fx.ui.workbench.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.e4.ui.model.application.ui.MUIElement;

public interface EModelStylingService {
	public static void addModelTag(MUIElement element, String... tags) {
		List<String> cssTags = Stream.of(tags).map(t -> "efx_styleclass:" + t).collect(Collectors.toList());
		element.getTags().remove(cssTags);
		element.getTags().addAll(cssTags);
	}

	public static void removeModelTag(MUIElement element, String... tags) {
		List<String> cssTags = Stream.of(tags).map(t -> "efx_styleclass:" + t).collect(Collectors.toList());
		element.getTags().removeAll(cssTags);
	}

	public static List<String> getModelTags(MUIElement element) {
		return element.getTags().stream().filter((t) -> t.startsWith("efx_styleclass:")).collect(Collectors.toList());
	}

	public void addModelTag(String... tags);
	public void removeModelTag(String... tags);
	public List<String> getModelTags(List<String> tagList);
}
