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

import org.springframework.data.annotation.Id;

import javax.persistence.*;


/**
 * A source of data.
 *
 * @author Emerson Farrugia
 */
@Entity
@Table(name = "datasources")
public class DataSource {

    private Long id;
    private String dataSourceType;
    private String dataDescriptor;
    private String metadata;
    private MCerebrumApplication application;
    private MCerebrumPlatform platform;


    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the category this data source belongs to, for example {@code ACCELEROMETER_X}
     */
    @Column(name = "datasourcetype")
    public String getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    /**
     * @return a description of the array of sample values created by this data source as a JSON document
     * @see {@link DataSample#getValue()}
     */
    @Column(name = "datadescriptor")
    public String getDataDescriptor() {
        return dataDescriptor;
    }

    public void setDataDescriptor(String dataDescriptor) {
        this.dataDescriptor = dataDescriptor;
    }

    /**
     * @return metadata about this data source as a JSON document
     */
    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    /**
     * @return the application this data source belongs to
     */
    @ManyToOne
    @JoinColumn(name = "m_cerebrum_application_id")
    public MCerebrumApplication getApplication() {
        return application;
    }

    public void setApplication(MCerebrumApplication application) {
        this.application = application;
    }

    /**
     * @return the platform this data source belongs to
     */
    @ManyToOne
    @JoinColumn(name = "m_cerebrum_platform_id")
    public MCerebrumPlatform getPlatform() {
        return platform;
    }

    public void setPlatform(MCerebrumPlatform platform) {
        this.platform = platform;
    }
}