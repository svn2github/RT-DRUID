/*
 * Created on 24-giu-2005
 *
 * $Id: ConfigFileTemplate.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.project.templates;


import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.eu.evidence.rtdruid.desk.RtdruidLog;


/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class ConfigFileTemplate {
    
    private static String DEFAULT_TEMPLATE = null;

    
    public static synchronized String getDefaultTemplate() {
        if (DEFAULT_TEMPLATE == null) {
            // load from file
            InputStream input = ConfigFileTemplate.class.getResourceAsStream("/com/eu/evidence/rtdruid/modules/oil/cdt/ui/project/templates/basicConfigTemplate.txt");
            if (input != null) {
                
                // prepare all buffers
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                BufferedInputStream buffered = new BufferedInputStream(input);
                int value;
                
                // try to read all data
                try {
                    
                    while (true) {
                        value = buffered.read();
                        if (value == -1) {
                            break;
                        }
                        output.write(value);
                    }
                } catch (IOException e) {
                    // log errors
                    RtdruidLog.log(e);
                    
                } finally {
                    try {
                        input.close();
                    } catch (IOException e) {
                        
                    }
                }
                
                DEFAULT_TEMPLATE = output.toString();
            }
            
            // if there was some error, init the template as empty
            if (DEFAULT_TEMPLATE == null) {
                DEFAULT_TEMPLATE = "";
            }
            
        }
        return DEFAULT_TEMPLATE;
    }
    
    public static InputStream asStream(String txt) {
        return new ByteArrayInputStream(txt.getBytes());
    }
    
}
