/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.claudedemo.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/**
 * Sling Model for Card Component
 * Provides title, description, link URL and link text properties
 */
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CardModel {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String linkUrl;

    @ValueMapValue
    private String linkText;

    @PostConstruct
    protected void init() {
        // Initialize if needed - currently no additional logic required
    }

    /**
     * Get the card title
     * @return the title string
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the card description
     * @return the description string
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the link URL
     * @return the link URL string
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * Get the link text
     * @return the link text string
     */
    public String getLinkText() {
        return linkText;
    }
}
