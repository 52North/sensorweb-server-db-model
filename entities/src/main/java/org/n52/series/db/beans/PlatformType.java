/*
 * Copyright 2015-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.series.db.beans;

public enum PlatformType {

    // TODO make more fine granular:
    // MOBILE
    // INSITU
    // STATIONARY
    // REMOTE

    STATIONARY_INSITU,
    STATIONARY_REMOTE,
    MOBILE_INSITU,
    MOBILE_REMOTE;

    public static final String PLATFORM_TYPE_MOBILE = "mobile";

    public static final String PLATFORM_TYPE_STATIONARY = "stationary";

    public static final String PLATFORM_TYPE_INSITU = "insitu";

    public static final String PLATFORM_TYPE_REMOTE = "remote";

    public static final String PLATFORM_TYPE_ALL = "all";

    public String getPlatformType() {
        return name().toLowerCase();
    }

    private String getIdPrefix() {
        return name().toLowerCase();
    }

    public String createId(Long id) {
        return getIdPrefix() + "_" + Long.toString(id);
    }

    public String createId(String id) {
        return getIdPrefix() + "_" + id;
    }

    public boolean isInsitu() {
        return this == PlatformType.STATIONARY_INSITU
                || this == PlatformType.MOBILE_INSITU;
    }

    public boolean isRemote() {
        return this == PlatformType.STATIONARY_REMOTE
                || this == PlatformType.MOBILE_REMOTE;
    }

    public boolean isStationary() {
        return this == STATIONARY_INSITU
                || this == STATIONARY_REMOTE;
    }

    public boolean isMobile() {
        return this == PlatformType.MOBILE_INSITU
                || this == MOBILE_REMOTE;
    }

    public static String extractId(String id) {
        if (isStationaryId(id)) {
            return isInsitu(id)
                    ? extractId(STATIONARY_INSITU, id)
                    : extractId(STATIONARY_REMOTE, id);
        } else if (isMobileId(id)) {
            return isInsitu(id)
                    ? extractId(MOBILE_INSITU, id)
                    : extractId(MOBILE_REMOTE, id);
        } else {
            return id;
        }
    }

    private static String extractId(PlatformType type, String id) {
        final int maxLength = type.getIdPrefix()
                                  .length()
                + 1;
        return id.length() >= maxLength
                ? id.substring(maxLength)
                : id;
    }

    public static boolean isStationaryId(String id) {
        return startsWith(PLATFORM_TYPE_STATIONARY, id);
    }

    public static boolean isMobileId(String id) {
        return startsWith(PLATFORM_TYPE_MOBILE, id);
    }

    private static boolean startsWith(String prefix, String id) {
        final String idPrefix = extractPrefix(id);
        if (!isKnownType(idPrefix)) {
            return false;
        }
        return id.toLowerCase()
                 .startsWith(prefix);
    }

    public static boolean isRemoteId(String id) {
        return hasSuffix(PLATFORM_TYPE_REMOTE, id);
    }

    public static boolean isInsitu(String id) {
        return hasSuffix(PLATFORM_TYPE_INSITU, id);
    }

    private static boolean hasSuffix(String suffix, String id) {
        final String idPrefix = extractPrefix(id);
        if (!isKnownType(idPrefix)) {
            return false;
        }
        final PlatformType geometryType = toInstance(idPrefix);
        return geometryType.getPlatformType()
                           .endsWith(suffix);
    }

    public static boolean isKnownType(String typeName) {
        for (PlatformType type : values()) {
            if (type.getPlatformType()
                    .equalsIgnoreCase(typeName)) {
                return true;
            }
        }
        return false;
    }

    private static String extractPrefix(String id) {
        for (PlatformType type : PlatformType.values()) {
            final String prefix = type.getPlatformType();
            if (id != null && id.toLowerCase()
                                .startsWith(prefix)) {
                return prefix;
            }
        }
        return id;
    }

    public static PlatformType toInstance(String typeName) {
        for (PlatformType type : values()) {
            if (type.getIdPrefix()
                    .equalsIgnoreCase(typeName)) {
                return type;
            }
            if (type.getPlatformType()
                    .equalsIgnoreCase(typeName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("no type for '" + typeName + "'.");
    }

    public static PlatformType toInstance(boolean mobile, boolean insitu) {
        if (mobile) {
            return insitu
                    ? MOBILE_INSITU
                    : MOBILE_REMOTE;
        } else {
            return insitu
                    ? STATIONARY_INSITU
                    : STATIONARY_REMOTE;
        }
    }

}
