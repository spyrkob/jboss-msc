/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.msc.service;

/**
 * A listener for service lifecycle events.  The associated controller will not leave its current state until
 * all listeners finish running.
 */
public interface ServiceListener<S> {

    /**
     * The service is starting.
     *
     * @param controller the controller
     */
    void serviceStarting(ServiceController<? extends S> controller);

    /**
     * The service is started (up).
     *
     * @param controller the controller
     */
    void serviceStarted(ServiceController<? extends S> controller);

    /**
     * The service start has failed.
     *
     * @param controller the controller
     * @param reason the reason for failure
     */
    void serviceFailed(ServiceController<? extends S> controller, StartException reason);

    /**
     * The service is stopping.
     *
     * @param controller the controller
     */
    void serviceStopping(ServiceController<? extends S> controller);

    /**
     * The service is stopped (down).
     *
     * @param controller the controller
     */
    void serviceStopped(ServiceController<? extends S> controller);

    /**
     * The service has been removed.  The listener will automatically be unregistered after this call.
     *
     * @param controller the controller
     */
    void serviceRemoved(ServiceController<? extends S> controller);
}
