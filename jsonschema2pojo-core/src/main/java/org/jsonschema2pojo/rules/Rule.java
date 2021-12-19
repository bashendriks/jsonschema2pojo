/**
 * Copyright © 2010-2020 Nokia
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

/**
 *
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

package nl.basch.jsonschema2pojo.rules;

import nl.basch.jsonschema2pojo.Schema;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Represents a JSON Schema rule (production from JSON Schema). Can be executed
 * or 'applied' to perform the code generation steps associated with that schema
 * rule.
 * 
 * @param <T>
 *            The type of source code item on which this rule can operate
 * @param <R>
 *            The type of the source code item generated by this rule
 */
public interface Rule<T, R> {

    /**
     * Add whatever Java source is required to the given generatable to
     * represent this schema rule.
     * 
     * @param nodeName
     *            the name of the JSON schema node
     * @param node
     *            the JSON schema node that has caused this rule to be applied
     * @param parent
     *            the JSON parent of {@code node}
     * @param generatableType
     *            A code generation construct to which this rule should be
     *            applied
     * @param currentSchema
     *            the schema to which this schema rule (and the given node)
     *            belongs.
     * @return the newly generated source code item that was added/created as a
     *         result of executing this rule
     */
    R apply(String nodeName, JsonNode node, JsonNode parent, T generatableType, Schema currentSchema);

}
