/*******************************************************************************
 * Copyright (c) 2018 EclipseSource and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Camille Letavernier<camille.letavernier@eclipsesource.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.tests.status;

import java.util.stream.Stream;

import org.eclipse.fx.core.MultiStatus;
import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.junit.Assert;
import org.junit.Test;

public class TestMultiStatus {
	
	private static final String MESSAGE = "MultistatusTest";
	private static final int CODE = 3;
	
	@Test
	public void testEmptyStatus() {
		MultiStatus status = Stream.<Status>empty().collect(MultiStatus.toMultiStatus(MESSAGE, CODE));
		Assert.assertNotNull(status);
		Assert.assertEquals(MESSAGE, status.getMessage());
		Assert.assertTrue(status.isOk());
		Assert.assertEquals(CODE, status.getCode());
		Assert.assertEquals(0, status.getChildren().size());
	}
	
	@Test
	public void testSingleOkStatus() {
		Status okStatus = Status.ok();
		MultiStatus status = Stream.of(okStatus).collect(MultiStatus.toMultiStatus(MESSAGE, CODE));
		Assert.assertNotNull(status);
		Assert.assertEquals(MESSAGE, status.getMessage());
		Assert.assertTrue(status.isOk());
		Assert.assertEquals(CODE, status.getCode());
		Assert.assertEquals(1, status.getChildren().size());
		Assert.assertEquals(okStatus, status.getChildren().get(0));
	}
	
	@Test
	public void testSingleWarningStatus() {
		Status warningStatus = Status.status(State.WARNING, 2, "Some message", null);
		MultiStatus status = Stream.of(warningStatus).collect(MultiStatus.toMultiStatus(MESSAGE, CODE));
		Assert.assertNotNull(status);
		Assert.assertEquals(MESSAGE, status.getMessage());
		Assert.assertTrue(status.isNotOk());
		Assert.assertEquals(State.WARNING, status.getState());
		Assert.assertEquals(CODE, status.getCode());
		Assert.assertEquals(1, status.getChildren().size());
		Assert.assertEquals(warningStatus, status.getChildren().get(0));
	}
	
	@Test
	public void testMultipleStatuses() {
		Status okStatus = Status.ok();
		Status errorStatus = Status.status(State.ERROR, 1, "Something", null);
		Status warningStatus = Status.status(State.WARNING, Status.UNKNOWN_RETURN_CODE, "Something else", null);
		
		MultiStatus status = Stream.of(okStatus, errorStatus, warningStatus).collect(MultiStatus.toMultiStatus(MESSAGE, CODE));
		
		Assert.assertNotNull(status);
		Assert.assertEquals(MESSAGE, status.getMessage());
		Assert.assertTrue(status.isNotOk());
		Assert.assertEquals(State.ERROR, status.getState()); // The MS severity is the worst severity, from all child statuses
		Assert.assertEquals(CODE, status.getCode());
		Assert.assertEquals(3, status.getChildren().size());
		
		Assert.assertEquals(okStatus, status.getChildren().get(0));
		Assert.assertEquals(errorStatus, status.getChildren().get(1));
		Assert.assertEquals(warningStatus, status.getChildren().get(2));
	}
	
	@Test
	public void testAggregateStatuses() {
		// Start from OK
		Status okStatus = Status.ok();
		MultiStatus multiStatus = Stream.of(okStatus).collect(MultiStatus.toMultiStatus(MESSAGE, CODE));
		
		Assert.assertFalse(multiStatus.isNotOk());
		
		// Add a warning
		Status warningStatus = Status.status(State.WARNING, Status.UNKNOWN_RETURN_CODE, "Something", null);
		
		multiStatus.add(warningStatus);
		
		Assert.assertTrue(multiStatus.isNotOk());
		Assert.assertEquals(State.WARNING, multiStatus.getState());
		Assert.assertEquals(2, multiStatus.getChildren().size());
		
		// Add a cancel
		Status cancelStatus = Status.status(State.CANCEL, 1, null, null);
		
		multiStatus.add(cancelStatus);
		
		Assert.assertTrue(multiStatus.isNotOk());
		Assert.assertEquals(State.WARNING, multiStatus.getState());
		Assert.assertEquals(3, multiStatus.getChildren().size());
		
		// Add an error
		Status errorStatus = Status.status(State.ERROR, 2, "Error", new NullPointerException());
		
		multiStatus.add(errorStatus);
		
		Assert.assertTrue(multiStatus.isNotOk());
		Assert.assertEquals(State.ERROR, multiStatus.getState());
		Assert.assertEquals(4, multiStatus.getChildren().size());
		
		// Add a null status
		Status nullStatus = null;
		multiStatus.add(nullStatus);
		
		Assert.assertFalse(multiStatus.isOk());
		Assert.assertEquals(State.ERROR, multiStatus.getState());
		Assert.assertEquals(4, multiStatus.getChildren().size());
	}
	
}
