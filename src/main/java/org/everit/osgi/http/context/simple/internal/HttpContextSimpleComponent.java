/**
 * This file is part of Everit - HTTP Context Simple.
 *
 * Everit - HTTP Context Simple is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - HTTP Context Simple is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - HTTP Context Simple.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.http.context.simple.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import org.apache.felix.http.whiteboard.HttpWhiteboardConstants;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.everit.osgi.http.context.simple.HttpContextSimpleConstants;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.http.HttpContext;

@Component(name = HttpContextSimpleConstants.SERVICE_FACTORYPID_RESOURCE, metatype = true,
        configurationFactory = true, policy = ConfigurationPolicy.REQUIRE)
@Properties({
        @Property(name = HttpWhiteboardConstants.CONTEXT_ID,
                value = HttpContextSimpleConstants.DEFAULT_CONTEXT_ID),
        @Property(name = HttpWhiteboardConstants.CONTEXT_SHARED, boolValue = true)
})
public class HttpContextSimpleComponent {

    private ServiceRegistration<HttpContext> httpContextSR;

    @Activate
    public void activate(final BundleContext context, final Map<String, Object> componentProperties)
            throws Exception {
        String contextId = getStringProperty(componentProperties, HttpWhiteboardConstants.CONTEXT_ID);
        Boolean shared = Boolean
                .valueOf(getStringProperty(componentProperties, HttpWhiteboardConstants.CONTEXT_SHARED));

        HttpContext httpContext = new HttpContextSimple();
        Dictionary<String, Object> properties = new Hashtable<String, Object>();
        properties.put(HttpWhiteboardConstants.CONTEXT_ID, contextId);
        properties.put(HttpWhiteboardConstants.CONTEXT_SHARED, shared);
        httpContextSR = context.registerService(HttpContext.class, httpContext, properties);
    }

    @Deactivate
    public void deactivate() {
        if (httpContextSR != null) {
            httpContextSR.unregister();
            httpContextSR = null;
        }
    }

    private String getStringProperty(final Map<String, Object> componentProperties, final String propertyName)
            throws ConfigurationException {
        Object value = componentProperties.get(propertyName);
        if (value == null) {
            throw new ConfigurationException(propertyName, "property not defined");
        }
        return String.valueOf(value);
    }

}
