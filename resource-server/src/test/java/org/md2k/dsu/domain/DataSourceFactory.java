/*
 * Copyright 2016 Open mHealth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.md2k.dsu.domain;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.md2k.dsu.domain.MCerebrumApplicationFactory.newApplication;
import static org.md2k.dsu.domain.MCerebrumPlatformAppFactory.newPlatformApp;
import static org.md2k.dsu.domain.MCerebrumPlatformFactory.newPlatform;


/**
 * @author Emerson Farrugia
 */
public class DataSourceFactory {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static DataSource newDataSource() {
        return newDataSource(newApplication(), newPlatform(), newPlatformApp());
    }

    public static DataSource newDataSource(MCerebrumApplication application, MCerebrumPlatform platform,
            MCerebrumPlatformApp platformApp) {

        DataSource dataSource = new DataSource();

        dataSource.setId(1L);
        dataSource.setIdentifier("");
        dataSource.setType("HEART_RATE");
        dataSource.setCreationTimestamp(LocalDateTime.of(2016, 4, 14, 9, 45, 20, 0));
        dataSource.setModificationTimestamp(LocalDateTime.of(2016, 4, 14, 9, 45, 20, 0));
        dataSource.setApplication(application);
        dataSource.setPlatformApp(platformApp);
        dataSource.setPlatform(platform);
        try {
            dataSource.setDataDescriptor(objectMapper.readTree("[\n" +
                    "    {\n" +
                    "        \"NAME\": \"Heart Rate\",\n" +
                    "        \"UNIT\": \"beats/minute\",\n" +
                    "        \"DATA_TYPE\": \"double\",\n" +
                    "        \"FREQUENCY\": \"1 Hz\",\n" +
                    "        \"MAX_VALUE\": \"200\",\n" +
                    "        \"MIN_VALUE\": \"0\",\n" +
                    "        \"DESCRIPTION\": \"Current heart rate as read by the Band in beats/min\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"NAME\": \"Quality\",\n" +
                    "        \"UNIT\": \"enum [0: locked, 1: acquiring]\",\n" +
                    "        \"DATA_TYPE\": \"double\",\n" +
                    "        \"FREQUENCY\": \"1 Hz\",\n" +
                    "        \"MAX_VALUE\": \"1\",\n" +
                    "        \"MIN_VALUE\": \"0\",\n" +
                    "        \"DESCRIPTION\": \"Quality of the current heart rate reading\"\n" +
                    "    }\n" +
                    "]"));

            dataSource.setMetadata(objectMapper.readTree("{\n" +
                "    \"NAME\": \"Heart Rate\",\n" +
                "    \"UNIT\": \"beats/minute\",\n" +
                "    \"DATA_TYPE\": \"org.md2k.datakitapi.datatype.DataTypeIntArray\",\n" +
                "    \"FREQUENCY\": \"1 Hz\",\n" +
                "    \"DESCRIPTION\": \"Provides the number of beats per minute; also indicates if the heart rate sensor is fully locked on to the wearer?s heart rate.\"\n" +
                    "}"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataSource;
    }
}
