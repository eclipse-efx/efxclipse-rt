package org.eclipse.fx.text.hover;

import org.eclipse.jface.text.IRegion;

public class HoverInfo {

	private final HoverInfoType type;
	private final IRegion region;
	private final String hoverText;
	private final Object hoverModel;
	
	private final CharSequence hoverContent;

	@Deprecated
	public HoverInfo(HoverInfoType type, IRegion region, String hoverText, Object hoverModel) {
		this.type = type;
		this.region = region;
		this.hoverText = hoverText;
		this.hoverModel = hoverModel;
		this.hoverContent = hoverText;
	}
	
	public HoverInfo(HoverInfoType type, IRegion region, CharSequence hoverContent, Object hoverModel) {
		this.type = type;
		this.region = region;
		this.hoverText = hoverContent.toString();
		this.hoverModel = hoverModel;
		this.hoverContent = hoverContent;
	}

	public HoverInfoType getType() {
		return type;
	}

	public IRegion getRegion() {
		return region;
	}

	public String getHoverText() {
		return hoverText;
	}
	
	public CharSequence getHoverContent() {
		return hoverContent;
	}

	public Object getHoverModel() {
		return hoverModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoverText == null) ? 0 : hoverText.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoverInfo other = (HoverInfo) obj;
		if (hoverText == null) {
			if (other.hoverText != null)
				return false;
		} else if (!hoverText.equals(other.hoverText))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		return true;
	}




}
