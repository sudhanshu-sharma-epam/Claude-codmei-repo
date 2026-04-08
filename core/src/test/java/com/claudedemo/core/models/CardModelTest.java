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

import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.day.cq.wcm.api.Page;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import com.claudedemo.core.testcontext.AppAemContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test for CardModel
 */
@ExtendWith(AemContextExtension.class)
class CardModelTest {

    private final AemContext context = AppAemContext.newAemContext();

    private CardModel cardModel;

    private Page page;
    private Resource resource;

    @BeforeEach
    public void setup() throws Exception {
        // prepare a page with a test resource
        page = context.create().page("/content/mypage");
        resource = context.create().resource(page, "card",
            "sling:resourceType", "claudedemo/components/card",
            "title", "Test Card Title",
            "description", "Test card description text",
            "linkUrl", "/content/test-page",
            "linkText", "Read More");

        // create sling model
        cardModel = resource.adaptTo(CardModel.class);
    }

    @Test
    void testCardModelNotNull() {
        assertNotNull(cardModel, "CardModel should not be null");
    }

    @Test
    void testGetTitle() {
        String title = cardModel.getTitle();
        assertNotNull(title, "Title should not be null");
        assertEquals("Test Card Title", title, "Title should match");
    }

    @Test
    void testGetDescription() {
        String description = cardModel.getDescription();
        assertNotNull(description, "Description should not be null");
        assertEquals("Test card description text", description, "Description should match");
    }

    @Test
    void testGetLinkUrl() {
        String linkUrl = cardModel.getLinkUrl();
        assertNotNull(linkUrl, "Link URL should not be null");
        assertEquals("/content/test-page", linkUrl, "Link URL should match");
    }

    @Test
    void testGetLinkText() {
        String linkText = cardModel.getLinkText();
        assertNotNull(linkText, "Link text should not be null");
        assertEquals("Read More", linkText, "Link text should match");
    }

    @Test
    void testCardModelWithOptionalFields() throws Exception {
        // Test with minimal properties
        Resource minimalResource = context.create().resource(page, "card-minimal",
            "sling:resourceType", "claudedemo/components/card",
            "title", "Minimal Card");

        CardModel minimalCard = minimalResource.adaptTo(CardModel.class);
        assertNotNull(minimalCard, "CardModel should not be null even with minimal properties");
        assertEquals("Minimal Card", minimalCard.getTitle(), "Title should match");
    }
}
