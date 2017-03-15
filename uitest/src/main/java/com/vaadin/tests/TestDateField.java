/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vaadin.tests;

import java.util.Locale;

import com.vaadin.server.ClassResource;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.UserError;
import com.vaadin.ui.AbstractDateField;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Vaadin Ltd.
 */
public class TestDateField extends CustomComponent {

    VerticalLayout main = new VerticalLayout();

    AbstractDateField<?, ?> df;

    public TestDateField() {
        setCompositionRoot(main);
        createNewView();
    }

    public void createNewView() {
        main.removeAllComponents();
        main.addComponent(new Label("DateField"));

        df = new com.vaadin.tests.components.TestDateField();
        main.addComponent(df);

        final ErrorMessage errorMsg = new UserError("User error " + df);
        df.setCaption("DateField caption " + df);
        df.setDescription("DateField description " + df);
        df.setComponentError(errorMsg);
        // FIXME: bug #1138 this makes datefield to render with unknown
        // component (UIDL tree debug)
        df.addStyleName("thisShouldBeHarmless");

        // Another test: locale
        final AbstractDateField<?, ?> df1 = new com.vaadin.tests.components.TestDateField(
                "US locale");
        main.addComponent(df1);
        df1.setLocale(new Locale("en", "US"));

        final AbstractDateField<?, ?> df2 = new com.vaadin.tests.components.TestDateField(
                "DE locale");
        main.addComponent(df2);
        df2.setLocale(new Locale("de", "DE"));

        final AbstractDateField<?, ?> df3 = new com.vaadin.tests.components.TestDateField(
                "RU locale");
        main.addComponent(df3);
        df3.setLocale(new Locale("ru", "RU"));

        final AbstractDateField<?, ?> df4 = new com.vaadin.tests.components.TestDateField(
                "FI locale");
        main.addComponent(df4);
        df4.setLocale(new Locale("fi", "FI"));
    }

    @Override
    public void attach() {
        final ClassResource res = new ClassResource("m.gif");
        df.setIcon(res);
        super.attach();
    }
}
