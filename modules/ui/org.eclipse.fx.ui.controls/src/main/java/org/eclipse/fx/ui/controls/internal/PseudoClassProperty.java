package org.eclipse.fx.ui.controls.internal;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.css.PseudoClass;
import javafx.scene.Node;

/**
 * a BooleanProperty that simplifies the creation of css pseudo classes.
 * <p>
 * It automatically updates the pseudo state on invalidation by calling <code>pseudoClassStateChanged</code> on its container node.
 * </p>
 * <p>
 * Usage Example:
 * <pre>
 * public class MyNode extends Node {
 *   // ..
 *   private static PseudoClass CUSTOM = PseudoClass.getPseudoClass("custom");
 *   private BooleanProperty custom = PseudoClassProperty.create(CUSTOM, this, "custom", false);
 *   // ..
 * }
 * </pre>
 * or as one-liner if you do not need the reference to PseudoClass
 * <pre>
 * public class MyNode extends Node {
 *   // ..
 *   private BooleanProperty custom = PseudoClassProperty.create("custom", this, "custom", false);
 *   // ..
 * }
 * </pre>
 * </p>
 *
 */
public class PseudoClassProperty extends BooleanPropertyBase {
    private final PseudoClass cls;
    private final Node node;
    private final String name;

    /**
     * 
     * @param cls the pseudo class
     * @param node the container node
     * @param name the properties name (not to confuse with the pseudo class name, those may be different)
     * @param def the initial value
     */
    protected PseudoClassProperty(PseudoClass cls, Node node, String name, boolean def) {
        super(def);
        this.cls = cls;
        this.node = node;
        this.name = name;
    }

    @Override
    protected void invalidated() {
        this.node.pseudoClassStateChanged(this.cls, get());
    }

    @Override
    public Object getBean() {
        return this.node;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * creates a new PseudoClassProperty.
     * 
     * @param cls the pseudo class
     * @param node the container node
     * @param name the properties name (not to confuse with the pseudo class name, those may be different)
     * @param def the initial value
     * @return the new property
     */
    public static BooleanProperty create(PseudoClass cls, Node node, String name, boolean def) {
        return new PseudoClassProperty(cls, node, name, def);
    }
    
    /**
     * creates a new PseudoClassProperty.
     * <p>
     * Convenience method if you do not need to hold the instance of the PseudoClass
     * </p>
     * @param pseudoClass the pseudo class string
     * @param node the container node
     * @param name the properties name (not to confuse with the pseudo class name, those may be different)
     * @param def the initial value
     * @return the new property
     */
    public static BooleanProperty create(String pseudoClass, Node node, String name, boolean def) {
        return new PseudoClassProperty(PseudoClass.getPseudoClass(pseudoClass), node, name, def);
    }
}
