/*
 * Copyright 2011- the original author or authors.
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
package no.entitas.gradle

class VersionNumber implements Comparable {
    String branchName
    BigDecimal version
    BigDecimal nextVersion

    public VersionNumber(String tagName) {
        def tagNameParts = tagName.split('-')
        version = new BigDecimal(tagNameParts[-1])
        nextVersion = version.add(BigDecimal.ONE)
        branchName = tagNameParts[0]
    }

    def nextVersionTag() {
        return "$branchName-REL-$nextVersion"
    }

    def String toString() {
        return "$branchName-REL-$version"
    }

    int compareTo(other) {
        version.compareTo(other.version)
    }
}