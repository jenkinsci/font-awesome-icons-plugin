/*
 * The MIT License
 *
 * Copyright (c) 2013-2014, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins.fontawesome;

import hudson.Plugin;
import org.jenkinsci.plugins.uithemes.UIThemeContributor;
import org.jenkinsci.plugins.uithemes.model.UIThemeContribution;
import org.jenkinsci.plugins.uithemes.model.UIThemeSet;

/**
 * @author <a href="mailto:tom.fennelly@gmail.com">tom.fennelly@gmail.com</a>
 */
public class PluginImpl extends Plugin implements UIThemeContributor {

    @Override
    public void contribute(UIThemeSet themeSet) {
        //
        // The Font Awesome icons theme impl is very simple since it is not configurable. All we do
        // here is:
        //
        //      1. Register the "font-awesome-icons" theme implementation
        //      2. Add a contribution for the core "font-awesome-icons" icons.
        //         NOTE: other plugins can also make contributions to the "font-awesome-icons" impl,
        //               adding their icons.
        //      3. define the LESS template for the core "font-awesome-icons" icon styles
        //
        //      See below.
        //

        // #1 ...
        themeSet.registerThemeImpl("icons", "font-awesome-icons", "Font Awesome", "Scalable vector iconic font");

        // #2 ... (NB: other plugins can also perform this step to add their font-awesome icons)
        themeSet.contribute(new UIThemeContribution("font-awesome-icons-core", "icons", "font-awesome-icons", PluginImpl.class));

        // #3 ...
        // see core/src/main/resources/jenkins-themes/icons/font-awesome-icons/font-awesome-icons-core/theme-template.less
    }
}
