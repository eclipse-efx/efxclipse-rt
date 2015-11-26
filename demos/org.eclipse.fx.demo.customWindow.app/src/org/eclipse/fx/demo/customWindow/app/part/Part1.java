 
package org.eclipse.fx.demo.customWindow.app.part;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.event.EventBus;
import org.eclipse.fx.demo.customWindow.app.CustomWindowDemoConstants;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class Part1 {
	
	private static final String LOREM_IMSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla mauris nisl, vulputate in velit in, varius tempor sem. Suspendisse potenti. Morbi blandit, dui a tristique rhoncus, est elit varius massa, nec tincidunt risus risus in nisi. Cras egestas euismod diam, in dapibus quam feugiat non. Quisque cursus nulla id sollicitudin tempus. Suspendisse sit amet venenatis massa, vel pellentesque lacus. Ut diam ante, egestas quis eleifend sed, suscipit eu leo. Nulla facilisi. Nulla aliquam lacinia lorem, eu interdum lectus pretium vel. Nullam rutrum eros risus, vel suscipit neque maximus sit amet. Suspendisse malesuada euismod eleifend. Maecenas eros sapien, lobortis sed dolor eget, iaculis efficitur tellus. Nulla semper libero quis purus maximus, ac fermentum purus porta. Maecenas molestie id lacus nec tincidunt. Ut eleifend blandit neque, ac bibendum libero tristique quis. In vitae est vel mi dapibus condimentum pellentesque a diam.";
	
	private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
	private Subscription subscription;

	private ScheduledFuture<?> scheduledFuture;

	@PostConstruct
	void postConstruct(BorderPane parent, EventBus eventBus) {
		TextArea textArea = new TextArea();
		textArea.setWrapText(true);
		textArea.setText(LOREM_IMSUM);
		parent.setCenter(textArea);
		
		subscription = eventBus.subscribe(CustomWindowDemoConstants.TOPIC_SEARCH, searchText -> {
			if (scheduledFuture != null) {
				scheduledFuture.cancel(true);
			}
			
			textArea.setText("Searching for '" + searchText.getData() + "' ..." + "\n\n");
			
			Stack<String> stack = new Stack<>();
			List<String> wordsList = Arrays.asList(LOREM_IMSUM.split(" "));
			Collections.reverse(wordsList);
			stack.addAll(wordsList);
			scheduledFuture = executorService.scheduleAtFixedRate(() -> {
				String text = textArea.getText() + stack.pop() + " ";
				textArea.setText(text);
			}, 1200, 320, TimeUnit.MILLISECONDS);
		});
	}
	
	@PreDestroy
	void preDestroy() {
		if (scheduledFuture != null) {
			scheduledFuture.cancel(true);
		}
		executorService.shutdown();
		subscription.dispose();
	}
	
}