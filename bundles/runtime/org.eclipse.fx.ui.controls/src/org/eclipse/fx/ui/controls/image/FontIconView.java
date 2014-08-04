package org.eclipse.fx.ui.controls.image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;








import com.sun.javafx.css.converters.InsetsConverter;
import com.sun.javafx.css.converters.PaintConverter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.css.CssMetaData;
import javafx.css.FontCssMetaData;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.StyleOrigin;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.control.Labeled;
import javafx.scene.control.Skin;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class FontIconView extends Control {

	public FontIconView() {
		 getStyleClass().setAll("fonticonview");
		 
		 setMouseTransparent(true);
	}
	
	@Override
	protected String getUserAgentStylesheet() {
		String uri = FontIconView.class.getResource("fonticonview.css").toExternalForm();
		return uri;
	}
	
    /**
     * Most Controls return true for focusTraversable, so Control overrides
     * this method to return true, but Label returns false for
     * focusTraversable's initial value; hence the override of the override. 
     * This method is called from CSS code to get the correct initial value.
     * @treatAsPrivate implementation detail
     */
   @Deprecated @Override
   protected /*do not make final*/ Boolean impl_cssGetFocusTraversableInitialValue() {
       return Boolean.FALSE;
   }  
	
	private  ObjectProperty<FontIcon> icon;
	public ObjectProperty<FontIcon> iconProperty() {
		if (icon == null) {
			icon = new SimpleStyleableObjectProperty<FontIcon>(StyleableProperties.ICON, FontIcon.create('?'));
		}
		return icon;
	}
	
	public void setIcon(FontIcon icon) {
		this.iconProperty().set(icon);
	}
	
	public FontIcon getIcon() {
		return icon == null ? null : icon.get();
	}
	
    /**
     * The default font to use for text in the Labeled. If the Label's text is
     * rich text then this font may or may not be used depending on the font
     * information embedded in the rich text, but in any case where a default
     * font is required, this font will be used.
     */
    public final ObjectProperty<Font> fontProperty() {

        if (font == null) {
            font = new StyleableObjectProperty<Font>(Font.getDefault()) {

                private boolean fontSetByCss = false;

                @Override
                public void applyStyle(StyleOrigin newOrigin, Font value) {
                	System.err.println("applyStyle " + font + " " + value);
                	System.err.println(" origin " + newOrigin);
                    //
                    // RT-20727 - if CSS is setting the font, then make sure invalidate doesn't call impl_reapplyCSS
                    //
                    try {
                        // super.applyStyle calls set which might throw if value is bound.
                        // Have to make sure fontSetByCss is reset.
                        fontSetByCss = true;
                        super.applyStyle(newOrigin, value);
                    } catch(Exception e) {
                        throw e;
                    } finally {
                        fontSetByCss = false;
                    }
                }

                @Override
                public void set(Font value) {
                    final Font oldValue = get();
                    if (value != null ? !value.equals(oldValue) : oldValue != null) {
                        super.set(value);
                    }

                }
                
                @Override
                protected void invalidated() {
                    // RT-20727 - if font is changed by calling setFont, then
                    // css might need to be reapplied since font size affects
                    // calculated values for styles with relative values
                    if(fontSetByCss == false) {
                        FontIconView.this.impl_reapplyCSS();
                    }
                }
                
                @Override 
                public CssMetaData<FontIconView,Font> getCssMetaData() {
                    return StyleableProperties.FONT;
                }

                @Override
                public Object getBean() {
                    return FontIconView.this;
                }

                @Override
                public String getName() {
                    return "font";
                }
            };
        }
        return font;
    }
    private ObjectProperty<Font> font;
    public final void setFont(Font value) { fontProperty().setValue(value); }
    public final Font getFont() { return font == null ? Font.getDefault() : font.getValue(); }
    
    /**
     * The padding around the Labeled's text and graphic content.
     * By default labelPadding is Insets.EMPTY and cannot be set to null.
     * Subclasses may add nodes outside this padding and inside the Labeled's padding.
     *
     * This property can only be set from CSS.
     */
    public final ReadOnlyObjectProperty<Insets> iconPaddingProperty() {
        return iconPaddingPropertyImpl();
    }
    private ObjectProperty<Insets> iconPaddingPropertyImpl() {
        if (iconPadding == null) {
        	System.err.println("INIT iconPadding");
            iconPadding = new StyleableObjectProperty<Insets>(Insets.EMPTY) {
                private Insets lastValidValue = Insets.EMPTY;

//                @Override
//                public void set(Insets v) {
//                	// TODO Auto-generated method stub
//                	super.set(v);
//                }
//                
//                @Override
//                public void setValue(Insets v) {o
//                	// TODO Auto-generated method stub
//                	super.setValue(v);
//                }
                
                
                @Override
                public void invalidated() {
                	
                    final Insets newValue = get();
                    if (newValue == null) {
                        set(lastValidValue);
                        throw new NullPointerException("cannot set iconPadding to null");
                    }
                    lastValidValue = newValue;
                    requestLayout();
                }
                
                @Override
                public CssMetaData<FontIconView,Insets> getCssMetaData() {
                    return StyleableProperties.ICON_PADDING;
                }

                @Override
                public Object getBean() {
                    return FontIconView.this;
                }

                @Override
                public String getName() {
                    return "iconPadding";
                }
            };
        }
        return iconPadding;
    }
    private ObjectProperty<Insets> iconPadding;
    private void setIconPadding(Insets value) { iconPaddingPropertyImpl().set(value); }
    public final Insets getIconPadding() { return iconPadding == null ? Insets.EMPTY : iconPadding.get(); }

    /**
     * The {@link Paint} used to fill the text.
     */
    private ObjectProperty<Paint> iconFill; // TODO for now change this

    public final void setIconFill(Paint value) {
        iconFillProperty().set(value);
    }

    public final Paint getIconFill() {
        return iconFill == null ? Color.BLACK : iconFill.get();
    }

    public final ObjectProperty<Paint> iconFillProperty() {
        if (iconFill == null) {
            iconFill = new StyleableObjectProperty<Paint>(Color.BLACK) {
                
                @Override 
                public CssMetaData<FontIconView,Paint> getCssMetaData() {
                    return StyleableProperties.ICON_FILL;
                }

                @Override
                public Object getBean() {
                    return FontIconView.this;
                }

                @Override
                public String getName() {
                    return "iconFill";
                }
            };
        }
        return iconFill;
    }
    
    private static class StyleableProperties {
        private static final FontCssMetaData<FontIconView> FONT = 
            new FontCssMetaData<FontIconView>("-fx-font", Font.getDefault()) {

            @Override
            public boolean isSettable(FontIconView n) {
                return n.font == null || !n.font.isBound();
            }

            @Override
            public StyleableProperty<Font> getStyleableProperty(FontIconView n) {
                return (StyleableProperty)n.fontProperty();
            }
            
        };
        
        private static final CssMetaData<FontIconView, FontIcon> ICON = 
        	new CssMetaData<FontIconView, FontIcon>("-fx-icon", new FontIconStyleConverter()) {
				@Override
				public boolean isSettable(FontIconView styleable) {
					return true;
				}
	
				@Override
				public StyleableProperty<FontIcon> getStyleableProperty(FontIconView styleable) {
					return (StyleableProperty)styleable.iconProperty();
				}
			};
			private static final CssMetaData<FontIconView,Insets> ICON_PADDING = 
		            new CssMetaData<FontIconView, Insets>("-fx-icon-padding", InsetsConverter.getInstance(), Insets.EMPTY) {

		            @Override
		            public boolean isSettable(FontIconView n) {
		                return n.iconPadding == null || !n.iconPadding.isBound();
		            }

		            @Override
		            public StyleableProperty<Insets> getStyleableProperty(FontIconView n) {
		                return (StyleableProperty)n.iconPaddingPropertyImpl();
		            }
		        };
		        
		        private static final CssMetaData<FontIconView,Paint> ICON_FILL = 
		                new CssMetaData<FontIconView,Paint>("-fx-icon-fill",
		                PaintConverter.getInstance(), Color.BLACK) {

		            @Override
		            public boolean isSettable(FontIconView n) {
		                return n.iconFill == null || !n.iconFill.isBound();
		            }

		            @Override
		            public StyleableProperty<Paint> getStyleableProperty(FontIconView n) {
		                return (StyleableProperty)n.iconFillProperty();
		            }
		        };
		        
			
			 private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;
		        static {
		            final List<CssMetaData<? extends Styleable, ?>> styleables =
		                new ArrayList<CssMetaData<? extends Styleable, ?>>(Control.getClassCssMetaData());
		            Collections.addAll(styleables,
		                FONT,
		                ICON,
		                ICON_FILL,
		                ICON_PADDING
		            );
		            STYLEABLES = Collections.unmodifiableList(styleables);
		        }
		   
    }
    
    /**
     * @return The CssMetaData associated with this class, which may include the
     * CssMetaData of its super classes.
     * @since JavaFX 8.0
     */
    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return StyleableProperties.STYLEABLES;
    }

    /**
     * {@inheritDoc}
     * @since JavaFX 8.0
     */
    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        return getClassCssMetaData();
    }
	
}
