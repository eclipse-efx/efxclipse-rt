package org.eclipse.fx.text.rules;

import org.eclipse.jface.text.rules.ICharacterScanner;

@SuppressWarnings("restriction")
public class CheckPointScanner implements ICharacterScanner {
	private final ICharacterScanner realScanner;
	private int charCount;

	public CheckPointScanner(ICharacterScanner realScanner) {
		this.realScanner = realScanner;
	}

	@Override
	public char[][] getLegalLineDelimiters() {
		return this.realScanner.getLegalLineDelimiters();
	}

	@Override
	public int getColumn() {
		return this.getColumn();
	}

	@Override
	public int read() {
		this.charCount++;
		return this.read();
	}

	@Override
	public void unread() {
		this.charCount--;
		this.unread();
	}

	public void setCheckpoint() {
		this.charCount = 0;
	}

	public void rollbackToCheckPoint() {
		while( charCount > 0 ) {
			// Important we are not calling ourselves!!!
			realScanner.unread();
			charCount--;
		}
	}
}
