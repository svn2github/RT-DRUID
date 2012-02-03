/**
 * Created on 31/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.reader;

import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;

/**
 * @author Nicola Serreli
 *
 */
interface IParserConstants {

    final static String LOCATION = "Location_inside_the_oil";

    final static String[] ATTR_ATT_LIST = {
                    IOilXMLLabels.ATTR_AUTO,
                    IOilXMLLabels.ATTR_DEFAULT_VALUE,
                    IOilXMLLabels.ATTR_MULTIPLE_VALUES,
                    IOilXMLLabels.ATTR_TYPE,
                    IOilXMLLabels.ATTR_WITH_AUTO
            };
    final static String[] ATTR_REF_LIST = {
                    IOilXMLLabels.ATTR_MULTIPLE_VALUES,
                    IOilXMLLabels.ATTR_OBJ_TYPE,
            };
    final static String[] ATTR_VAR_LIST = {
                    IOilXMLLabels.ATTR_DEFAULT_VALUE,
                    IOilXMLLabels.ATTR_MULTIPLE_VALUES,
                    IOilXMLLabels.ATTR_WITH_AUTO
            };
    final static String[] ATTR_RANGE_LIST = {
                    IOilXMLLabels.ATTR_MAX,
                    IOilXMLLabels.ATTR_MIN
            };

}
