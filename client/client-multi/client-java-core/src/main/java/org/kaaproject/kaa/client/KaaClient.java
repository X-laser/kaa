/*
 * Copyright 2014 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.client;

import org.kaaproject.kaa.schema.base.Log;

/**
* <p>
* Base interface to operate with {@link Kaa} library.
* 
* This interface contain methods that are auto-generated based on client structures.
* </p>
* 
* @author Yaroslav Zeygerman
* @author Andrew Shvayka
*/
public interface KaaClient extends GenericKaaClient{

    /**
     * Adds new log record to local storage.
     *
     * @param record New log record object
     */
    void addLogRecord(Log record);
}
