package test.issue12.app;

import javax.annotation.PostConstruct;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * @author tomschindl
 *
 */
public class ChildPart2 {
	@PostConstruct
	void init( BorderPane p ) {
		p.setCenter(new Button("Child 2"));
	}
}
