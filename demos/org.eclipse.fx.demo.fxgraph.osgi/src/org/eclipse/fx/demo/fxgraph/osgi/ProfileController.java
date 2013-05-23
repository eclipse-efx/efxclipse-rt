/*
 * Copyright (c) 2008, 2011 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.eclipse.fx.demo.fxgraph.osgi;

import java.net.URL;
import java.util.ResourceBundle;

import org.eclipse.fx.demo.fxgraph.osgi.model.User;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;

/**
 * Java FX FXML Controller.
 */
public class ProfileController implements Initializable {
    @FXML private TextField user;
    @FXML private TextField phone;
    @FXML private TextField email;
    @FXML private TextArea address;
    @FXML private CheckBox subscribed;
    @FXML private Label success;
    
    @Override public void initialize(URL location, ResourceBundle resources) {
        User loggedUser = Application.getInstance().getLoggedUser();
        user.setText(loggedUser.getId());
        if(loggedUser.getEmail() != null) {
            email.setText(loggedUser.getEmail());
        }
        if(loggedUser.getPhone() != null) {
            phone.setText(loggedUser.getPhone());
        }
        if(loggedUser.getAddress() != null) {
            address.setText(loggedUser.getAddress());
        }
        subscribed.setSelected(loggedUser.isSubscribed());
        success.setOpacity(0);
    }
    
    @FXML protected void processLogout(ActionEvent event) {
        Application.getInstance().userLogout();
    }
    
    @FXML protected void processUpdate(ActionEvent event) {
        User loggedUser = Application.getInstance().getLoggedUser();
        loggedUser.setEmail(email.getText());
        loggedUser.setPhone(phone.getText());
        loggedUser.setSubscribed(subscribed.isSelected());
        loggedUser.setAddress(address.getText());
        animateMessage();
    }

    private void animateMessage() {
        FadeTransition ft = new FadeTransition(new Duration(3000), success);
        ft.setFromValue(0.0);
        ft.setToValue(1);
        ft.play();
    }    
}
