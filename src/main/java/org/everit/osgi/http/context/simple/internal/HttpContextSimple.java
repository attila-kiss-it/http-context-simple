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

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.http.HttpContext;

public class HttpContextSimple implements HttpContext {

    public HttpContextSimple() {
    }

    @Override
    public String getMimeType(final String name) {
        return null;
    }

    @Override
    public URL getResource(final String name) {
        return null;
    }

    @Override
    public boolean handleSecurity(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException {
        return true;
    }

}
