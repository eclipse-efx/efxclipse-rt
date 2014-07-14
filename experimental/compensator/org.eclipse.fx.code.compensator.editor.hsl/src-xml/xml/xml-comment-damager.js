var f = function() {
	var IPresentationDamager = Java.type("org.eclipse.jface.text.presentation.IPresentationDamager");
	var IPresentationRepairer = Java.type("org.eclipse.jface.text.presentation.IPresentationRepairer");
	var StyleRange = Java.type("org.eclipse.fx.ui.controls.styledtext.StyleRange");
	var Color = Java.type("javafx.scene.paint.Color");
	var Math = Java.type("java.lang.Math");
	var Region = Java.type("org.eclipse.jface.text.Region");
	
	var XMLDamagerRepairer = Java.extend( IPresentationDamager, IPresentationRepairer );
	return xmlDamagerRepairer = new XMLDamagerRepairer() {
		document : 0,
		setDocument : function(document) {
			this.fDocument = document;
		},
		endOfLineOf : function() {
			var info = this.fDocument.getLineInformationOfOffset(offset);
			if (offset <= info.getOffset() + info.getLength()) {
				return info.getOffset() + info.getLength();
			}
			var line = this.fDocument.getLineOfOffset(offset);
			try {
				info = this.fDocument.getLineInformation(line + 1);
				return info.getOffset() + info.getLength();
			} catch (x) {
				return this.fDocument.getLength();
			}
		},
		getDamageRegion : function(partition, event, documentPartitioningChanged) {
			if (!documentPartitioningChanged) {
				try {
					var info =
						this.fDocument.getLineInformationOfOffset(event.getOffset());
					var start = Math.max(partition.getOffset(), info.getOffset());
	
					var end =
						event.getOffset()
							+ (event.getText() == null
								? event.getLength()
								: event.getText().length());
	
					if (info.getOffset() <= end
						&& end <= info.getOffset() + info.getLength()) {
						// optimize the case of the same line
						end = info.getOffset() + info.getLength();
					} else
						end = endOfLineOf(end);
	
					end =
						Math.min(
							partition.getOffset() + partition.getLength(),
							end);
					return new Region(start, end - start);
	
				} catch (x) {
					x.printStackTrace();
				}
			}
	
			return partition;		
		},
		createPresentation : function(presentation, region) {
			presentation.addStyleRange( 
				new StyleRange(
					"xml_comment",
					region.getOffset(),
					region.getLength(),
					Color.rgb(128, 0, 0),
					null
				)
			);
		}
	};
};

f();