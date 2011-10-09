/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venky.swa.views.resource;

import com.venky.swf.routing.Path;
import com.venky.swf.views.HtmlView;
import com.venky.swf.views.controls.page.Body;
import com.venky.swf.views.controls.page.layout.Div;
import com.venky.swf.views.controls.page.text.TextBox;

/**
 *
 * @author venky
 */
public class Index extends HtmlView{
    public Index(Path path){
        super(path);
    }
    
    @Override
    protected void createBody(Body body){
        TextBox input = new TextBox();
        input.setAutocompleteServiceURL(getPath().controllerPath()+"/autocompleteCountry/");
        
        Div uiwidget = new Div(); 
        uiwidget.setProperty("class", "ui-widget");
        uiwidget.addControl(input);
        /*
        Div div = new Div();
        div.setProperty("class", "demo");
        div.addControl(uiwidget);
        */
        
        body.addControl(uiwidget);
    }
}