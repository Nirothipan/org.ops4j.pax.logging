/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.ops4j.pax.logging.test.juli;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FactoryTest {

    @Test
    public void paxLoggingSpecificJuliLoggingFactory() {
        Log log = LogFactory.getLog(this.getClass());
        log.info("Factory: " + LogFactory.getFactory().getClass().getName());
        log.info("Log: " + log);

        // no delegation here
        assertTrue(LogFactory.getFactory().getClass().getName().startsWith("org.apache.juli.logging"));
        // pax-logging version here
        assertTrue(log.getClass().getName().startsWith("org.ops4j.pax.logging.juli"));
    }

}
