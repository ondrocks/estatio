/*
 *
 *  Copyright 2012-2014 Eurocommercial Properties NV
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.estatio.dom.asset;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;

import org.apache.isis.applib.annotation.Programmatic;

import org.incode.module.base.dom.TitledEnum;
import org.incode.module.base.dom.utils.StringUtils;

public enum FixedAssetRoleType implements TitledEnum {

    PROPERTY_OWNER, 
    PROPERTY_MANAGER, 
    ASSET_MANAGER, 
    PROPERTY_CONTACT,
    TENANTS_ASSOCIATION;

    public String title() {
        return StringUtils.enumTitle(this.toString());
    }
    
    @Programmatic
    public Predicate<? super FixedAssetRole> matchingRole() {
        return new Predicate<FixedAssetRole>() {
            @Override
            public boolean apply(final FixedAssetRole far) {
                return far != null && Objects.equal(far.getType(), this) ? true : false;
            }
        };
    }

    public static class Meta {
        private Meta(){}

        public final static int MAX_LEN = 30;
    }

}
