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
package org.everit.osgi.http.context.simple;

/**
 * Constants of the HTTP Context Simple component.
 */
public final class HttpContextSimpleConstants {

    /**
     * The service factory PID of the HTTP Context Simple component.
     */
    public static final String SERVICE_FACTORYPID_RESOURCE = "org.everit.osgi.http.context.simple.HttpContextSimple";

    /**
     * The default value of the {@link org.apache.felix.http.whiteboard.HttpWhiteboardConstants#CONTEXT_ID} parameter of
     * the HTTP Context Simple component.
     */
    public static final String DEFAULT_CONTEXT_ID = "defaultContext";

    private HttpContextSimpleConstants() {
    }

}
