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

package org.md2k.dsu.mapper;

import org.junit.runner.RunWith;
import org.md2k.dsu.domain.DataSample;
import org.openmhealth.dsu.configuration.TransientIntegrationTestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author Emerson Farrugia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        TransientIntegrationTestConfiguration.class,
        DataSampleDataPointMapperResolverIntegrationTests.class
})
@Configuration
@ComponentScan(basePackageClasses = DataPointMapper.class)
public class DataSampleDataPointMapperResolverIntegrationTests
        extends DataPointMapperResolverIntegrationTests<DataSample> {

    @Autowired
    private DataPointMapperResolver<DataSample> resolver;

    @Override
    protected DataPointMapperResolver<DataSample> getResolver() {
        return resolver;
    }
}