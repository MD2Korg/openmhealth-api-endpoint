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

import javax.persistence.*;
import java.io.Serializable;


/**
 * A source of data.
 *
 * @author Emerson Farrugia
 */
@Entity
@Table(name = "datasources")
public class DataSource implements Serializable {

    private static final long serialVersionUID = -5347099822992697959L;

    private Long id;
    private String identifier;
    private String type;
    private String dataDescriptor;
    private String metadata;
    private MCerebrumApplication application;
    private MCerebrumPlatform platform;
    private MCerebrumPlatformApp platformApp;


    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * TODO find a better description of this property
     *
     * @return a data source identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * TODO find a better description of this property
     *
     * @return the category this data source belongs to, for example {@code ACCELEROMETER_X}
     */
    @Column(name = "datasourcetype")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return a description of the array of sample values created by this data source as a JSON document
     *
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

    /**
     * @return the platform app this data source belongs to
     */
    @ManyToOne
    @JoinColumn(name = "m_cerebrum_platform_app_id")
    public MCerebrumPlatformApp getPlatformApp() {
        return platformApp;
    }

    public void setPlatformApp(MCerebrumPlatformApp platformApp) {
        this.platformApp = platformApp;
    }
}
